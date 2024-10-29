package com.adafruit.bme680;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.io.spi.Spi;
import com.pi4j.io.spi.SpiBus;
import com.pi4j.io.spi.SpiChipSelect;
import com.pi4j.io.spi.SpiMode;
import com.pi4j.util.Console;
import com.pi4j.util.StringUtil;

/**
 * @author John Maksuta
 * @since 10/26/2024
 * Copyright 2024
 */
public class SPITest {

    private static final SpiBus spiBus = SpiBus.BUS_0;

    public static void main(String[] args) throws Exception {
        final var console = new Console();

        // print program title/header
        console.title("<-- The Pi4J Project -->",
                "Basic SPI Communications Example");

        Context pi4j = Pi4J.newAutoContext();
        var spiConfig = Spi.newConfigBuilder(pi4j)
                .id("SPI" + spiBus + "_BME280")
                .name("BME280")
                .bus(spiBus)
                .chipSelect(SpiChipSelect.CS_0) // not used
                .mode(SpiMode.MODE_0)
                .provider("pigpio-spi")
                .build();

        // required all configs
        var outputConfig = DigitalOutput.newConfigBuilder(pi4j)
                .id("CS_GPIO5")
                .name("CS GPIO5")
                .address(5)
                .shutdown(DigitalState.HIGH)
                .initial(DigitalState.HIGH)
                .provider("pigpio-digital-output");

        DigitalOutput csGpio = null;
        try {
            csGpio = pi4j.create(outputConfig);
        } catch (Exception e) {
            e.printStackTrace();
            console.println("create DigOut DRDY failed");
            System.exit(202);
        }

        // use try-with-resources to auto-close SPI when complete
        try (var spi = pi4j.create(spiConfig)) {
            byte data[] = new byte[] { (byte) (0x80 | 0xD0), (byte) 0x00 };

            csGpio.high();
            csGpio.low();
            spi.transfer(data, data);
            csGpio.high();

            // take a breath to allow time for the SPI
            // data to get updated in the SPI device
            Thread.sleep(100);

            // read data back from the SPI channel
            console.println("--------------------------------------");
            console.println("SPI [READ] :");
            console.println("  [BYTES]  0x" + StringUtil.toHexString(data));
            console.println("  [STRING] " + new String(data));
            console.println("--------------------------------------");
        }

        // shutdown Pi4J
        console.println("ATTEMPTING TO SHUTDOWN/TERMINATE THIS PROGRAM");
        pi4j.shutdown();
    }
}