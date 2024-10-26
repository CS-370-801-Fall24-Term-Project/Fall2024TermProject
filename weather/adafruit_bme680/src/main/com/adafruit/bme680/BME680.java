package com.adafruit.bme680

//------------------------------
// """

// import math
// import struct
// import time

// from micropython import const

//----------------------------


/**
 * @author John Maksuta
 * @Copyright 10/26/2024
 * 
 * Created based on an original Python code "adafruit_bme680"
 * by 2017 ladyada for Adafruit Industries
 * under license MIT AND BSD-3-Clause
 * 
 * CircuitPython library for BME680 temperature, pressure and humidity sensor.
 * Author(s): Limor Fried, William Garber, many others
 * 
 * Implementation Notes
 * --------------------
 * 
 * **Hardware:**
 * 
 * * `Adafruit BME680 Temp, Humidity, Pressure and Gas Sensor <https://www.adafruit.com/product/3660>`_
 * 
 * **Software and Dependencies:**
 * 
 * * Adafruit CircuitPython firmware for the supported boards:
 * https://github.com/adafruit/circuitpython/releases
 * * Adafruit's Bus Device library: 
 * https://github.com/adafruit/Adafruit_CircuitPython_BusDevice
 * 
 */
public class BME680 {

    public BME680() {
        
    }


