from flask import Flask
import board
import adafruit_bme680

# Set up I2C communication and initialize the sensor
i2c = board.I2C()
sensor = adafruit_bme680.Adafruit_BME680_I2C(i2c)

# Set up Flask web app
app = Flask(__name__)

@app.route('/')
def index():
    # Read temperature in Celsius from the sensor
    temperature_c = sensor.temperature
    # Convert Celsius to Fahrenheit
    temperature_f = (temperature_c * 1.8) + 32
    # Create simple HTML to display temperature in both Celsius and Fahrenheit
    return f"""
    <html>
        <head><title>Temperature Sensor</title></head>
        <body>
            <h1>Temperature: {temperature_c:.2f} °C / {temperature_f:.2f} °F</h1>
        </body>
    </html>
    """

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5100)