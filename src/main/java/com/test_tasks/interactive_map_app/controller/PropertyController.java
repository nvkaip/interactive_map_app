package com.test_tasks.interactive_map_app.controller;

import com.test_tasks.interactive_map_app.entity.Property;
import com.test_tasks.interactive_map_app.service.CoordinateService;
import com.test_tasks.interactive_map_app.service.PropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/property")
public class PropertyController {

    private PropertyService propertyService;
    private CoordinateService coordinateService;

    @Autowired
    public PropertyController(PropertyService propertyService, CoordinateService coordinateService) {
        this.propertyService = propertyService;
        this.coordinateService = coordinateService;
    }

    @GetMapping("/all/{page}{size}")
    public Page<Property> getAllProperties(@PathVariable("page") Integer page,
                                           @PathVariable("size") Integer size){
        log.info("Got a page of properties");
        return propertyService.getAll(PageRequest.of(page, size));
    }

    @PutMapping("/update")
    public Property updateProperty(@RequestBody Property property) {
        return propertyService.updateProperty(property);
    }

    @DeleteMapping("/delete")
    public void deleteProperty(@RequestBody Property property){
        propertyService.removeProperty(property);
    }

    @DeleteMapping("/delete/{propId}")
    public void deleteProperty(@PathVariable("propId") Long propId){
        propertyService.removePropertyById(propId);
    }
}