    public void delay_microseconds(Object nusec) {
//     """HELP must be same as dev->delay_us"""
//     time.sleep(nusec / 1000000.0)
    }

// try:
//     # Used only for type annotations.

//     import typing

//     from busio import I2C, SPI
//     from circuitpython_typing import ReadableBuffer
//     from digitalio import DigitalInOut

// except ImportError:
//     pass

// __version__ = "0.0.0+auto.0"
// __repo__ = "https://github.com/adafruit/Adafruit_CircuitPython_BME680.git"


// #    I2C ADDRESS/BITS/SETTINGS NEW
// #    -----------------------------------------------------------------------
public final int _BME68X_ENABLE_HEATER = 0x00;
// _BME68X_ENABLE_HEATER = const(0x00)
public final int _BME68X_ENABLE_HEATER = 0x01;
// _BME68X_DISABLE_HEATER = const(0x01)
public final int _BME68X_DISABLE_GAS_MEAS = 0x00;
// _BME68X_DISABLE_GAS_MEAS = const(0x00)
public final int _BME68X_ENABLE_GAS_MEAS_L = 0x01;
// _BME68X_ENABLE_GAS_MEAS_L = const(0x01)
// _BME68X_ENABLE_GAS_MEAS_H = const(0x02)
// _BME68X_SLEEP_MODE = const(0)
// _BME68X_FORCED_MODE = const(1)
// _BME68X_VARIANT_GAS_LOW = const(0x00)
// _BME68X_VARIANT_GAS_HIGH = const(0x01)
// _BME68X_HCTRL_MSK = const(0x08)
// _BME68X_HCTRL_POS = const(3)
// _BME68X_NBCONV_MSK = const(0x0F)
// _BME68X_RUN_GAS_MSK = const(0x30)
// _BME68X_RUN_GAS_POS = const(4)
// _BME68X_MODE_MSK = const(0x03)
// _BME68X_PERIOD_POLL = const(10000)
// _BME68X_REG_CTRL_GAS_0 = const(0x70)
// _BME68X_REG_CTRL_GAS_1 = const(0x71)

// #    I2C ADDRESS/BITS/SETTINGS
// #    -----------------------------------------------------------------------
// _BME680_CHIPID = const(0x61)

// _BME680_REG_CHIPID = const(0xD0)
// _BME68X_REG_VARIANT = const(0xF0)
// _BME680_BME680_COEFF_ADDR1 = const(0x89)
// _BME680_BME680_COEFF_ADDR2 = const(0xE1)
// _BME680_BME680_RES_HEAT_0 = const(0x5A)
// _BME680_BME680_GAS_WAIT_0 = const(0x64)

// _BME680_REG_SOFTRESET = const(0xE0)
// _BME680_REG_CTRL_GAS = const(0x71)
// _BME680_REG_CTRL_HUM = const(0x72)
// _BME680_REG_STATUS = const(0x73)
// _BME680_REG_CTRL_MEAS = const(0x74)
// _BME680_REG_CONFIG = const(0x75)

// _BME680_REG_MEAS_STATUS = const(0x1D)
// _BME680_REG_PDATA = const(0x1F)
// _BME680_REG_TDATA = const(0x22)
// _BME680_REG_HDATA = const(0x25)

private int[] _BME680_SAMPLERATES = {0, 1, 2, 4, 8, 16};
private int[] _BME680_FILTERSIZES = {0, 1, 3, 7, 15, 31, 63, 127};

// _BME680_RUNGAS = const(0x10)

public float[] _LOOKUP_TABLE_1 = {
        2147483647.0,
    2147483647.0,
    2147483647.0,
    2147483647.0,
    2147483647.0,
    2126008810.0,
    2147483647.0,
    2130303777.0,
    2147483647.0,
    2147483647.0,
    2143188679.0,
    2136746228.0,
    2147483647.0,
    2126008810.0,
    2147483647.0,
    2147483647.0
};

public float[] _LOOKUP_TABLE_2 = {
    4096000000.0,
    2048000000.0,
    1024000000.0,
    512000000.0,
    255744255.0,
    127110228.0,
    64000000.0,
    32258064.0,
    16016016.0,
    8000000.0,
    4000000.0,
    2000000.0,
    1000000.0,
    500000.0,
    250000.0,
    125000.0    
};

public byte bme_set_bits(byte reg_data, byte bitname_msk, int bitname_pos, byte data ){
//     """
//     Macro to set bits
//     data2 = data << bitname_pos
//     set masked bits from data2 in reg_data
//     """
//     return (reg_data & ~bitname_msk) | ((data << bitname_pos) & bitname_msk)
}

public byte bme_set_bits_pos_0(byte reg_data, byte bitname_msk, byte data){
//     """
//     Macro to set bits starting from position 0
//     set masked bits from data in reg_data
//     """
//     return (reg_data & ~bitname_msk) | (data & bitname_msk)
}

/**
 * Parse an unsigned 24-bit value as a floating point and return it.
 */
public float _read24(byte[] arr) {
    float ret = 0.0f;
    //     # print([hex(i) for i in arr])
    for (byte b : arr) {
            ret *= 256.0;
            ret += (float)(b & 0xFF);
    }
    return ret;
}

/**
 * Driver from BME680 air quality sensor
 * 
 */
public class Adafruit_BME680 {
    /**
     * @param refresh_rate Maximum number of readings per second. Faster property reads will be from the previous reading.
     */
    public Adafruit_BME680(int refresh_rate) {
        //     def __init__(self, *, refresh_rate: int = 10) -> None:
        //         """Check the BME680 was found, read the coefficients and enable the sensor for continuous
        //         reads."""
        this._write(_BME680_REG_SOFTRESET, new byte[] {0xB6});
        //         time.sleep(0.005)

        //         # Check device ID.
        chip_id = this._read_byte()
        //         chip_id = self._read_byte(_BME680_REG_CHIPID)
        if (chip_id != _BME680_CHIPID) {
            throw new RuntimeError(String.format("Failed to find BME680! Chip ID 0x%02X", chip_id));
        }

        // Get variant
        this._chip_variant = this._read_byte(_BME68X_REG_VARIANT);

        this._read_calibration();

            // set up heater
            this._write(_BME680_BME680_RES_HEAT_0, new byte[]{0x73});
            this._write(_BME680_BME680_GAS_WAIT_0, new byte[]{0x65});

            this.sea_level_pressure = 1013.25;
        //         """Pressure in hectoPascals at sea level. Used to calibrate :attr:`altitude`."""

        //         # Default oversampling and filter register values.
        this._pressure_oversample = 0b011;
        this._temp_oversample = 0b100;
        this._humidity_oversample = 0b010;
        this._filter = 0b010;

        //         # Gas measurements, as a mask applied to _BME680_RUNGAS
        this._run_gas = 0xFF;
        this._adc_pres = null;
        this._adc_temp = null;
        this._adc_hum = null;
        this._adc_gas = null;
        this._gas_range = null;
        this._t_fine = null;

        this._last_reading = 0;
        this._min_refresh_time = 1 / refresh_rate;

        this._amb_temp = 25; // Copy required parameters from reference bme68x_dev struct
        this.set_gas_heater(320, 150); // heater 320 deg C for 150 msec
    }


    private int getSampleRate(int sampleRate) {
        int result = -1;
        if (_BME680_SAMPLERATES.contains(sampleRate)) {
            result = _BME680_SAMPLERATES.indexOf(sampleRate);
        } else {
            throw new RuntimeException("Invalid oversample");
        }
        return result;
    }

    private int getFilterSize(int filterSize) {
        int result = -1;
        if (_BME680_FILTERSIZES.contains(filterSize)) {
            result = _BME680_FILTERSIZES.indexOf(filterSize);
        } else {
            throw new RuntimeException("Invalid size");
        }
        return result;
    }

