package com.cs370.project.weather;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cs370.project.sensor.SensorController;
import com.cs370.project.sensor.SensorData;

@RestController
public class WeatherController {
    
    @RequestMapping(value="/path", method=RequestMethod.POST)
    public String requestMethodName(@RequestParam String param) {
        return new String();
    }

    @RequestMapping("/helloworld")
    public String hello() {
        return "hello world";
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String param) {
        return "hello";
    }

    @RequestMapping("/withParams")
    public String withParams(@RequestParam String param) {
        return String.format("param=%s", param);
    }

    @RequestMapping("/sensordata")
    public SensorData getSensorData() {
        SensorData data = new SensorData();
        try {
            SensorController controller = new SensorController();
            data = new SensorData(controller.getTemperature(), controller.getGas(),
                                        controller.getHumidity(), controller.getPressure());
        } catch (Exception e) {
            // TODO: log this exception
        }
        return data;
    }
    
}
