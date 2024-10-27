package com.sensor.demo;

import com.adafruit.bme680.BME680;


public class SensorDemo {

    public static void main(String[] args) {

// import board
// import adafruit_bme680
// i2c = board.I2C()
        BME680 sensor = new BME680.Adafruit_BME680_I2C();
// sensor = adafruit_bme680.Adafruit_BME680_I2C(i2c)
        print(String.format("Temperature: %f degrees C", sensor.temperature()));
        // print('Temperature: {} degrees C'.format(sensor.temperature))
        print(String.format("Gas: %f ohms", sensor.gas()));
        // print('Gas: {} ohms'.format(sensor.gas))
        print(String.format("Humidity: %f%%", sensor.humidity()));
        // print('Humidity: {}%'.format(sensor.humidity))
        print(String.format("Pressure: %fhPa", sensor.pressure()));
        // print('Pressure: {}hPa'.format(sensor.pressure))

    }

    private void print(String message) {
        System.out.println(message);
    }

}