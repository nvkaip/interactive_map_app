package com.test_tasks.interactive_map_app.service;

import com.test_tasks.interactive_map_app.entity.Coordinate;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Optional;

public interface CoordinateService {
    List<Coordinate> getAll();
    void saveCoordinate(Coordinate coordinate);
    Optional<Coordinate> getCoordinateById(Long coordinateId);
    @PreAuthorize("isAuthenticated()")
    void removeCoordinate(Coordinate coordinate);
    void removeAll();
}
