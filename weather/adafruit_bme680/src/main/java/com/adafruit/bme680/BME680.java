package com.adafruit.bme680;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author John Maksuta
 * @since 10/26/2024 Copyright 2024
 *
 * Created based on an original Python code "adafruit_bme680" by 2017 ladyada
 * for Adafruit Industries under license MIT AND BSD-3-Clause
 *
 * CircuitPython library for BME680 temperature, pressure and humidity sensor.
 * Author(s): Limor Fried, William Garber, many others
 *
 * Implementation Notes --------------------
 *
 * **Hardware:**
 *
 * * `Adafruit BME680 Temp, Humidity, Pressure and Gas Sensor
 * <https://www.adafruit.com/product/3660>`_
 *
 * **Software and Dependencies:**
 *
 * * Adafruit CircuitPython firmware for the supported boards:
 * https://github.com/adafruit/circuitpython/releases * Adafruit's Bus Device
 * library: https://github.com/adafruit/Adafruit_CircuitPython_BusDevice
 *
 */
public class BME680 {

    public BME680() {

    }

    /**
     * HELP must be same as dev->delay_us
     */
    public void delay_microseconds(Object nusec) {
//     """HELP must be same as dev->delay_us"""
//     time.sleep(nusec / 1000000.0)
    }

    public static void delay_microseconds(long microseconds) {
        long start = System.nanoTime();
        long end = start + (microseconds * 1000);
        while (System.nanoTime() < end) {
            // Do nothing, just wait
        }
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
    public static final byte _BME68X_ENABLE_HEATER = 0x00;
    public static final byte _BME68X_DISABLE_HEATER = 0x01;
    public static final byte _BME68X_DISABLE_GAS_MEAS = 0x00;
    public static final byte _BME68X_ENABLE_GAS_MEAS_L = 0x01;
    public static final byte _BME68X_ENABLE_GAS_MEAS_H = 0x02;
    public static final int _BME68X_SLEEP_MODE = 0;
    public static final int _BME68X_FORCED_MODE = 1;
    public static final byte _BME68X_VARIANT_GAS_LOW = 0x00;
    public static final byte _BME68X_VARIANT_GAS_HIGH = 0x01;
    public static final byte _BME68X_HCTRL_MSK = 0x08;
    public static final int _BME68X_HCTRL_POS = 3;
    public static final byte _BME68X_NBCONV_MSK = 0x0F;

    public static final byte _BME68X_RUN_GAS_MSK = 0x30;
    public static final int _BME68X_RUN_GAS_POS = 4;
    public static final byte _BME68X_MODE_MSK = 0x03;
    public static final int _BME68X_PERIOD_POLL = 10000;
    public static final int _BME68X_REG_CTRL_GAS_0 = 0x70;
    public static final byte _BME68X_REG_CTRL_GAS_1 = 0x71;

// #    I2C ADDRESS/BITS/SETTINGS
// #    -----------------------------------------------------------------------
    public static final byte _BME680_CHIPID = 0x61;

    public static final int _BME680_REG_CHIPID = 0xD0;
    public static final int _BME68X_REG_VARIANT = 0xF0;
    public static final int _BME680_BME680_COEFF_ADDR1 = 0x89;
    public static final int _BME680_BME680_COEFF_ADDR2 = 0xE1;
    public static final byte _BME680_BME680_RES_HEAT_0 = 0x5A;
    public static final byte _BME680_BME680_GAS_WAIT_0 = 0x64;

    public static final int _BME680_REG_SOFTRESET = 0xE0;
    public static final byte _BME680_REG_CTRL_GAS = 0x71;
    public static final byte _BME680_REG_CTRL_HUM = 0x72;
    public static final byte _BME680_REG_STATUS = 0x73;
    public static final byte _BME680_REG_CTRL_MEAS = 0x74;
    public static final byte _BME680_REG_CONFIG = 0x75;

    public static final byte _BME680_REG_MEAS_STATUS = 0x1D;
    public static final byte _BME680_REG_PDATA = 0x1F;
    public static final byte _BME680_REG_TDATA = 0x22;
    public static final byte _BME680_REG_HDATA = 0x25;

    public Integer[] _BME680_SAMPLERATES = {0, 1, 2, 4, 8, 16};
    public Integer[] _BME680_FILTERSIZES = {0, 1, 3, 7, 15, 31, 63, 127};

    public static final byte _BME680_RUNGAS = 0x10;

    public static float[] _LOOKUP_TABLE_1 = {
        2147483647.0f,
        2147483647.0f,
        2147483647.0f,
        2147483647.0f,
        2147483647.0f,
        2126008810.0f,
        2147483647.0f,
        2130303777.0f,
        2147483647.0f,
        2147483647.0f,
        2143188679.0f,
        2136746228.0f,
        2147483647.0f,
        2126008810.0f,
        2147483647.0f,
        2147483647.0f
    };

    public static float[] _LOOKUP_TABLE_2 = {
        4096000000.0f,
        2048000000.0f,
        1024000000.0f,
        512000000.0f,
        255744255.0f,
        127110228.0f,
        64000000.0f,
        32258064.0f,
        16016016.0f,
        8000000.0f,
        4000000.0f,
        2000000.0f,
        1000000.0f,
        500000.0f,
        250000.0f,
        125000.0f
    };

    // /**
    //  * Macro to set bits data2 = data << bitname_pos set masked bits from data2
    //  * in reg_data
    //  */
    // public int bme_set_bits(int reg_data, int bitname_msk, int bitname_pos, int data) {
    //     return (reg_data & ~bitname_msk) | ((data << bitname_pos) & bitname_msk);
    // }
    public int bme_set_bits(int reg_data, int bitname_msk, int bitname_pos, int data) {
        // Shift data to the specified position
        int shiftedData = data << bitname_pos;

        // Clear the bits in reg_data that need to be set
        int clearedRegData = reg_data & ~bitname_msk;

        // Set the desired bits in reg_data using the shifted data and mask
        return clearedRegData | (shiftedData & bitname_msk);
    }

    // /**
    //  * Macro to set bits starting from position 0 set masked bits from data in
    //  * reg_data
    //  */
    // public int bme_set_bits_pos_0(byte reg_data, byte bitname_msk, byte data) {
    //     return (reg_data & ~bitname_msk) | (data & bitname_msk);
    // }
    public int bme_set_bits_pos_0(int reg_data, int bitname_msk, int data) {
        // Set masked bits from data in reg_data, starting from position 0
        return (reg_data & ~bitname_msk) | (data & bitname_msk);
    }

    /**
     * Parse an unsigned 24-bit value as a floating point and return it.
     */
    public float _read24(byte[] arr) {
        float ret = 0.0f;
        //     # print([hex(i) for i in arr])
        for (byte b : arr) {
            ret *= 256.0;
            ret += (float) (b & 0xFF);
        }
        return ret;
    }

}
