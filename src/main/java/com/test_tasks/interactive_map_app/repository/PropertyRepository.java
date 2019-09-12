package com.test_tasks.interactive_map_app.repository;

import com.test_tasks.interactive_map_app.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
