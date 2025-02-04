package com.coworking.coworkingspace.service;

import com.coworking.coworkingspace.model.CoworkingSpace;
import com.coworking.coworkingspace.repository.CoworkingSpaceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoworkingSpaceService {
    private final CoworkingSpaceRepo repo;

    public CoworkingSpaceService(CoworkingSpaceRepo repo) {
        this.repo = repo;
    }

    public List<CoworkingSpace> getSpaces() {
        return repo.findAll();
    }

    public void saveSpace(CoworkingSpace space) {
        repo.save(space);
    }

    public void deleteSpace(int id) {
        Optional<CoworkingSpace> space = repo.findById(id);
        if (space.isPresent()) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Space with ID " + id + " not found.");
        }
    }
}
