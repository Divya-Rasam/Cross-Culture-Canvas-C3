import React, { useState, useEffect } from 'react';
import axios from 'axios';

function TestComponent() {
  const [message, setMessage] = useState('');

  useEffect(() => {
    axios.get('http://localhost:8080/api/test')
      .then(response => {
        setMessage(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
        setMessage('Error connecting to backend');
      });
  }, []);

  return (
    <div>
      <h1>Frontend Test</h1>
      <p>Backend says: {message}</p>
    </div>
  );
}

export default TestComponent;