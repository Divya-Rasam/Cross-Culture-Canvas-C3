package com.underground.c3_backend.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artist_profiles")
public class ArtistProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String displayName;

    @Column(length = 1000)
    private String bio;

    @Column(name = "location")
    private String location;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "artist_art_forms", joinColumns = @JoinColumn(name = "artist_profile_id"))
    private Set<ArtForm> artForms = new HashSet<>();

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Constructors
    public ArtistProfile() {
        this.createdAt = LocalDateTime.now();
    }

    public ArtistProfile(User user, String displayName, String bio, String location) {
        this();
        this.user = user;
        this.displayName = displayName;
        this.bio = bio;
        this.location = location;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public Set<ArtForm> getArtForms() { return artForms; }
    public void setArtForms(Set<ArtForm> artForms) { this.artForms = artForms; }
    public String getProfileImageUrl() { return profileImageUrl; }
    public void setProfileImageUrl(String profileImageUrl) { this.profileImageUrl = profileImageUrl; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}