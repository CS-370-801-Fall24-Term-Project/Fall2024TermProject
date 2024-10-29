package com.adafruit.bme680;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Adafruit_BME680Test {
    
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
    @DisplayName("jmaksuta: test Adafruit_BME680")
    public void testAdafruit_BME680() {
        Object actual = null;
        StringBuilder builder = new StringBuilder();
        try {
            // assertTrue(false);
            // int address = 0x77;
            // boolean debug = true;
            // int bus = 1;
            // int refreshRate = 100;
            // I2CController i2CController = new I2CController("BME680", bus, address);
            // // Adafruit_BME680 adafruit_BME680_I2C = new Adafruit_BME680(i2CController, address, debug, refreshRate);

            // actual = adafruit_BME680_I2C;

        } catch (Exception e) {
            builder.append(e.getMessage());
        } finally {
            // assertNotNull(actual, builder.toString());
        }
    }

    
    @Test
    @DisplayName("jmaksuta: test Adafruit_BME680 _BME680_REG_SOFTRESET")
    public void testAdafruit_BME680_softReset() {
        boolean isPassed = false;
        StringBuilder builder = new StringBuilder();
        try {
            int address = 0x77;
            int bus = 1;
            I2CController controller = new I2CController("BME680", bus, address);

            controller.write(BME680._BME680_REG_SOFTRESET, new byte[]{(byte) 0xB6});
            Thread.sleep(5);

            isPassed = true;

        } catch (Exception e) {
            isPassed = false;
            builder.append(e.getMessage());
        } finally {
            assertTrue(isPassed, builder.toString());
        }
    }

    @Test
    @DisplayName("jmaksuta: test Adafruit_BME680 chip id")
    public void testAdafruit_BME680_chipId() {
        boolean isPassed = false;
        StringBuilder builder = new StringBuilder();
        try {
            int address = 0x77;
            int bus = 1;
            I2CController controller = new I2CController("BME680", bus, address);

            int chip_id =  (int) controller.readByte(BME680._BME680_REG_CHIPID);
            if (chip_id != BME680._BME680_CHIPID) {
                throw new RuntimeException(String.format("Failed to find BME680! Chip ID 0x%02X", chip_id));
            }

            int actual = chip_id;
            int expected = BME680._BME680_CHIPID;

            printOut(String.format("chipid=%d", actual));

            isPassed = (actual == expected);
            if (!isPassed) {
                builder.append(String.format("expected=%d, actual=%d\n", expected, actual));
            }

            assertEquals(expected, actual);

        } catch (Exception e) {
            isPassed = false;
            builder.append(e.getMessage());
        } finally {
            assertTrue(isPassed, builder.toString());
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

    public void printOut(String message) {
        System.out.println(message);
    }

}