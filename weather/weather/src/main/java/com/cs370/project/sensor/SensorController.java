package com.cs370.project.sensor;

import com.adafruit.bme680.Adafruit_BME680;
import com.adafruit.bme680.Adafruit_BME680_I2C;
import com.adafruit.bme680.I2CController;

public class SensorController {

    public SensorData readSensor() {
        SensorData result = new SensorData();
        try {
            I2CController i2c = new I2CController("bme680", 1, 0x77);
            Adafruit_BME680 sensor = new Adafruit_BME680_I2C(i2c, 0x77, false, 100);

            result = new SensorData(sensor);
            
        } catch (Exception e) {
            // TODO: log exception.
            System.out.println(e.getMessage());
        }
        return result;
    }

}
