package com.adafruit.bme680;

// import java.nio.ByteBuffer;
// import java.nio.ByteOrder;

// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Collectors;

/**
 * Driver for I2C connected BME680. :param ~busio.I2C i2c: The I2C bus the
 * BME680 is connected to. :param int address: I2C device address. Defaults to
 * :const:`0x77` :param bool debug: Print debug statements when `True`. Defaults
 * to `False` :param int refresh_rate: Maximum number of readings per second.
 * Faster property reads will be from the previous reading. **Quickstart:
 * Importing and using the BME680** Here is an example of using the
 * :class:`BMP680_I2C` class. First you will need to import the libraries to use
 * the sensor .. code-block:: python import board import adafruit_bme680 Once
 * this is done you can define your ``board.I2C`` object and define your sensor
 * object .. code-block:: python i2c = board.I2C() # uses board.SCL and
 * board.SDA bme680 = adafruit_bme680.Adafruit_BME680_I2C(i2c) You need to setup
 * the pressure at sea level .. code-block:: python bme680.sea_level_pressure =
 * 1013.25 Now you have access to the :attr:`temperature`, :attr:`gas`,
 * :attr:`relative_humidity`, :attr:`pressure` and :attr:`altitude` attributes
 * .. code-block:: python temperature = bme680.temperature gas = bme680.gas
 * relative_humidity = bme680.relative_humidity pressure = bme680.pressure
 * altitude = bme680.altitude
 */
public class Adafruit_BME680_I2C extends Adafruit_BME680 {

    private I2CController controller;
    private int address = 0x77;
    private boolean debug = false;
    private int refresh_rate = 10;

    /**
     * Initialize the I2C device at the 'address' given Initialize the I2C
     * device at the 'address' given
     */
    public Adafruit_BME680_I2C(I2CController i2c, int address, boolean debug, int refresh_rate) throws Exception {
        super();
        this.controller = i2c;
        this.address = address;
        // i2c_device.I2CDevice(i2c, address);
        this.debug = debug;
        this.refresh_rate = refresh_rate;
        init(refresh_rate);
    }

    /**
     * Returns an array of 'length' bytes from the 'register'
     */
    @Override
    public byte[] _read(int register, int length) {
        byte[] result = new byte[]{};
        try {
            byte[] toWrite = new byte[]{(byte) (register & 0xFF)};
            controller.write(register, toWrite);
            result = new byte[length];
            controller.readInto(register, result);
            if (this.debug) {
                System.out.printf("\t$%02X <= [%s]\n", register, getByteArrayString(result));
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    /**
     * Writes an array of 'length' bytes to the 'register'
     */
    @Override
    public void _write(int register, byte[] values) {
        try {
            controller.write(register, values);
            if (this.debug) {
                System.out.printf("\t$%02X <= [%s]", values[0], getByteArrayString(values));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public float getTemperature() throws Exception {
        return this.temperature();
    }

    @Override
    public int getGas() throws Exception {
        return this.gas();
    }

    @Override
    public float getHumidity() throws Exception {
        return this.humidity();
    }

    @Override
    public float getPressure() throws Exception {
        return this.pressure();
    }

}
