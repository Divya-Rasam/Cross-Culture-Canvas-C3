import React, { useState, useEffect } from 'react';
import axios from 'axios';

function TestComponent() {
  const [message, setMessage] = useState('');
  const [usernameAvailable, setUsernameAvailable] = useState(null);
  const [registrationResult, setRegistrationResult] = useState(null);

  // Test basic backend connection
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

  // Check username availability
  const checkUsername = () => {
    axios.get('http://localhost:8080/api/auth/check-username/testuser123')
      .then(response => {
        setUsernameAvailable(response.data.available);
      })
      .catch(error => {
        console.error('Error checking username:', error);
      });
  };

  // Test user registration
  const registerUser = () => {
    const userData = {
      username: 'testuser123',
      password: 'password123',
      email: 'test@example.com',
      displayName: 'Test User',
      bio: 'I am a test user',
      location: 'Mumbai'
    };

    axios.post('http://localhost:8080/api/auth/register', userData)
      .then(response => {
        setRegistrationResult(response.data);
      })
      .catch(error => {
        console.error('Error registering user:', error);
        setRegistrationResult({ error: error.response?.data?.error || 'Registration failed' });
      });
  };

  return (
    <div style={{ padding: '20px' }}>
      <h1>CROSS CULTURE CANVAS C3 - API Test</h1>
      
      <div style={{ marginBottom: '20px' }}>
        <h2>Backend Connection</h2>
        <p>Backend says: {message}</p>
      </div>

      <div style={{ marginBottom: '20px' }}>
        <h2>Username Availability</h2>
        <button onClick={checkUsername}>Check Username 'testuser123'</button>
        {usernameAvailable !== null && (
          <p>Username 'testuser123' is: {usernameAvailable ? 'Available' : 'Not Available'}</p>
        )}
      </div>

      <div style={{ marginBottom: '20px' }}>
        <h2>User Registration</h2>
        <button onClick={registerUser}>Register Test User</button>
        {registrationResult && (
          <div>
            {registrationResult.error ? (
              <p style={{ color: 'red' }}>Error: {registrationResult.error}</p>
            ) : (
              <div>
                <p style={{ color: 'green' }}>Registration Successful!</p>
                <p>User ID: {registrationResult.userId}</p>
                <p>Username: {registrationResult.username}</p>
              </div>
            )}
          </div>
        )}
      </div>
    </div>
  );
}

export default TestComponent;