package com.test_tasks.interactive_map_app.service.impl;

import com.test_tasks.interactive_map_app.entity.Property;
import com.test_tasks.interactive_map_app.repository.PropertyRepository;
import com.test_tasks.interactive_map_app.service.PropertyService;
import com.test_tasks.interactive_map_app.util.DistanceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    private PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Page<Property> getAll(Pageable pageable) {
        return propertyRepository.findAll(pageable);
    }

    @Override
    public void saveProperty(Property property) {
        propertyRepository.save(property);
    }

    @Override
    public Optional<Property> getPropertyById(Long propertyId) {
        return propertyRepository.findById(propertyId);
    }

    @Override
    public List<Property> getPropertiesInRadius(Double latitude, Double longitude,
                                                Integer radius, Pageable pageable) {
        return propertyRepository.findAll().stream()
                .filter(property -> {
                    double propertyLatitude = property.getCoordinate().getLatitude();
                    double propertyLongitude = property.getCoordinate().getLongitude();
                    return DistanceCalculator.distance(latitude, longitude,
                            propertyLatitude, propertyLongitude, "K") <= radius;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void updateProperty(Property property) {
        propertyRepository.save(property);
    }

    @Override
    public void removeProperty(Property property) {
        propertyRepository.delete(property);
    }
}
