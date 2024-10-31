package com.cs370.project.sensor;

import com.adafruit.bme680.Adafruit_BME680;

/**
 * @author John Maksuta
 * @since 2024
 */
public class SensorData {

    private float temperature;
    private int gas;
    private float humidity;
    private float pressure;

    public float getTemperature() {
        return temperature;
    }

    public int getGas() {
        return gas;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public SensorData() {
        super();
        this.temperature = 0f;
        this.gas = 0;
        this.humidity = 0f;
        this.pressure = 0f;
    }

    public SensorData(float temperature, int gas, float humidity, float pressure) {
        this();
        this.temperature = temperature;
        this.gas = gas;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public SensorData(Adafruit_BME680 sensor) throws Exception {
        this(sensor.temperature(), sensor.gas(), sensor.humidity(), sensor.pressure());
    }

    @Override
    public String toString() {
        return String.format("{ \"temperature\": %f, \"gas\": %d, \"humidity\": %f, \"pressure\": %f }", this.temperature, this.gas, this.humidity, this.pressure);
    }

}
