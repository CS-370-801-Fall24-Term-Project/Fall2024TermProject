import board
import digitalio
import busio
import adafruit_bme680
import mysql.connector
from datetime import datetime
import time


def connect_to_database():
    try:
        connection = mysql.connector.connect(
            host="localhost",
            user="root",           
            password="root", 
            database="sensor"   
        )
        return connection
    except mysql.connector.Error as err:
        print(f"Error connecting to database: {err}")
        return None


def record_sensor_data(sensor):
    connection = connect_to_database()
    if not connection:
        return
    
    try:
        cursor = connection.cursor()
        
        sql = """INSERT INTO sensor_readings 
                (temperature, gas_value, humidity, pressure) 
                VALUES (%s, %s, %s, %s)"""
                
        values = (
            sensor.temperature,
            sensor.gas,
            sensor.humidity,
            sensor.pressure
        )
        
        cursor.execute(sql, values)
        connection.commit()
        print("Data recorded successfully")
        
    except mysql.connector.Error as err:
        print(f"Error recording data: {err}")
    
    finally:
        if connection.is_connected():
            cursor.close()
            connection.close()

def main():
    i2c = board.I2C()
    sensor = adafruit_bme680.Adafruit_BME680_I2C(i2c)
    
    try:
        while True:
            print('Temperature: {} degrees C'.format(sensor.temperature))
            print('Gas: {} ohms'.format(sensor.gas))
            print('Humidity: {}%'.format(sensor.humidity))
            print('Pressure: {}hPa'.format(sensor.pressure))
            
            record_sensor_data(sensor)
            
            time.sleep(30)  # 30 seconds
            
    except KeyboardInterrupt:
        print("\nProgram stopped by user")
    except Exception as e:
        print(f"An error occurred: {e}")

if __name__ == "__main__":
    main()
