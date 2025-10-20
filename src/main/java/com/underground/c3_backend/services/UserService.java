package com.underground.c3_backend.services;

import com.underground.c3_backend.dto.UserRegistrationDto;
import com.underground.c3_backend.entities.ArtistProfile;
import com.underground.c3_backend.entities.User;
import com.underground.c3_backend.entities.UserRole;
import com.underground.c3_backend.repositories.ArtistProfileRepository;
import com.underground.c3_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArtistProfileRepository artistProfileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(UserRegistrationDto registrationDto) {
        // Check if username or email already exists
        if (userRepository.existsByUsername(registrationDto.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.existsByEmail(registrationDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Create new user
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPasswordHash(passwordEncoder.encode(registrationDto.getPassword()));
        user.setEmail(registrationDto.getEmail());
        user.setRole(UserRole.ARTIST);

        // Save user
        user = userRepository.save(user);

        // Create artist profile
        ArtistProfile artistProfile = new ArtistProfile();
        artistProfile.setUser(user);
        artistProfile.setDisplayName(registrationDto.getDisplayName());
        artistProfile.setBio(registrationDto.getBio());
        artistProfile.setLocation(registrationDto.getLocation());

        artistProfileRepository.save(artistProfile);

        return user;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}