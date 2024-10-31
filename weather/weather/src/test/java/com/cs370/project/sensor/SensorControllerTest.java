package com.cs370.project.sensor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SensorControllerTest {

	@Test
	@DisplayName("jmaksuta: test readSensor")
	void testReadSensor() {
		boolean isPassed = false;
		StringBuilder builder = new StringBuilder();
        try {
			SensorController controller = new SensorController();
			SensorData actual = controller.readSensor();

			boolean tempPassed = actual.getTemperature() != 0.0f;
			boolean gasPassed = actual.getGas() != 0;
			boolean humidityPassed = actual.getHumidity() != 0.0f;
			boolean pressurePassed = actual.getPressure() != 0.0f;
            
			isPassed = (tempPassed && gasPassed && humidityPassed && pressurePassed);
            
        } catch (Exception e) {
            // TODO: log exception.
            builder.append(e.getMessage());
        } finally {
			assertTrue(isPassed, builder.toString());
		}
	}

}
