import React, { useEffect, useState } from 'react';
import "../App.css"
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

  // const mocksensorData = {
  //   temperature: 26.32,
  //   gas: 12500,
  //   humidity: 22.8,
  //   pressure: 1020.3,
  //   timestamp: new Date().toLocaleString(),
  // };

  function processGetSensorDataSuccess(response, serverUrl) {
    const sensorData = JSON.parse(response);
    alert(sensorData);
    setSensorData(sensorData);
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

  async function fetchSensorData() {
    try {
      // const headers = {
      //   'Connection': 'keep-alive',
      //   // Other headers as needed
      // };
      // const fetchOptions = {
      //   method: "POST",
      //   mode: 'no-cors',
      //   headers: headers
      // };
      const headers = {
        'Content-Type': 'application/json',
        'Connection': 'keep-alive',
        'Accept': '*/*',
        'Content-Length': "0",
        "Accept-Encoding": "gzip, deflate, br"
        // Other headers as needed
      };

      const fetchOptions = {
        method: "POST",
        headers: headers,
        // Consider removing 'mode: 'no-cors'' if CORS is not an issue
        mode: 'no-cors' // or remove this line if CORS is not an issue
      };
      const response = await fetch('http://192.168.1.238:8080/sensordata', fetchOptions);
      // if (!response.ok) {
      //   throw new Error(`HTTP error! status: ${response.status}`);
      // }
      const data = await response;
      if (data) {
        data = response.json();
      }
      console.log(data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  }

  async function fetchData() {
    try {
      const headers = {
        'Content-Type': 'application/json',
        'Connection': 'keep-alive',
        'Accept': '*/*',
        'Content-Length': "0",
        "Accept-Encoding": "gzip, deflate, br"
        // Other headers as needed
      };
      const fetchOptions = {
        method: "POST",
        headers: headers,
        body: {},
        mode: 'no-cors' // or remove this line if CORS is not an issue
      };
      const dataToSend = null;
      const response = await fetch('http://192.168.1.238:8080/helloworld', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        mode: "no-cors"
        // ,
        // body: JSON.stringify(dataToSend)
      });
      // const response = await fetch('http://192.168.1.238:8080/sensordata');
      try {
        const jsonData = await response.json();
        alert(jsonData);
      } catch (error) {
        
      }
      try {
        const textData = await response.text();
        alert(textData);
      } catch (error) {
        
      }

    } catch (error) {
      console.error('Error fetching data:', error);
    }
  }

  const btnGetReadingClick = () => {
    // fetchData();
    // fetchSensorData();
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