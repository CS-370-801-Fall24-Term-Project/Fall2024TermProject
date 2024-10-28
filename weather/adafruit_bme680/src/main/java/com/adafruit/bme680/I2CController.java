package com.adafruit.bme680;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.i2c.I2C;
import com.pi4j.io.i2c.I2CConfig;
import com.pi4j.io.i2c.I2CProvider;
import com.pi4j.io.i2c.I2CRegister;
// import com.pi4j.io.i2c.I2CFactory;
// import com.pi4j.io.i2c.I2CFacade;
// import java.io.IOException;

/**
 * @author John Maksuta
 * @since 10/26/2024 Copyright 2024
 */
public class I2CController implements AutoCloseable {

    private static final byte TCA9534_REG_ADDR_OUT_PORT = 0x01;
    private static final byte TCA9534_REG_ADDR_CFG = 0x03;

    private String id;
    private int bus;
    private int address;
    private Context pi4j;
    private I2CProvider i2CProvider;
    private I2CConfig i2cConfig;

    public I2CController() {
        this("I2C Device", 1, 0x77);
    }

    public I2CController(String id, int bus, int address) {
        super();
        this.id = id;
        this.bus = bus;
        this.address = address;
        this.pi4j = Pi4J.newAutoContext();
        this.i2CProvider = pi4j.provider("linuxfs-i2c");
        this.i2cConfig = I2C.newConfigBuilder(pi4j).id(id).bus(bus).device(address).build();
    }

    // public static byte setPin(byte currentState, int pin, I2C tca9534Dev, boolean high) {
    //     byte newState;
    //     if (high) {
    //         newState = (byte) (currentState | (1 << pin));
    //     } else {
    //         newState = (byte) (currentState & ~(1 << pin));
    //     }

    //     System.out.println("Setting TCA9534 to new state " + asBinary(newState));
    //     tca9534Dev.writeRegister(TCA9534_REG_ADDR_OUT_PORT, newState);
    //     return newState;
    // }

    // public static String asBinary(byte b) {
    //     StringBuilder sb = new StringBuilder();

    //     sb.append(((b >>> 7) & 1));
    //     sb.append(((b >>> 6) & 1));
    //     sb.append(((b >>> 5) & 1));
    //     sb.append(((b >>> 4) & 1));
    //     sb.append(((b >>> 3) & 1));
    //     sb.append(((b >>> 2) & 1));
    //     sb.append(((b >>> 1) & 1));
    //     sb.append(((b >>> 0) & 1));

    //     return sb.toString();
    // }

    @Override
    public void close() throws Exception {
        pi4j.shutdown();
    }

    public int read(int register) throws Exception {
        int result = -1;
        Context context = Pi4J.newAutoContext();
        try (I2C i2c = context.create(this.i2cConfig)) {
            I2CRegister reg = i2c.register(register);
            result = reg.read();

        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    public byte readByte(int register) throws Exception {
        byte result = (byte)-1;
        Context context = Pi4J.newAutoContext();
        try (I2C i2c = context.create(this.i2cConfig)) {
            I2CRegister reg = i2c.register(register);
            result = reg.readByte();

        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    public void write(int register, byte data) throws Exception {
        Context context = Pi4J.newAutoContext();
        try (I2C i2c = context.create(this.i2cConfig)) {
            I2CRegister reg = i2c.register(register);
            int written = reg.write(data);
            if (written < 1) {
                throw new Exception(String.format("Data length = %d, bytes written = %d", 1, written));
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void write(int register, byte[] data) throws Exception {
        Context context = Pi4J.newAutoContext();
        try (I2C i2c = context.create(this.i2cConfig)) {
            I2CRegister reg = i2c.register(register);
            int written = reg.write(data);
            if (written < data.length) {
                throw new Exception(String.format("Data length = %d, bytes written = %d", data.length, written));
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public int read() {
        int result = -1;
        Context context = Pi4J.newAutoContext();
        try (I2C i2c = context.create(this.i2cConfig)) {
            result = i2c.read();

        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    public void readInto(int register, byte[] data) throws Exception {
        Context context = Pi4J.newAutoContext();
        try (I2C i2c = context.create(this.i2cConfig)) {
            I2CRegister reg = i2c.register(register);
            reg.read(data, 0, data.length);
            
        } catch (Exception e) {
            throw e;
        }
    }

}