    /**
     * The oversampling for pressure sensor
     */
    public int pressure_oversample() {
        return _BME680_SAMPLERATES[self._pressure_oversample];
    }


    public void pressure_oversample(int sample_rate) {
        this._pressure_oversample = getSampleRate(sample_rate);
    }

    /**
     * The oversampling for humidity sensor
     */
    public int humidity_oversample() {
        return _BME680_SAMPLERATES[this._humidity_oversample];
    }

    //     @humidity_oversample.setter
    public void humidity_oversample(int sample_rate) {
        this._humidity_oversample = getSampleRate(sample_rate);
    }



    /**
     * The oversampling for temperature sensor
     */
    public int temperature_oversample() {
        return _BME680_SAMPLERATES[this._temp_oversample];
    }

    public void temperature_oversample(int sample_rate) {
        this._temp_oversample = getSampleRate(sample_rate);
    }

    /**
     * The filter size for the built in IIR filter
     */
    public int filter_size() {
        return _BME680_FILTERSIZES[this._filter];
    }

    public void filter_size(int size) {
        this._filter = getFilterSize(size);
    }

    /**
     * The compensated temperature in degrees Celsius.
     */
    public float temperature() {
//         """"""
        this._perform_reading();
        double calc_temp = ((this._t_fine * 5) + 128) / 256;
        return calc_temp / 100;
    }

    /**
     * The barometric pressure in hectoPascals
     */
    public float pressure() {
        this._perform_reading();
        double var1 = (this._t_fine / 2) - 64000;
        double var2 = ((var1 / 4) * (var1 / 4)) / 2048;
        var2 = (var2 * this._pressure_calibration[5]) / 4;
        var2 = var2 + (var1 * this._pressure_calibration[4] * 2);
        var2 = (var2 / 4) + (this._pressure_calibration[3] * 65536)
        
        var1 = ((((var1 / 4) * (var1 / 4)) / 8192) * (this._pressure_calibration[2] * 32) / 8) + (
            (this._pressure_calibration[1] * var1) / 2
        );
        var1 = var1 / 262144;
        var1 = ((32768 + var1) * this._pressure_calibration[0]) / 32768;
        calc_pres = 1048576 - this._adc_pres;
        calc_pres = (calc_pres - (var2 / 4096)) * 3125;
        calc_pres = (calc_pres / var1) * 2;

        var1 = (this._pressure_calibration[8] * (((calc_pres / 8) * (calc_pres / 8)) / 8192)) / 4096;
        var2 = ((calc_pres / 4) * this._pressure_calibration[7]) / 8192;
        var3 = (((calc_pres / 256) ** 3) * this._pressure_calibration[9]) / 131072;
        calc_pres += (var1 + var2 + var3 + (this._pressure_calibration[6] * 128)) / 16;
        
        return calc_pres / 100;
    }

    /**
     * The relative humidity in RH %
     */
    public float relative_humidity() {
        return this.humidity;
    }

    /**
     * The relative humidity in RH %
     */
    public float humidity() {
        
        this._perform_reading()
        temp_scaled = ((this._t_fine * 5) + 128) / 256
        var1 = (this._adc_hum - (this._humidity_calibration[0] * 16)) - (
            (temp_scaled * this._humidity_calibration[2]) / 200
        )
        var2 = (
            this._humidity_calibration[1]
            * (
                ((temp_scaled * this._humidity_calibration[3]) / 100)
                + (
                    ((temp_scaled * ((temp_scaled * this._humidity_calibration[4]) / 100)) / 64)
                    / 100
                )
                + 16384
            )
        ) / 1024
        var3 = var1 * var2
        var4 = this._humidity_calibration[5] * 128
        var4 = (var4 + ((temp_scaled * this._humidity_calibration[6]) / 100)) / 16
        var5 = ((var3 / 16384) * (var3 / 16384)) / 1024
        var6 = (var4 * var5) / 2
        calc_hum = (((var3 + var6) / 1024) * 1000) / 4096
        calc_hum /= 1000  // get back to RH

        calc_hum = min(calc_hum, 100)
        calc_hum = max(calc_hum, 0)
        return calc_hum
    }

    /**
     * The altitude based on current :attr:`pressure` vs the sea level pressure
     * (:attr:`sea_level_pressure`) - which you must enter ahead of time)
     */
    public float altitude() {
        pressure = this.pressure;  // in Si units for hPascal
        return 44330 * (1.0 - math.pow(pressure / this.sea_level_pressure, 0.1903));
    }

