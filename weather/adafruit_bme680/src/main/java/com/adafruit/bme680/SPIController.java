package com.adafruit.bme680;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.Pi4J.PiGpio;
import com.pi4j.Pi4J.PiGpioSpiProvider;

public class SPIController implements AutoCloseable {

    protected final Spi spi;

    public SPIController() {
        super();
        var piGpio = PiGpio.newNativeInstance();
        var pi4j = Pi4J.newContextBuilder().noAutoDetect().add(PiGpioSpiProvider.newInstance(piGpio)).build();
        this.spi = new Spi();
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
        spi.write(command, data);
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}