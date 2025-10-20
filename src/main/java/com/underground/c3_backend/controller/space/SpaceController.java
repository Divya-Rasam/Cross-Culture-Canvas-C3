package com.underground.c3_backend.controller.space;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.underground.c3_backend.entities.Space;
import com.underground.c3_backend.services.SpaceService;

@RestController
@RequestMapping("/api/spaces")
public class SpaceController {

    @Autowired
    private SpaceService spaceService;

    @GetMapping
    public ResponseEntity<List<Space>> getAllApprovedSpaces() {
        List<Space> spaces = spaceService.getAllApprovedSpaces();
        return ResponseEntity.ok(spaces);
    }

    @PostMapping
    public ResponseEntity<?> createSpace(@RequestBody Space space) {
        try {
            Space createdSpace = spaceService.createSpace(space);
            return ResponseEntity.ok(createdSpace);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Space>> getSpacesByUser(@PathVariable Long userId) {
        List<Space> spaces = spaceService.getSpacesByUser(userId);
        return ResponseEntity.ok(spaces);
    }

    @PutMapping("/{spaceId}/approve")
    public ResponseEntity<?> approveSpace(@PathVariable Long spaceId) {
        try {
            Space space = spaceService.approveSpace(spaceId);
            return ResponseEntity.ok(space);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{spaceId}/reject")
    public ResponseEntity<?> rejectSpace(@PathVariable Long spaceId) {
        try {
            Space space = spaceService.rejectSpace(spaceId);
            return ResponseEntity.ok(space);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}