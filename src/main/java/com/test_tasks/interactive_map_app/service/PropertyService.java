package com.test_tasks.interactive_map_app.service;

import com.test_tasks.interactive_map_app.entity.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    List<Property> getAll();
    void saveProperty(Property property);
    Optional<Property> getPropertyById(Long propertyId);
    void removeProperty(Property property);
}
