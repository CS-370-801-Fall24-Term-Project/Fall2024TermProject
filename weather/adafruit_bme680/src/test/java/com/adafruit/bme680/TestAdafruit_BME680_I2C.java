package com.adafruit.bme680;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestAdafruit_BME680_I2C {
    
    // Adafruit_BME680_I2C adafruit_BME680_I2C;

    @BeforeAll
    public static void setUpBeforeClass() {
        // Code to run once before all tests
        System.out.println("Before all tests");
    }

    @BeforeEach
    public void setUp() {
        // Code to run before each test
        System.out.println("Before each test");
        // this.controller = new I2CController("BME680", 1, 0x77);
    }

    @AfterEach
    public void tearDown() {
        // Code to run after each test
        System.out.println("After each test");
    }

    @AfterAll
    public static void tearDownAfterClass() {
        // Code to run once after all tests
        System.out.println("After all tests");
    }

    @Test
    @DisplayName("jmaksuta: test")
    public void testAdafruit_BME680_I2C() {
        Object actual = null;
        StringBuilder builder = new StringBuilder();
        try {
            int address = 0x77;
            boolean debug = true;
            int bus = 1;
            int refreshRate = 100;
            I2CController i2CController = new I2CController("BME680", bus, address);
            Adafruit_BME680_I2C adafruit_BME680_I2C = new Adafruit_BME680_I2C(i2CController, address, debug, refreshRate);

            actual = adafruit_BME680_I2C;

        } catch (Exception e) {
            builder.append(e.getMessage());
        } finally {
            assertNotNull(actual, builder.toString());
        }
    }

    // @Test
    // @DisplayName("jmaksuta: I2CController write method.")
    // public void testI2CController_write() {
    //     boolean isPassed = false;
    //     StringBuilder builder = new StringBuilder();
    //     try {
    //         byte[] toWrite = new byte[] {};
    //         this.controller.write(toWrite);
            
    //         isPassed = true;

    //     } catch (Exception e) {
    //         builder.append(e.getMessage());
    //     } finally {
    //         assertTrue(isPassed, builder.toString());
    //     }
    // }

    // @Test
    // @DisplayName("jmaksuta: I2CController read method.")
    // public void testI2CController_read() {
    //     boolean isPassed = false;
    //     StringBuilder builder = new StringBuilder();
    //     try {
    //         int readByte = this.controller.read();
            
    //         isPassed = (readByte != -1);

    //     } catch (Exception e) {
    //         builder.append(e.getMessage());
    //     } finally {
    //         assertTrue(isPassed, builder.toString());
    //     }
    // }

}