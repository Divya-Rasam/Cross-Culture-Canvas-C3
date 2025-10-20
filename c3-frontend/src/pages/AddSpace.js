import React, { useState } from 'react';
import { Container, Card, Row, Col, Form, Button, Alert } from 'react-bootstrap';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const AddSpace = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    name: '',
    description: '',
    address: '',
    rules: '',
    allowedArtForms: [],
    contactInfo: ''
  });
  
  const [errors, setErrors] = useState({});
  const [success, setSuccess] = useState(false);
  const [loading, setLoading] = useState(false);

  const artFormOptions = ['RAP', 'GRAFFITI', 'SKATEBOARDING'];

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleArtFormChange = (artForm) => {
    const updatedArtForms = formData.allowedArtForms.includes(artForm)
      ? formData.allowedArtForms.filter(af => af !== artForm)
      : [...formData.allowedArtForms, artForm];
    
    setFormData({
      ...formData,
      allowedArtForms: updatedArtForms
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true);
    setErrors({});
    
    try {
      await axios.post('http://localhost:8080/api/spaces', formData);
      setSuccess(true);
      setTimeout(() => navigate('/spaces'), 2000);
    } catch (error) {
      if (error.response?.data?.error) {
        setErrors({ general: error.response.data.error });
      } else {
        setErrors({ general: 'Failed to add space. Please try again.' });
      }
    } finally {
      setLoading(false);
    }
  };

  if (success) {
    return (
      <Container className="mt-4">
        <Row className="justify-content-center">
          <Col md={8}>
            <Alert variant="success">
              <h4>Space Added Successfully!</h4>
              <p>Your space has been submitted for approval. You will be redirected to the spaces page...</p>
            </Alert>
          </Col>
        </Row>
      </Container>
    );
  }

  return (
    <Container className="mt-4">
      <Row className="justify-content-center">
        <Col md={8}>
          <Card>
            <Card.Body>
              <Card.Title as="h2" className="text-center">Add New Space</Card.Title>
              
              {errors.general && (
                <Alert variant="danger">{errors.general}</Alert>
              )}
              
              <Form onSubmit={handleSubmit}>
                <Form.Group className="mb-3">
                  <Form.Label>Space Name *</Form.Label>
                  <Form.Control
                    type="text"
                    name="name"
                    value={formData.name}
                    onChange={handleChange}
                    required
                  />
                </Form.Group>

                <Form.Group className="mb-3">
                  <Form.Label>Description</Form.Label>
                  <Form.Control
                    as="textarea"
                    name="description"
                    value={formData.description}
                    onChange={handleChange}
                    rows={3}
                  />
                </Form.Group>

                <Form.Group className="mb-3">
                  <Form.Label>Address *</Form.Label>
                  <Form.Control
                    type="text"
                    name="address"
                    value={formData.address}
                    onChange={handleChange}
                    required
                  />
                </Form.Group>

                <Form.Group className="mb-3">
                  <Form.Label>Rules/Guidelines</Form.Label>
                  <Form.Control
                    as="textarea"
                    name="rules"
                    value={formData.rules}
                    onChange={handleChange}
                    rows={3}
                  />
                </Form.Group>

                <Form.Group className="mb-3">
                  <Form.Label>Allowed Art Forms</Form.Label>
                  <div>
                    {artFormOptions.map((artForm) => (
                      <Form.Check
                        key={artForm}
                        inline
                        label={artForm}
                        type="checkbox"
                        checked={formData.allowedArtForms.includes(artForm)}
                        onChange={() => handleArtFormChange(artForm)}
                      />
                    ))}
                  </div>
                </Form.Group>

                <Form.Group className="mb-3">
                  <Form.Label>Contact Information</Form.Label>
                  <Form.Control
                    type="text"
                    name="contactInfo"
                    value={formData.contactInfo}
                    onChange={handleChange}
                  />
                </Form.Group>

                <div className="d-grid">
                  <Button variant="primary" type="submit" disabled={loading}>
                    {loading ? 'Submitting...' : 'Submit Space'}
                  </Button>
                </div>
              </Form>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

export default AddSpace;