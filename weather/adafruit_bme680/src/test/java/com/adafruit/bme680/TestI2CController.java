package com.adafruit.bme680;

// import java.lang.module.ModuleDescriptor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestI2CController {

    I2CController controller;

    @BeforeAll
    public static void setUpBeforeClass() {
        // Code to run once before all tests
        System.out.println("Before all tests");
    }

    @BeforeEach
    public void setUp() {
        // Code to run before each test
        System.out.println("Before each test");
        this.controller = new I2CController("BME680", 1, 0x77);
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
    public void testI2CController() {
        I2CController controller = new I2CController("BME680", 1, 0x77);
        assertNotNull(controller);
    }

    @Test
    @DisplayName("jmaksuta: I2CController write method.")
    public void testI2CController_write() {
        boolean isPassed = false;
        StringBuilder builder = new StringBuilder();
        try {
            byte[] toWrite = new byte[]{0x00};
            int register = 0x00;
            this.controller.write(register, toWrite);

            isPassed = true;

        } catch (Exception e) {
            builder.append(e.getMessage());
        } finally {
            assertTrue(isPassed, builder.toString());
        }
    }

    @Test
    @DisplayName("jmaksuta: I2CController read method.")
    public void testI2CController_read() {
        boolean isPassed = false;
        StringBuilder builder = new StringBuilder();
        try {
            int readByte = -1;
            int register = 0xD0;
            readByte = this.controller.read(register);

            isPassed = (readByte != -1);

        } catch (Exception e) {
            builder.append(e.getMessage());
        } finally {
            assertTrue(isPassed, builder.toString());
        }
    }

}