    /**
     * The gas resistance in ohms
     */
    public int gas() {
        this._perform_reading();
        if (this._chip_variant == 0x01) {
            // taken from https://github.com/BoschSensortec/BME68x-Sensor-API
            float var1 = 262144 >> this._gas_range;
            float var2 = this._adc_gas - 512;
            var2 *= 3;
            var2 = 4096 + var2;
            calc_gas_res = (10000 * var1) / var2;
            calc_gas_res = calc_gas_res * 100;
        } else {
            float var1 = ((1340 + (5 * this._sw_err)) * (_LOOKUP_TABLE_1[this._gas_range])) / 65536;
            float var2 = ((this._adc_gas * 32768) - 16777216) + var1;
            float var3 = (_LOOKUP_TABLE_2[this._gas_range] * var1) / 512;
            calc_gas_res = (var3 + (var2 / 2)) / var2;
        }
        return (int)(calc_gas_res);
    }

    /**
     * Perform a single-shot reading from the sensor and fill internal data structure for calculations
     */
    public void _perform_reading() {
        long now = System.nanoTime();
        if (now - this._last_reading < this._min_refresh_time) {
            return;
        }
        // set filter
        this._write(_BME680_REG_CONFIG, [this._filter << 2]);
        // turn on temp oversample & pressure oversample
        this._write(
            _BME680_REG_CTRL_MEAS, [(this._temp_oversample << 5) | (this._pressure_oversample << 2)]
        );
        // turn on humidity oversample
        this._write(_BME680_REG_CTRL_HUM, [this._humidity_oversample]);
        // gas measurements enabled
        if (this._chip_variant == 0x01) {
            this._write(_BME680_REG_CTRL_GAS, [(this._run_gas & _BME680_RUNGAS) << 1]);
        } else {
            this._write(_BME680_REG_CTRL_GAS, [(this._run_gas & _BME680_RUNGAS)]);
        }
        ctrl = this._read_byte(_BME680_REG_CTRL_MEAS);
        ctrl = (ctrl & 0xFC) | 0x01; // enable single shot!
        this._write(_BME680_REG_CTRL_MEAS, [ctrl]);
        new_data = false;
        while (!new_data) {
            data = this._read(_BME680_REG_MEAS_STATUS, 17);
            new_data = data[0] & 0x80 != 0;
            Thread.sleep(5); // 5 milliseconds
        }
        this._last_reading = System.nanoTime();
        this._adc_pres = (short) (_read24(Arrays.copyOfRange(data, 2, 5)) / 16);
        this._adc_temp = (short) (_read24(Arrays.copyOfRange(data, 5, 8)) / 16);

        this._adc_hum = (short) ByteBuffer.wrap(Arrays.copyOfRange(data, 8, 10)).order(ByteOrder.BIG_ENDIAN).getShort();

        if (this._chip_variant == 0x01) {
            this._adc_gas = (int) (ByteBuffer.wrap(Arrays.copyOfRange(data, 15, 17)).order(ByteOrder.BIG_ENDIAN).getShort() / 64);
            this._gas_range = data[16] & 0x0F;
        } else {
            this._adc_gas = (int) (ByteBuffer.wrap(Arrays.copyOfRange(data, 13, 15)).order(ByteOrder.BIG_ENDIAN).getShort() / 64);
            this._gas_range = data[14] & 0x0F;
        }

        var1 = (this._adc_temp / 8) - (this._temp_calibration[0] * 2);
        var2 = (var1 * this._temp_calibration[1]) / 2048;
        var3 = ((var1 / 2) * (var1 / 2)) / 4096;
        var3 = (var3 * this._temp_calibration[2] * 16) / 16384;
        this._t_fine = int(var2 + var3);
    }

