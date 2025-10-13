package com.underground.c3_backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.underground.c3_backend.entities.Space;
import com.underground.c3_backend.entities.SpaceStatus;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {
    List<Space> findByStatus(SpaceStatus status);
    
    @Query("SELECT s FROM Space s WHERE s.status = :status")
    List<Space> findApprovedSpaces(@Param("status") SpaceStatus status);
    
    List<Space> findBySubmittedByUserId(Long userId);
}