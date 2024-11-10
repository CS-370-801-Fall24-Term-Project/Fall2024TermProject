# Fall2024TermProject
CS 370-801 - Fall 2024 - Term Project


### Building adafruit_bme680 project
To build the weather project with the adafruit_bme680 project dependency, since we are not using a remote maven repository, you have to install the adafruit_bme680 jar output to your local maven repository. 
Note this must be done every time the project is changed and the jar file must be updated in the repository.
to do this, follow these steps:

1. from the git repository root directory, navigate to weather.
    cd weather

2. install the jar to the local repository.
    mvn install:install-file -Dfile=./adafruit_bme680/target/adafruit_bme680-1.0-SNAPSHOT.jar -DgroupId=com.adafruit.bme680 -DartifactId=adafruit_bme680 -Dversion=1.0-SNAPSHOT -Dpackaging=jar

This will allow you to build and run the project.

---

To run the web server project "weather":
1. from the git repository root directory, navigate to weather.
    cd weather/weather

2. run the project:
    mvn spring-boot:run

---

to deploy use:
    mvn clean package

## Projects
### adafruit_bme680

#### Sensor Demo
There is a sensor demo app that can be executed to demonstrate the readings from the sensor. To execute using Maven use the following from "/weather/adafruit_bme680" directory.
    
    mvn exec:java -Dexec.mainClass=com.adafruit.bme680.sensor.demo.SensorDemo -q

Example output:
$ mvn exec:java -Dexec.mainClass=com.adafruit.bme680.sensor.demo.SensorDemo -q
Temperature: 28.950001 degrees C
Gas: 12500 ohms
Humidity: 22.972456%
Pressure: 1017.626038hPa