    /**
     * Read & save the calibration coefficients
     */
    public void _read_calibration() {
        byte[] coeff1 = self._read(_BME680_BME680_COEFF_ADDR1, 25);
        byte[] coeff2 = self._read(_BME680_BME680_COEFF_ADDR2, 16);

        byte[] coeff = new byte[coeff1.length + coeff2.length];
        System.arraycopy(coeff1, 0, coeff, 0, coeff1.length);
        System.arraycopy(coeff2, 0, coeff, coeff1.length, coeff2.length);

        // coeff = list(struct.unpack("<hbBHhbBhhbbHhhBBBHbbbBbHhbb", bytes(coeff[1:39])))
        // # print("\n\n",coeff)
        // coeff = [float(i) for i in coeff]
        // self._temp_calibration = [coeff[x] for x in [23, 0, 1]]
        // self._pressure_calibration = [coeff[x] for x in [3, 4, 5, 7, 8, 10, 9, 12, 13, 14]]
        // self._humidity_calibration = [coeff[x] for x in [17, 16, 18, 19, 20, 21, 22]]
        // self._gas_calibration = [coeff[x] for x in [25, 24, 26]]

        byte[] coeffBytes = Arrays.copyOfRange(coeff, 1, 39);
        List<Number> coeffList = unpackArray(coeffBytes);

        this.floatCoeffList = coeffList.stream().map(Number::floatValue).collect(Collectors.toList());
        this._temp_calibration = Arrays.asList(floatCoeffList.get(23), floatCoeffList.get(0), floatCoeffList.get(1));
        this._pressure_calibration = Arrays.asList(floatCoeffList.get(3), floatCoeffList.get(4), floatCoeffList.get(5), floatCoeffList.get(7), floatCoeffList.get(8), floatCoeffList.get(10), floatCoeffList.get(9), floatCoeffList.get(12), floatCoeffList.get(13), floatCoeffList.get(14));
        this._humidity_calibration = Arrays.asList(floatCoeffList.get(17), floatCoeffList.get(16), floatCoeffList.get(18), floatCoeffList.get(19), floatCoeffList.get(20), floatCoeffList.get(21), floatCoeffList.get(22));
        this._gas_calibration = Arrays.asList(floatCoeffList.get(25), floatCoeffList.get(24), floatCoeffList.get(26));

        // flip around H1 & H2
        this._humidity_calibration[1] *= 16;
        this._humidity_calibration[1] += this._humidity_calibration[0] % 16;
        this._humidity_calibration[0] /= 16;

        this._heat_range = (this._read_byte(0x02) & 0x30) / 16;
        this._heat_val = this._read_byte(0x00);
        this._sw_err = (this._read_byte(0x04) & 0xF0) / 16
    }

    private List<Number> unpackArray(byte[] coeff) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(Arrays.copyOfRange(coeff, 1, 39)).order(ByteOrder.LITTLE_ENDIAN);

        short a = byteBuffer.getShort();
        byte b = byteBuffer.get();
        byte c = byteBuffer.get();
        short d = byteBuffer.getShort();
        byte e = byteBuffer.get();
        byte f = byteBuffer.get();
        short g = byteBuffer.getShort();
        short h = byteBuffer.getShort();
        byte i = byteBuffer.get();
        byte j = byteBuffer.get();
        short k = byteBuffer.getShort();
        short l = byteBuffer.getShort();
        byte m = byteBuffer.get();
        byte n = byteBuffer.get();
        byte o = byteBuffer.get();
        short p = byteBuffer.getShort();
        byte q = byteBuffer.get();
        byte r = byteBuffer.get();
        short s = byteBuffer.getShort();
        byte t = byteBuffer.get();
        byte u = byteBuffer.get();
        short v = byteBuffer.getShort();
        byte w = byteBuffer.get();
        byte x = byteBuffer.get();
        short y = byteBuffer.getShort();

        List<Number> coeffList = Arrays.asList(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y);
    }

    /**
     * Read a byte register value and return it
     */
    public int _read_byte(int register) {
        return this._read(register, 1)[0];
    }

    public byte[] _read(int register, int length) {
        throw new UnsupportedOperationException();
    }

    public void _write(int register, byte[] values) {
        throw new UnsupportedOperationException();
    }

    /**
     *         Enable and configure gas reading + heater (None disables)
     * @param heater_temp Desired temperature in degrees Centigrade
     * @param heater_time Time to keep heater on in milliseconds
     * @return True on success, False on failure
     */
    public boolean set_gas_heater(int heater_temp, int heater_time) {
        boolean result = false;
        try {
            if ((heater_temp == null) || (heater_time == null)) {
                boolean enable = false;
                this._set_heatr_conf((heater_temp || 0), (heater_time || 0), enable);
            } else {
                this._set_heatr_conf(heater_temp, heater_time);
            }
            result = true;

        } catch (Exception e) {
            result = false;
        }
        return result;
    }


