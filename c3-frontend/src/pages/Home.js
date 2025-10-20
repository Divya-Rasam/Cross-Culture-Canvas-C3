import React from 'react';
import { Container, Row, Col, Card } from 'react-bootstrap';

const Home = () => {
  return (
    <Container>
      <Row className="mb-4">
        <Col>
          <h1>Welcome to CROSS CULTURE CANVAS C3</h1>
          <p className="lead">
            Connecting underground artists with spaces in Mumbai
          </p>
        </Col>
      </Row>
      
      <Row>
        <Col md={4}>
          <Card className="mb-3">
            <Card.Body>
              <Card.Title>🎨 Artists</Card.Title>
              <Card.Text>
                Find and connect with local artists in Mumbai's underground scene
              </Card.Text>
            </Card.Body>
          </Card>
        </Col>
        
        <Col md={4}>
          <Card className="mb-3">
            <Card.Body>
              <Card.Title>📍 Spaces</Card.Title>
              <Card.Text>
                Discover legal spaces for creating and showcasing your art
              </Card.Text>
            </Card.Body>
          </Card>
        </Col>
        
        <Col md={4}>
          <Card className="mb-3">
            <Card.Body>
              <Card.Title>🎭 Culture</Card.Title>
              <Card.Text>
                Join a community of rappers, graffiti artists, and skateboarders
              </Card.Text>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

export default Home;