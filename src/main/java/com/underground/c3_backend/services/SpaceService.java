package com.underground.c3_backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.underground.c3_backend.entities.Space;
import com.underground.c3_backend.entities.SpaceStatus;
import com.underground.c3_backend.repositories.SpaceRepository;

@Service
public class SpaceService {

    @Autowired
    private SpaceRepository spaceRepository;

    public Space createSpace(Space space) {
    space.setStatus(SpaceStatus.APPROVED);  // Changed from PENDING to APPROVED
    return spaceRepository.save(space);
    }

    public List<Space> getAllApprovedSpaces() {
        return spaceRepository.findByStatus(SpaceStatus.APPROVED);
    }

    public List<Space> getSpacesByUser(Long userId) {
        return spaceRepository.findBySubmittedByUserId(userId);
    }

    public Space approveSpace(Long spaceId) {
        Space space = spaceRepository.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("Space not found"));
        space.setStatus(SpaceStatus.APPROVED);
        return spaceRepository.save(space);
    }

    public Space rejectSpace(Long spaceId) {
        Space space = spaceRepository.findById(spaceId)
                .orElseThrow(() -> new RuntimeException("Space not found"));
        space.setStatus(SpaceStatus.REJECTED);
        return spaceRepository.save(space);
    }
}