    public void _set_heatr_conf(int heater_temp, int heater_time, boolean enable) {
        //         # restrict to BME68X_FORCED_MODE
        int op_mode = _BME68X_FORCED_MODE;
        int nb_conv = 0;
        int hctrl = _BME68X_ENABLE_HEATER;
        int run_gas = 0;
        int ctrl_gas_data_0 = 0;
        int ctrl_gas_data_1 = 0;

        this._set_op_mode(_BME68X_SLEEP_MODE);
        this._set_conf(heater_temp, heater_time, op_mode);
//         self._set_conf(heater_temp, heater_time, op_mode)
//         ctrl_gas_data_0 = self._read_byte(_BME68X_REG_CTRL_GAS_0)
//         ctrl_gas_data_1 = self._read_byte(_BME68X_REG_CTRL_GAS_1)
//         if enable:
//             hctrl = _BME68X_ENABLE_HEATER
//             if self._chip_variant == _BME68X_VARIANT_GAS_HIGH:
//                 run_gas = _BME68X_ENABLE_GAS_MEAS_H
//             else:
//                 run_gas = _BME68X_ENABLE_GAS_MEAS_L
//         else:
//             hctrl = _BME68X_DISABLE_HEATER
//             run_gas = _BME68X_DISABLE_GAS_MEAS
//         self._run_gas = ~(run_gas - 1)

//         ctrl_gas_data_0 = bme_set_bits(ctrl_gas_data_0, _BME68X_HCTRL_MSK, _BME68X_HCTRL_POS, hctrl)
//         ctrl_gas_data_1 = bme_set_bits_pos_0(ctrl_gas_data_1, _BME68X_NBCONV_MSK, nb_conv)
//         ctrl_gas_data_1 = bme_set_bits(
//             ctrl_gas_data_1, _BME68X_RUN_GAS_MSK, _BME68X_RUN_GAS_POS, run_gas
//         )
//         self._write(_BME68X_REG_CTRL_GAS_0, [ctrl_gas_data_0])
//         self._write(_BME68X_REG_CTRL_GAS_1, [ctrl_gas_data_1])
    }

    public void _set_op_mode(int op_mode) {
//         """
//         * @brief This API is used to set the operation mode of the sensor
//         """
//         tmp_pow_mode: int = 0
//         pow_mode: int = _BME68X_FORCED_MODE
//         # Call until in sleep

//         # was a do {} while() loop
//         while pow_mode != _BME68X_SLEEP_MODE:
//             tmp_pow_mode = self._read_byte(_BME680_REG_CTRL_MEAS)
//             # Put to sleep before changing mode
//             pow_mode = tmp_pow_mode & _BME68X_MODE_MSK
//             if pow_mode != _BME68X_SLEEP_MODE:
//                 tmp_pow_mode &= ~_BME68X_MODE_MSK  # Set to sleep
//                 self._write(_BME680_REG_CTRL_MEAS, [tmp_pow_mode])
//                 # dev->delay_us(_BME68X_PERIOD_POLL, dev->intf_ptr)  # HELP
//                 delay_microseconds(_BME68X_PERIOD_POLL)
//         # Already in sleep
//         if op_mode != _BME68X_SLEEP_MODE:
//             tmp_pow_mode = (tmp_pow_mode & ~_BME68X_MODE_MSK) | (op_mode & _BME68X_MODE_MSK)
//             self._write(_BME680_REG_CTRL_MEAS, [tmp_pow_mode])
    }

    public void _set_conf(int heater_temp, int heater_time, int op_mode) {
//         """
//         This internal API is used to set heater configurations
//         """

//         if op_mode != _BME68X_FORCED_MODE:
//             raise OSError("GasHeaterException: _set_conf not forced mode")
//         rh_reg_data: int = self._calc_res_heat(heater_temp)
//         gw_reg_data: int = self._calc_gas_wait(heater_time)
//         self._write(_BME680_BME680_RES_HEAT_0, [rh_reg_data])
//         self._write(_BME680_BME680_GAS_WAIT_0, [gw_reg_data])
    }

    public int _calc_res_heat(int temp) {
//         """
//         This internal API is used to calculate the heater resistance value using float
//         """
//         gh1: int = self._gas_calibration[0]
//         gh2: int = self._gas_calibration[1]
//         gh3: int = self._gas_calibration[2]
//         htr: int = self._heat_range
//         htv: int = self._heat_val
//         amb: int = self._amb_temp

//         temp = min(temp, 400)  # Cap temperature

//         var1: int = ((int(amb) * gh3) / 1000) * 256
//         var2: int = (gh1 + 784) * (((((gh2 + 154009) * temp * 5) / 100) + 3276800) / 10)
//         var3: int = var1 + (var2 / 2)
//         var4: int = var3 / (htr + 4)
//         var5: int = (131 * htv) + 65536
//         heatr_res_x100: int = int(((var4 / var5) - 250) * 34)
//         heatr_res: int = int((heatr_res_x100 + 50) / 100)

//         return heatr_res
    }

