import React from 'react';
import './App.css';
import { Page } from './components/Page';

export default function App() {

  function showMessage(message, messageType) {
    alert(message);
  }

  return (
    <Page showMessage={showMessage} />
  );
}
