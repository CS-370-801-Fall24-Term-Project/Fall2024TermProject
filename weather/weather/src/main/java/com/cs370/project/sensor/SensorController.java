package com.cs370.project.sensor;

import com.sensor.Sensor;

public class SensorController {

    private Sensor sensor;

    public void SensorController() throws Exception {
        init();
    }

    private void init() throws Exception {
        if (this.sensor == null) {
            this.sensor = Sensor.getInstance();
        }
    }

    /**
     * Gets the temperature reading as float.
     */
    public float getTemperature() throws Exception {
        init();
        return this.sensor.getTemperature();
    }

    /**
     * Gets the gas reading as int.
     */
    public int getGas() throws Exception {
        init();
        return this.sensor.getGas();
    }

    /**
     * Gets the humidity reading as float.
     */
    public float getHumidity() throws Exception {
        init();
        return this.sensor.getHumidity();
    }

    /**
     * Gets the pressure reading as float.
     */
    public float getPressure() throws Exception {
        init();
        return this.sensor.getPressure();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        try {
            builder.append(String.format("Temperature: %f degrees C\n", this.getTemperature()));
            builder.append(String.format("Gas: %d ohms\n", this.getGas()));
            builder.append(String.format("Humidity: %f%%\n", this.getHumidity()));
            builder.append(String.format("Pressure: %fhPa\n", this.getPressure()));
        
        } catch (Exception e) {
            builder.append(e.getMessage());
        }
        return builder.toString();
    }
    
}