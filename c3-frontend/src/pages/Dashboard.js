import React from 'react';
import { Container, Row, Col, Card, Alert } from 'react-bootstrap';
import { useAuth } from '../context/AuthContext';
import ProtectedRoute from '../components/auth/ProtectedRoute';

const Dashboard = () => {
  const { user } = useAuth();

  return (
    <ProtectedRoute roles={['ARTIST', 'ADMIN']}>
      <Container>
        <Row className="mb-4">
          <Col>
            <h1>Artist Dashboard</h1>
            <Alert variant="info">
              Welcome to your personal dashboard, {user?.displayName || user?.username}!
            </Alert>
          </Col>
        </Row>
        
        <Row>
          <Col md={6}>
            <Card className="mb-3">
              <Card.Body>
                <Card.Title>My Profile</Card.Title>
                <Card.Text>
                  <strong>Username:</strong> {user?.username}
                </Card.Text>
                <Card.Text>
                  <strong>Role:</strong> {user?.role}
                </Card.Text>
                <Card.Text>
                  <strong>Location:</strong> {user?.location || 'Not specified'}
                </Card.Text>
                <Card.Text>
                  <strong>Bio:</strong> {user?.bio || 'No bio available'}
                </Card.Text>
              </Card.Body>
            </Card>
          </Col>
          
          <Col md={6}>
            <Card className="mb-3">
              <Card.Body>
                <Card.Title>Quick Actions</Card.Title>
                <Card.Text>
                  <ul>
                    <li><a href="/add-space">Add a new space</a></li>
                    <li><a href="/spaces">Browse available spaces</a></li>
                    <li>View your submitted spaces</li>
                    <li>Edit your profile</li>
                  </ul>
                </Card.Text>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      </Container>
    </ProtectedRoute>
  );
};

export default Dashboard;