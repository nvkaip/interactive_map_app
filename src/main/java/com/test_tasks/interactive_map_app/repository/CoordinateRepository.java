package com.test_tasks.interactive_map_app.repository;

import com.test_tasks.interactive_map_app.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {
}
