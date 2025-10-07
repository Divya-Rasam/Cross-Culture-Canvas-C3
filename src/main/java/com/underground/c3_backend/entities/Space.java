package com.underground.c3_backend.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spaces")
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private String address;

    @Column(length = 1000)
    private String rules;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "space_art_forms", joinColumns = @JoinColumn(name = "space_id"))
    private Set<ArtForm> allowedArtForms = new HashSet<>();

    @Column(name = "contact_info")
    private String contactInfo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SpaceStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "submitted_by")
    private User submittedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Constructors
    public Space() {
        this.createdAt = LocalDateTime.now();
        this.status = SpaceStatus.PENDING;
    }

    public Space(String name, String description, String address, String rules, Set<ArtForm> allowedArtForms, String contactInfo, User submittedBy) {
        this();
        this.name = name;
        this.description = description;
        this.address = address;
        this.rules = rules;
        this.allowedArtForms = allowedArtForms;
        this.contactInfo = contactInfo;
        this.submittedBy = submittedBy;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getRules() { return rules; }
    public void setRules(String rules) { this.rules = rules; }
    public Set<ArtForm> getAllowedArtForms() { return allowedArtForms; }
    public void setAllowedArtForms(Set<ArtForm> allowedArtForms) { this.allowedArtForms = allowedArtForms; }
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public SpaceStatus getStatus() { return status; }
    public void setStatus(SpaceStatus status) { this.status = status; }
    public User getSubmittedBy() { return submittedBy; }
    public void setSubmittedBy(User submittedBy) { this.submittedBy = submittedBy; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}