package com.test_tasks.interactive_map_app.service.impl;

import com.test_tasks.interactive_map_app.entity.Coordinate;
import com.test_tasks.interactive_map_app.repository.CoordinateRepository;
import com.test_tasks.interactive_map_app.service.CoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinateServiceImpl implements CoordinateService {

    private CoordinateRepository coordinateRepository;

    @Autowired
    public CoordinateServiceImpl(CoordinateRepository coordinateRepository) {
        this.coordinateRepository = coordinateRepository;
    }

    @Override
    public List<Coordinate> getAll() {
        return coordinateRepository.findAll();
    }

    @Override
    public void saveCoordinate(Coordinate coordinate) {
        coordinateRepository.save(coordinate);
    }

    @Override
    public Optional<Coordinate> getCoordinateById(Long coordinateId) {
        return coordinateRepository.findById(coordinateId);
    }

    @Override
    public void removeCoordinate(Coordinate coordinate) {
        coordinateRepository.delete(coordinate);
    }

    @Override
    public void removeAll() {
        coordinateRepository.deleteAll();
    }
}
