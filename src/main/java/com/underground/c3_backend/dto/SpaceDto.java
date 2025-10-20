package com.underground.c3_backend.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SpaceDto {
    @NotBlank(message = "Space name is required")
    private String name;

    @Size(max = 2000, message = "Description must be less than 2000 characters")
    private String description;

    @NotBlank(message = "Address is required")
    private String address;

    @Size(max = 1000, message = "Rules must be less than 1000 characters")
    private String rules;

    private Set<String> allowedArtForms;

    @Size(max = 500, message = "Contact info must be less than 500 characters")
    private String contactInfo;

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getRules() { return rules; }
    public void setRules(String rules) { this.rules = rules; }
    public Set<String> getAllowedArtForms() { return allowedArtForms; }
    public void setAllowedArtForms(Set<String> allowedArtForms) { this.allowedArtForms = allowedArtForms; }
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
}