package com.cs370.project.sensor;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class SensorControllerTest {

    private static final String CLASS_NAME = "com.cs370.project.sensor.SensorController";

    private SensorController controller;

    @BeforeEach
    public void setupEach() {
        this.controller = new SensorController();
    }

    @Test
    @DisplayName("jmaksuta: Test sensor controller")
    public void testSensorController() {
        assertDoesNotThrow(()->{
            this.controller = new SensorController();
        }, "The constructor SensorController() failed with an exception.");
        assertNotNull(this.controller, "The controller SensorController() is null.");
    }

    @Test
    @DisplayName("jmaksuta: test the getTemperature method")
    public void test_getTemperature_method() {
        boolean isPassed = false;
        StringBuilder builder = new StringBuilder();
        try {
            this.controller = new SensorController();
            float actual = this.controller.getTemperature();
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
            this.controller = new SensorController();
            int actual = this.controller.getGas();
            String expected = "actual != 0";

            isPassed = (actual != 0);

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
    @DisplayName("jmaksuta: test the getHumidity method")
    public void test_getHumidity_method() {
        boolean isPassed = false;
        StringBuilder builder = new StringBuilder();
        try {
            this.controller = new SensorController();
            float actual = this.controller.getHumidity();
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
            this.controller = new SensorController();
            float actual = this.controller.getPressure();
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

}