    public int _calc_res_heat(int temp) {
//         """
//         This internal API is used to calculate the heater resistance value
//         """
float gh1 = this._gas_calibration[0];
//         gh1: float = float(self._gas_calibration[0])
//         gh2: float = float(self._gas_calibration[1])
//         gh3: float = float(self._gas_calibration[2])
//         htr: float = float(self._heat_range)
//         htv: float = float(self._heat_val)
//         amb: float = float(self._amb_temp)

//         temp = min(temp, 400)  # Cap temperature

//         var1: float = (gh1 / (16.0)) + 49.0
//         var2: float = ((gh2 / (32768.0)) * (0.0005)) + 0.00235
//         var3: float = gh3 / (1024.0)
//         var4: float = var1 * (1.0 + (var2 * float(temp)))
//         var5: float = var4 + (var3 * amb)
//         res_heat: int = int(3.4 * ((var5 * (4 / (4 + htr)) * (1 / (1 + (htv * 0.002)))) - 25))
//         return res_heat
    }

    public int _calc_gas_wait(int dur) {
//         """
//         This internal API is used to calculate the gas wait
//         """
//         factor: int = 0
//         durval: int = 0xFF  # Max duration

//         if dur >= 0xFC0:
//             return durval
//         while dur > 0x3F:
//             dur = dur / 4
//             factor += 1
//         durval = int(dur + (factor * 64))
//         return durval
    }

}

private class Adafruit_BME680_I2C extends Adafruit_BME680 {

// class Adafruit_BME680_I2C(Adafruit_BME680):
//     """Driver for I2C connected BME680.

//     :param ~busio.I2C i2c: The I2C bus the BME680 is connected to.
//     :param int address: I2C device address. Defaults to :const:`0x77`
//     :param bool debug: Print debug statements when `True`. Defaults to `False`
//     :param int refresh_rate: Maximum number of readings per second. Faster property reads
//       will be from the previous reading.

//     **Quickstart: Importing and using the BME680**

//         Here is an example of using the :class:`BMP680_I2C` class.
//         First you will need to import the libraries to use the sensor

//         .. code-block:: python

//             import board
//             import adafruit_bme680

//         Once this is done you can define your ``board.I2C`` object and define your sensor object

//         .. code-block:: python

//             i2c = board.I2C()   # uses board.SCL and board.SDA
//             bme680 = adafruit_bme680.Adafruit_BME680_I2C(i2c)

//         You need to setup the pressure at sea level

//         .. code-block:: python

//             bme680.sea_level_pressure = 1013.25

//         Now you have access to the :attr:`temperature`, :attr:`gas`, :attr:`relative_humidity`,
//         :attr:`pressure` and :attr:`altitude` attributes

//         .. code-block:: python

//             temperature = bme680.temperature
//             gas = bme680.gas
//             relative_humidity = bme680.relative_humidity
//             pressure = bme680.pressure
//             altitude = bme680.altitude

//     """

//     def __init__(
//         self,
//         i2c: I2C,
//         address: int = 0x77,
//         debug: bool = False,
//         *,
//         refresh_rate: int = 10,
//     ) -> None:
//         """Initialize the I2C device at the 'address' given"""
//         from adafruit_bus_device import (
//             i2c_device,
//         )

//         self._i2c = i2c_device.I2CDevice(i2c, address)
//         self._debug = debug
//         super().__init__(refresh_rate=refresh_rate)

    private I2C i2c;
    private int address = 0x77;
    private boolean debug = false;
    private int refresh_rate = 10;

    public Adafruit_BME680_I2C(I2C i2c, int address, boolean debug, int refresh_rate) {

//         """Initialize the I2C device at the 'address' given"""
        // from adafruit_bus_device import (
        //     i2c_device,
        // )
        super(refresh_rate);
        this.i2c = i2c_device.I2CDevice(i2c, address);
        this.debug = debug;
        this.refresh_rate = refresh_rate;
    }

    public byte[] _read(int register, int length) {
//         """Returns an array of 'length' bytes from the 'register'"""
//         with self._i2c as i2c:
//             i2c.write(bytes([register & 0xFF]))
//             result = bytearray(length)
//             i2c.readinto(result)
//             if self._debug:
//                 print(f"\t${register:02X} => {[hex(i) for i in result]}")
//             return result
    }

