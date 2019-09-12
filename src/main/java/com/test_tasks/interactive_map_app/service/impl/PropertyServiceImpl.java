package com.test_tasks.interactive_map_app.service.impl;

import com.test_tasks.interactive_map_app.entity.Property;
import com.test_tasks.interactive_map_app.repository.PropertyRepository;
import com.test_tasks.interactive_map_app.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    private PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<Property> getAll() {
        return null;
    }

    @Override
    public void saveProperty(Property property) {

    }

    @Override
    public Optional<Property> getPropertyById(Long propertyId) {
        return Optional.empty();
    }

    @Override
    public void removeProperty(Property property) {
        propertyRepository.delete(property);
    }
}
