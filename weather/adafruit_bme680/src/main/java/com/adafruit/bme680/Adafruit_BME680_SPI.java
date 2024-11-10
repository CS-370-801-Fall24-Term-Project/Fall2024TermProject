package com.adafruit.bme680;

/**
 * Driver for SPI connected BME680.
 *
 * :param ~busio.SPI spi: SPI device :param ~digitalio.DigitalInOut cs: Chip
 * Select :param bool debug: Print debug statements when `True`. Defaults to
 * `False` :param int baudrate: Clock rate, default is :const:`100000` :param
 * int refresh_rate: Maximum number of readings per second. Faster property
 * reads will be from the previous reading. **Quickstart: Importing and using
 * the BME680** Here is an example of using the :class:`BMP680_SPI` class. First
 * you will need to import the libraries to use the sensor .. code-block::
 * python import board from digitalio import DigitalInOut, Direction import
 * adafruit_bme680 Once this is done you can define your ``board.SPI`` object
 * and define your sensor object .. code-block:: python cs =
 * digitalio.DigitalInOut(board.D10) spi = board.SPI() bme680 =
 * adafruit_bme680.Adafruit_BME680_SPI(spi, cs) You need to setup the pressure
 * at sea level .. code-block:: python bme680.sea_level_pressure = 1013.25 Now
 * you have access to the :attr:`temperature`, :attr:`gas`,
 * :attr:`relative_humidity`, :attr:`pressure` and :attr:`altitude` attributes
 * .. code-block:: python temperature = bme680.temperature gas = bme680.gas
 * relative_humidity = bme680.relative_humidity pressure = bme680.pressure
 * altitude = bme680.altitude
 */
public class Adafruit_BME680_SPI extends Adafruit_BME680 {

    private SPIController spi;
    // private DigitalInOut cs;
    private Object cs;
    private int baudrate = 100000;
    private boolean debug = false;
    private int refresh_rate = 10;

// public Adafruit_BME680_SPI(SPIController spi, DigitalInOut cs, int baudrate) {
    public Adafruit_BME680_SPI(SPIController spi, Object cs, int baudrate, int refresh_rate) throws Exception {
        super();
        this.spi = spi;
        this.cs = cs;
//         self._spi = spi_device.SPIDevice(spi, cs, baudrate=baudrate)
        this.debug = debug;
        init(refresh_rate);
    }

    @Override
    public byte[] _read(int register, int length) {
        byte[] result = new byte[]{};
        if (register != _BME680_REG_STATUS) {
            // _BME680_REG_STATUS exists in both SPI memory pages
            // For all other registers, we must set the correct memory page
            this._set_spi_mem_page(register);
        }

        register = (register | 0x80) & 0xFF; // Read single, bit 7 high.
        try (final SPIController spi = this.spi) {
            spi.write(new byte[]{(byte) register});
            result = new byte[length];
            spi.readInto(result);
            spi.read(result, 0, length);
            // spi.write(bytearray([register]))
            // result = bytearray(length)
            // spi.readinto(result)
//             if self._debug:
//                 print(f"\t${register:02X} => {[hex(i) for i in result]}")
//             return result                    
        } catch (Exception e) {

        }
        return result;
    }

    @Override
    public void _write(int register, byte[] values) {
        if (register != _BME680_REG_STATUS) {
            // _BME680_REG_STATUS exists in both SPI memory pages
            // For all other registers, we must set the correct memory page
            this._set_spi_mem_page(register);
        }

        register &= 0x7F;  // Write, bit 7 low.

        try (final SPIController spi = this.spi) {
            byte[] buffer = new byte[2 * values.length];

            for (int i = 0; i < values.length; i++) {
                buffer[2 * i] = (byte) (register + i);
                buffer[(2 * i) + 1] = (byte) (values[i] & 0xFF);
            }
            this.spi.write(buffer);
            if (this.debug) {
                System.out.printf("\t$%02X <= [%s]", values[0], getByteArrayString(values));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void _set_spi_mem_page(int register) {
        byte spi_mem_page = 0x00;
        if (register < 0x80) {
            spi_mem_page = 0x10;
        }
        this._write(_BME680_REG_STATUS, new byte[]{spi_mem_page});
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
