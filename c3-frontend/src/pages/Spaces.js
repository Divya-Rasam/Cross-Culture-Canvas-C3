import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Card, Spinner, Alert } from 'react-bootstrap';
import axios from 'axios';

const Spaces = () => {
  const [spaces, setSpaces] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchSpaces();
  }, []);

  const fetchSpaces = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/spaces');
      setSpaces(response.data);
      setLoading(false);
    } catch (err) {
      setError('Failed to load spaces');
      setLoading(false);
    }
  };

  if (loading) {
    return (
      <Container className="text-center mt-4">
        <Spinner animation="border" />
        <p>Loading spaces...</p>
      </Container>
    );
  }

  if (error) {
    return (
      <Container className="mt-4">
        <Alert variant="danger">{error}</Alert>
      </Container>
    );
  }

  return (
    <Container>
      <h1 className="mb-4">Available Spaces</h1>
      
      {spaces.length === 0 ? (
        <Alert variant="info">
          No spaces available yet. Be the first to add a space!
        </Alert>
      ) : (
        <Row>
          {spaces.map((space) => (
            <Col key={space.id} md={4} className="mb-3">
              <Card>
                <Card.Body>
                  <Card.Title>{space.name}</Card.Title>
                  <Card.Text>
                    <strong>Address:</strong> {space.address}
                  </Card.Text>
                  <Card.Text>
                    <strong>Status:</strong> {space.status}
                  </Card.Text>
                  {space.description && (
                    <Card.Text>
                      {space.description}
                    </Card.Text>
                  )}
                </Card.Body>
              </Card>
            </Col>
          ))}
        </Row>
      )}
    </Container>
  );
};

export default Spaces;