package com.sensor.demo;

import com.adafruit.bme680.Adafruit_BME680;
import com.adafruit.bme680.Adafruit_BME680_I2C;
import com.adafruit.bme680.I2CController;

public class SensorDemo {

    public static void main(String[] args) {
        try {
            I2CController i2c = new I2CController("bme680", 1, 0x77);
            Adafruit_BME680 sensor = new Adafruit_BME680_I2C(i2c, 0x77, true, 100);
            // BME680 bme680 = new BME680();
            // Adafruit_BME680_I2C sensor = new BME680.Adafruit_BME680_I2C(i2c, 0x77, true, 100);
            // sensor = adafruit_bme680.Adafruit_BME680_I2C(i2c)
            print(String.format("Temperature: %f degrees C", sensor.temperature()));
            // print('Temperature: {} degrees C'.format(sensor.temperature))
            print(String.format("Gas: %d ohms", sensor.gas()));
            // print('Gas: {} ohms'.format(sensor.gas))
            print(String.format("Humidity: %f%%", sensor.humidity()));
            // print('Humidity: {}%'.format(sensor.humidity))
            print(String.format("Pressure: %fhPa", sensor.pressure()));
            // print('Pressure: {}hPa'.format(sensor.pressure))

        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }

}
