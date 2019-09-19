package com.test_tasks.interactive_map_app.service;

import com.test_tasks.interactive_map_app.entity.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PropertyService {
    List<Property> getAll();
    Page<Property> getAll(Pageable pageable);
    void saveProperty(Property property);
    Optional<Property> getPropertyById(Long propertyId);
    List<Property> getPropertiesInRadius(Double latitude, Double longitude,
                                         Integer radius, Pageable pageable);
    Property updateProperty(Property property);
    void removeProperty(Property property);
    void removePropertyById(Long propertyId);
    void removeAll();
}
