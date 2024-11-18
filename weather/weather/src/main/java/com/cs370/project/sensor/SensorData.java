package com.cs370.project.sensor;

/**
 * This is a POJA Data transfer object for sending data to the client.
 */
public class SensorData {

    public float temperature;
    public int gas;
    public float humidity;
    public float pressure;

    public SensorData() {
        this.temperature = 0.0f;
        this.gas = 0;
        this.humidity = 0.0f;
        this.pressure = 0.0f;
    }

    public SensorData(float temperature, int gas, float humidity, float pressure) {
        this.temperature = temperature;
        this.gas = gas;
        this.humidity = humidity;
        this.pressure = pressure;
    }

}