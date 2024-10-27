package com.adafruit.bme680;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.i2c.I2C;
import com.pi4j.io.i2c.I2CConfig;
import com.pi4j.io.i2c.I2CProvider;

public class I2CController implements AutoCloseable {

    private static final byte TCA9534_REG_ADDR_OUT_PORT = 0x01;
    private static final byte TCA9534_REG_ADDR_CFG = 0x03;

    private Context pi4j;
    private I2CProvider i2CProvider;
    private I2CConfig i2cConfig;

    public I2CController() {
        super();
        this.pi4j = Pi4J.newAutoContext();
        this.i2CProvider = pi4j.provider("linuxfs-i2c");
        this.i2cConfig = I2C.newConfigBuilder(pi4j).id("TCA9534").bus(1).device(0x3f).build();
    }

    public I2CController(String id, int bus, byte address) {
        super();
        this.pi4j = Pi4J.newAutoContext();
        this.i2CProvider = pi4j.provider("linuxfs-i2c");
        this.i2cConfig = I2C.newConfigBuilder(pi4j).id("TCA9534").bus(1).device(0x3f).build();
    }

    public static void main(String[] args) throws Exception {

        // this.pi4j = Pi4J.newAutoContext();
        // I2CProvider i2CProvider = pi4j.provider("linuxfs-i2c");
        // I2CConfig i2cConfig = I2C.newConfigBuilder(pi4j).id("TCA9534").bus(1).device(0x3f).build();
        I2CController controller = new I2CController();
        try (final I2C tca9534Dev = controller.i2CProvider.create(controller.i2cConfig)) {

            int config = tca9534Dev.readRegister(TCA9534_REG_ADDR_CFG);
            if (config < 0) {
                throw new IllegalStateException(
                        "Failed to read configuration from address 0x" + String.format("%02x", TCA9534_REG_ADDR_CFG));
            }

            byte currentState = (byte) tca9534Dev.readRegister(TCA9534_REG_ADDR_OUT_PORT);

            if (config != 0x00) {
                System.out.println("TCA9534 is not configured as OUTPUT, setting register 0x" + String
                        .format("%02x", TCA9534_REG_ADDR_CFG) + " to 0x00");
                currentState = 0x00;
                tca9534Dev.writeRegister(TCA9534_REG_ADDR_OUT_PORT, currentState);
                tca9534Dev.writeRegister(TCA9534_REG_ADDR_CFG, (byte) 0x00);
            }

            // bit 8, is pin 1 on the board itself, so set pins in reverse:
            currentState = setPin(currentState, 8, tca9534Dev, true);
            Thread.sleep(500L);
            currentState = setPin(currentState, 8, tca9534Dev, false);
            Thread.sleep(500L);

            currentState = setPin(currentState, 7, tca9534Dev, true);
            Thread.sleep(500L);
            currentState = setPin(currentState, 7, tca9534Dev, false);
            Thread.sleep(500L);
        }
    }

    public static byte setPin(byte currentState, int pin, I2C tca9534Dev, boolean high) {
        byte newState;
        if (high) {
            newState = (byte) (currentState | (1 << pin));
        } else {
            newState = (byte) (currentState & ~(1 << pin));
        }

        System.out.println("Setting TCA9534 to new state " + asBinary(newState));
        tca9534Dev.writeRegister(TCA9534_REG_ADDR_OUT_PORT, newState);
        return newState;
    }

    public static String asBinary(byte b) {
        StringBuilder sb = new StringBuilder();

        sb.append(((b >>> 7) & 1));
        sb.append(((b >>> 6) & 1));
        sb.append(((b >>> 5) & 1));
        sb.append(((b >>> 4) & 1));
        sb.append(((b >>> 3) & 1));
        sb.append(((b >>> 2) & 1));
        sb.append(((b >>> 1) & 1));
        sb.append(((b >>> 0) & 1));

        return sb.toString();
    }

    @Override
    public void close() throws Exception {
        // throw new UnsupportedOperationException("Not supported yet.");
        pi4j.shutdown();
    }

    void write(byte[] buffer) throws Exception {
        try (I2C tca9534Dev = i2CProvider.create(i2cConfig)) {

            int config = tca9534Dev.readRegister(TCA9534_REG_ADDR_CFG);
            if (config < 0) {
                throw new IllegalStateException(
                        "Failed to read configuration from address 0x" + String.format("%02x", TCA9534_REG_ADDR_CFG));
            }

            byte currentState = (byte) tca9534Dev.readRegister(TCA9534_REG_ADDR_OUT_PORT);

            if (config != 0x00) {
                System.out.println("TCA9534 is not configured as OUTPUT, setting register 0x" + String
                        .format("%02x", TCA9534_REG_ADDR_CFG) + " to 0x00");
                currentState = 0x00;
                tca9534Dev.writeRegister(TCA9534_REG_ADDR_OUT_PORT, currentState);
                tca9534Dev.writeRegister(TCA9534_REG_ADDR_CFG, (byte) 0x00);
            }

            // bit 8, is pin 1 on the board itself, so set pins in reverse:
            currentState = setPin(currentState, 8, tca9534Dev, true);
            Thread.sleep(500);
            currentState = setPin(currentState, 8, tca9534Dev, false);
            Thread.sleep(500);

            currentState = setPin(currentState, 7, tca9534Dev, true);
            Thread.sleep(500);
            currentState = setPin(currentState, 7, tca9534Dev, false);
            Thread.sleep(500);
        }
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    public void readInto(byte[] buffer) throws Exception {
        try (I2C tca9534Dev = i2CProvider.create(i2cConfig)) {

            int config = tca9534Dev.readRegister(TCA9534_REG_ADDR_CFG);
            if (config < 0) {
                throw new IllegalStateException(
                        "Failed to read configuration from address 0x" + String.format("%02x", TCA9534_REG_ADDR_CFG));
            }

            byte currentState = (byte) tca9534Dev.readRegister(TCA9534_REG_ADDR_OUT_PORT);

            if (config != 0x00) {
                System.out.println("TCA9534 is not configured as OUTPUT, setting register 0x" + String
                        .format("%02x", TCA9534_REG_ADDR_CFG) + " to 0x00");
                currentState = 0x00;
                tca9534Dev.writeRegister(TCA9534_REG_ADDR_OUT_PORT, currentState);
                tca9534Dev.writeRegister(TCA9534_REG_ADDR_CFG, (byte) 0x00);
            }

            // bit 8, is pin 1 on the board itself, so set pins in reverse:
            currentState = setPin(currentState, 8, tca9534Dev, true);
            Thread.sleep(500);
            currentState = setPin(currentState, 8, tca9534Dev, false);
            Thread.sleep(500);

            currentState = setPin(currentState, 7, tca9534Dev, true);
            Thread.sleep(500);
            currentState = setPin(currentState, 7, tca9534Dev, false);
            Thread.sleep(500);
        }
        // throw new UnsupportedOperationException("Not supported yet.");
    }

}
