package com.underground.c3_backend.entities;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "users")
public  class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ArtistProfile artistProfile;

    // CONSTRUCTORS
    public User() {
        this.createdAt = LocalDateTime.now();
    }

    public User(String username, String passwordHash, String email, UserRole role) {
        this();
        this.username = username;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
    }

    // GETTERS AND SETTERS
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPasswordHash() { return passwordHash; }
    public void setPasswodHash( String passwordHash ) { this.passwordHash = passwordHash; }
    public String getEmail() { return email; }
    public void setEmail ( String email ) { this.email = email; }
    public UserRole getRole() { return role; }
    public void setRole(UserRole role) { this.role = role; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public ArtistProfile getArtistProfile() { return artistProfile; }
    public void setArtistProfile(ArtistProfile artistProfile) { this.artistProfile = artistProfile; }

}






























































































































// package com.underground.c3_backend.entities;

// import java.time.LocalDateTime;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "users")
// public class User {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true)
//     private String username;

//     @Column(nullable = false)
//     private String passwordHash;

//     @Column(nullable = false, unique = true)
//     private String email;

//     @Enumerated(EnumType.STRING)
//     @Column(nullable = false)
//     private UserRole role;

//     @Column(name = "created_at")
//     private LocalDateTime createdAt;

//     @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//     private ArtistProfile artistProfile;

//     // Constructors
//     public User() {
//         this.createdAt = LocalDateTime.now();
//     }

//     public User(String username, String passwordHash, String email, UserRole role) {
//         this();
//         this.username = username;
//         this.passwordHash = passwordHash;
//         this.email = email;
//         this.role = role;
//     }

//     // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }
//     public String getUsername() { return username; }
//     public void setUsername(String username) { this.username = username; }
//     public String getPasswordHash() { return passwordHash; }
//     public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }
//     public UserRole getRole() { return role; }
//     public void setRole(UserRole role) { this.role = role; }
//     public LocalDateTime getCreatedAt() { return createdAt; }
//     public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
//     public ArtistProfile getArtistProfile() { return artistProfile; }
//     public void setArtistProfile(ArtistProfile artistProfile) { this.artistProfile = artistProfile; }
// }