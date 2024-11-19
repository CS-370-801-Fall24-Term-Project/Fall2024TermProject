import React, { useEffect, useState } from 'react';
import "../App.css"
// import axios from 'axios';
import { sendAPIRequest } from '../util/restApi';
import { useServerSettings } from "../util/ServerConfig";

export function Page(props) {
  const [serverSettings, processServerConfigSuccess] = useServerSettings(props.showMessage);
  const [sensorData, setSensorData] = useState({
    temperature: 26.32,
    gas: 12500,
    humidity: 22.8,
    pressure: 1020.3,
    timestamp: new Date().toLocaleString(),
  });

  function processGetSensorDataSuccess(response, serverUrl) {
    setSensorData(response);
  }

  async function sendGetSensorDataRequest() {
    // const testurl = "http://192.168.1.238:8080"
    // const getSensorDataResponse = await sendAPIRequest({}, testurl, "sensordata");
    const getSensorDataResponse = await sendAPIRequest({}, serverSettings.serverUrl, "sensordata");
    if (getSensorDataResponse) {
      processGetSensorDataSuccess(getSensorDataResponse, serverSettings.serverUrl);
    } else {
      props.showMessage(`SensorData request to ${serverSettings.serverUrl} failed. Check the log for more details.`, 'error');
    }
  }

  const btnGetReadingClick = () => {
    sendGetSensorDataRequest();
  };

  useEffect(() => {
    // sendGetSensorDataRequest();
  }, []);

  return (<>
    <div className="App">
      <header className="App-header">
        <h1>Weather - Sensor Dashboard</h1>
      </header>

      <main className="App-content">
        <button type="button" onClick={btnGetReadingClick}>Get Reading</button>
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
  </>);
}