    public void _write(int register, ReadableBuffer values) {
//         """Writes an array of 'length' bytes to the 'register'"""
//         with self._i2c as i2c:
//             buffer = bytearray(2 * len(values))
//             for i, value in enumerate(values):
//                 buffer[2 * i] = register + i
//                 buffer[2 * i + 1] = value
//             i2c.write(buffer)
//             if self._debug:
//                 print(f"\t${values[0]:02X} <= {[hex(i) for i in values[1:]]}")
    }

}




public class Adafruit_BME680_SPI extends Adafruit_BME680 {
// class Adafruit_BME680_SPI(Adafruit_BME680):
//     """Driver for SPI connected BME680.

//     :param ~busio.SPI spi: SPI device
//     :param ~digitalio.DigitalInOut cs: Chip Select
//     :param bool debug: Print debug statements when `True`. Defaults to `False`
//     :param int baudrate: Clock rate, default is :const:`100000`
//     :param int refresh_rate: Maximum number of readings per second. Faster property reads
//       will be from the previous reading.


//     **Quickstart: Importing and using the BME680**

//         Here is an example of using the :class:`BMP680_SPI` class.
//         First you will need to import the libraries to use the sensor

//         .. code-block:: python

//             import board
//             from digitalio import DigitalInOut, Direction
//             import adafruit_bme680

//         Once this is done you can define your ``board.SPI`` object and define your sensor object

//         .. code-block:: python

//             cs = digitalio.DigitalInOut(board.D10)
//             spi = board.SPI()
//             bme680 = adafruit_bme680.Adafruit_BME680_SPI(spi, cs)

//         You need to setup the pressure at sea level

//         .. code-block:: python

//             bme680.sea_level_pressure = 1013.25

//         Now you have access to the :attr:`temperature`, :attr:`gas`, :attr:`relative_humidity`,
//         :attr:`pressure` and :attr:`altitude` attributes

//         .. code-block:: python

//             temperature = bme680.temperature
//             gas = bme680.gas
//             relative_humidity = bme680.relative_humidity
//             pressure = bme680.pressure
//             altitude = bme680.altitude

//     """

private SPI spi;
private DigitalInOut cs;
private int baudrate = 100000;
private boolean debug = false;
private int refresh_rate = 10;

public Adafruit_BME680_SPI(SPI spi, DigitalInOut cs, int baudrate){
//         spi: SPI,
//         cs: DigitalInOut,
//         baudrate: int = 100000,
//         debug: bool = False,
//         *,
//         refresh_rate: int = 10,    

//         from adafruit_bus_device import (
//             spi_device,
//         )

//         self._spi = spi_device.SPIDevice(spi, cs, baudrate=baudrate)
//         self._debug = debug
//         super().__init__(refresh_rate=refresh_rate)
}

private byte[] read(int register, int length) {
//         if register != _BME680_REG_STATUS:
//             # _BME680_REG_STATUS exists in both SPI memory pages
//             # For all other registers, we must set the correct memory page
//             self._set_spi_mem_page(register)

//         register = (register | 0x80) & 0xFF  # Read single, bit 7 high.
//         with self._spi as spi:
//             spi.write(bytearray([register]))
//             result = bytearray(length)
//             spi.readinto(result)
//             if self._debug:
//                 print(f"\t${register:02X} => {[hex(i) for i in result]}")
//             return result    
}


public void _write(int register, ReadableBuffer values) {
    if (register != _BME680_REG_STATUS){
        // _BME680_REG_STATUS exists in both SPI memory pages
        // For all other registers, we must set the correct memory page
        this._set_spi_mem_page(register);
    }

    register &= 0x7F;  // Write, bit 7 low.
    
    try (this.spi) {
        byte[] buffer = new byte[2 * values.length];

        for (int i = 0; i < values.length; i++) {
            value = values[i];
            buffer[2 * i] = register + i;
            buffer[(2 * i) + 1] = value & 0xFF;
        }
        this.spi.write(buffer);
        if (this.debug) {
            System.out.println(String.format("\t$%f",));
            String formattedString = "\t" + String.format("%02X", values[0]) + " <= " + Arrays.toString(Arrays.stream(values, 1, values.length).mapToObj(i -> String.format("%X", i)).toArray(String[]::new));
//                 print(f"\t${values[0]:02X} <= {[hex(i) for i in values[1:]]}")                
        }

    } catch (Exception e) {

    }

}

public void _set_spi_mem_page(int register) {
    byte spi_mem_page = 0x00;
    if (register < 0x80) {
        spi_mem_page = 0x10;
    }
    this._write(_BME680_REG_STATUS, new byte[] {spi_mem_page});
}

}


}