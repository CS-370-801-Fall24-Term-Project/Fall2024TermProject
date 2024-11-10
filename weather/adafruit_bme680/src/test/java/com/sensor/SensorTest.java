package com.sensor;

import com.adafruit.bme680.Adafruit_BME680;
import com.adafruit.bme680.Adafruit_BME680_I2C;
import com.adafruit.bme680.I2CController;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class SensorTest {

    private static final String CLASS_NAME = "com.sensor.Sensor";

    private Sensor sensor;

    @Test
    @DisplayName("jmaksuta: Test Sensor is initialized.")
    public void testSensor() {
        assertDoesNotThrow(()->{
            this.sensor = Sensor.getInstance();
        });
        assertNotNull(this.sensor, "The controller SensorController() is null.");
    }

    // @Test
    // @DisplayName("jmaksuta: test the demo code")
    public void testDemoCode() {
        boolean isPassed = false;
        StringBuilder builder = new StringBuilder();
        try {
            I2CController i2c = new I2CController("bme680", 1, 0x77);
            Adafruit_BME680 sensor = new Adafruit_BME680_I2C(i2c, 0x77, false, 100);
            
            print(String.format("Temperature: %f degrees C", sensor.temperature()));
            print(String.format("Gas: %d ohms", sensor.gas()));
            print(String.format("Humidity: %f%%", sensor.humidity()));
            print(String.format("Pressure: %fhPa", sensor.pressure()));
            isPassed = true;

        } catch (Exception e) {
            isPassed = false;
            builder.append(e.getMessage());
        } finally {
            assertTrue(isPassed, String.format("The test failed for class %s, reason: %s", CLASS_NAME, builder.toString()));
        }
    }

    @Test
    @DisplayName("jmaksuta: test the getTemperature method")
    public void test_getTemperature_method() {
        boolean isPassed = false;
        StringBuilder builder = new StringBuilder();
        try {
            this.sensor = sensor.getInstance();
            float actual = this.sensor.getTemperature();
            String expected = "actual != 0.0f";

            isPassed = (actual != 0.0f);

            if (!isPassed) {
                builder.append(String.format("expected=%s, actual=%f", expected, actual));
            }
        
        } catch (Exception e) {
            isPassed = false;
            builder.append(e.getMessage());
        } finally {
            assertTrue(isPassed, String.format("The test failed for class %s, reason: %s", CLASS_NAME, builder.toString()));
        }
    }

    
    @Test
    @DisplayName("jmaksuta: test the getGas method")
    public void test_getGas_method() {
        boolean isPassed = false;
        StringBuilder builder = new StringBuilder();
        try {
            this.sensor = sensor.getInstance();
            int actual = this.sensor.getGas();
            String expected = "actual != 0";

            isPassed = (actual != 0);

            if (!isPassed) {
                builder.append(String.format("expected=%s, actual=%d", expected, actual));
            }
        
        } catch (Exception e) {
            isPassed = false;
            builder.append(e.getMessage());
        } finally {
            assertTrue(isPassed, String.format("The test failed for class %s, reason: %s", CLASS_NAME, builder.toString()));
        }
    }

    
    @Test
    @DisplayName("jmaksuta: test the getHumidity method")
    public void test_getHumidity_method() {
        boolean isPassed = false;
        StringBuilder builder = new StringBuilder();
        try {
            this.sensor = sensor.getInstance();
            float actual = this.sensor.getHumidity();
            String expected = "actual != 0.0f";

            isPassed = (actual != 0.0f);

            if (!isPassed) {
                builder.append(String.format("expected=%s, actual=%f", expected, actual));
            }
        
        } catch (Exception e) {
            isPassed = false;
            builder.append(e.getMessage());
        } finally {
            assertTrue(isPassed, String.format("The test failed for class %s, reason: %s", CLASS_NAME, builder.toString()));
        }
    }

    
    @Test
    @DisplayName("jmaksuta: test the getPressure method")
    public void test_getPressure_method() {
        boolean isPassed = false;
        StringBuilder builder = new StringBuilder();
        try {
            this.sensor = sensor.getInstance();
            float actual = this.sensor.getPressure();
            String expected = "actual != 0.0f";

            isPassed = (actual != 0.0f);

            if (!isPassed) {
                builder.append(String.format("expected=%s, actual=%f", expected, actual));
            }
        
        } catch (Exception e) {
            isPassed = false;
            builder.append(e.getMessage());
        } finally {
            assertTrue(isPassed, String.format("The test failed for class %s, reason: %s", CLASS_NAME, builder.toString()));
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }

}