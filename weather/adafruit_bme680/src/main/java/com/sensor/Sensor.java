package com.sensor;

import com.adafruit.bme680.Adafruit_BME680;
import com.adafruit.bme680.Adafruit_BME680_I2C;
import com.adafruit.bme680.I2CController;

public class Sensor {

    private static Sensor instance;

    public static Sensor getInstance() throws Exception {
        if (instance == null) {
            instance = new Sensor();
        }
        return instance;
    }

    private Adafruit_BME680 sensor;
    private I2CController i2c;

    private Sensor() {
        init();
    }

    private void init() {
        try {
            if (this.i2c == null) {
                this.i2c = new I2CController("bme680", 1, 0x77);
            }
            if (this.sensor == null) {
                this.sensor = new Adafruit_BME680_I2C(i2c, 0x77, false, 100);
            }
        } catch (Exception e) {
            // do nothing.
        }
    }

    public float getTemperature() throws Exception {
        init();
        return this.sensor.getTemperature();
    }

    public int getGas() throws Exception {
        init();
        return this.sensor.getGas();
    }

    public float getHumidity() throws Exception {
        init();
        return this.sensor.getHumidity();
    }

    public float getPressure() throws Exception {
        init();
        return this.sensor.getPressure();
    }
}