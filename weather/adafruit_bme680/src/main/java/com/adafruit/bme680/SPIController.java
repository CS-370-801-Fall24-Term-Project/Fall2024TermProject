package com.adafruit.bme680;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.spi.SpiConfig;
import com.pi4j.io.spi.SpiProvider;
// import com.pi4j.Pi4J.PiGpio;
// import com.pi4j.Pi4J.PiGpioSpiProvider;

/**
 * @author John Maksuta
 * @since 10/26/2024
 * Copyright 2024
 */
public class SPIController implements AutoCloseable {

    // protected final Spi spi;
    private Context pi4j;
    private SpiProvider spiProvider;
    private SpiConfig spiConfig;

    public SPIController() {
        super();
        this.pi4j = Pi4J.newAutoContext();
        this.spiProvider = pi4j.provider("pigpio-spi");
        // var piGpio = PiGpio.newNativeInstance();
        // var pi4j = Pi4J.newContextBuilder()
        //         .noAutoDetect()
        //         .add(
        //                 PiGpioSpiProvider.newInstance(piGpio)
        //         )
        //         .build();
        // this.spi = new Spi();
        // further extended example.
        // var piGpio = PiGpio.newNativeInstance();
        // var pi4j = Pi4J.newContextBuilder()
        // .noAutoDetect()
        // .add(
        // PiGpioDigitalInputProvider.newInstance(piGpio),
        // PiGpioDigitalOutputProvider.newInstance(piGpio),
        // PiGpioPwmProvider.newInstance(piGpio),
        // PiGpioI2CProvider.newInstance(piGpio),
        // PiGpioSerialProvider.newInstance(piGpio),
        // PiGpioSpiProvider.newInstance(piGpio)
        // )
        // .build();
    }

    public void write(byte command, byte data) {
        // spi.write(command, data);
    }

    public void write(byte[] toWrite) {
        // spi.write(command, data);
    }

    public void readInto(byte[] result) {

    }
    
    public void read(byte[] readBytes,int offset,int length){

    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
