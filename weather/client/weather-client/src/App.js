import React from 'react';
import './App.css';

function App() {
  const sensorData = {
    temperature: 26.32,
    gas: 12500,
    humidity: 22.8,
    pressure: 1020.3,
    timestamp: new Date().toLocaleString(),
  };

  return (
    <div className="App">
      <header className="App-header">
        <h1>Weather - Sensor Dashboard</h1>
      </header>

      <main className="App-content">
        <div className="sensor-data">
          <h2>Current Sensor Readings</h2>
          <p><strong>Temperature:</strong> {sensorData.temperature} °C</p>
          <p><strong>Gas:</strong> {sensorData.gas} ohms</p>
          <p><strong>Humidity:</strong> {sensorData.humidity} %</p>
          <p><strong>Pressure:</strong> {sensorData.pressure} hPa</p>
          <p><strong>Last Updated:</strong> {sensorData.timestamp}</p>
        </div>
      </main>
    </div>
  );
}

export default App;
