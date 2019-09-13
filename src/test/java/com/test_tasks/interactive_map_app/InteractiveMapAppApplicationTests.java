package com.test_tasks.interactive_map_app;

import com.test_tasks.interactive_map_app.entity.Coordinate;
import com.test_tasks.interactive_map_app.entity.Property;
import com.test_tasks.interactive_map_app.service.CoordinateService;
import com.test_tasks.interactive_map_app.service.PropertyService;
import org.junit.After;
import org.junit.Assert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InteractiveMapAppApplicationTests {

    @Autowired
    private CoordinateService coordinateService;
    @Autowired
    private PropertyService propertyService;
    private Pageable pageableProperties = PageRequest.of(0, 2);
    private List<Coordinate> coordinateList = new ArrayList<>();
    private List<Property> propertyList = new ArrayList<>();

    @Before
    public void setUp() {
        Coordinate coordinate = new Coordinate(32.9697, -96.80322);
        coordinateList.add(coordinate);
        coordinateService.saveCoordinate(coordinate);
        coordinate = new Coordinate(29.46786, -98.53506);
        coordinateList.add(coordinate);
        coordinateService.saveCoordinate(coordinate);
        coordinate = new Coordinate(30.9697, -97.80322);
        coordinateList.add(coordinate);
        coordinateService.saveCoordinate(coordinate);
        Property property = new Property(3, 78.8, "Good property",
                "Kiev", coordinateService.getAll().get(0));
        propertyList.add(property);
        propertyService.saveProperty(property);
        property = new Property(2, 58.8, "Not bad property",
                "Kiev", coordinateService.getAll().get(1));
        propertyList.add(property);
        propertyService.saveProperty(property);
        property = new Property(1, 38.8, "Just a property",
                "Kiev", coordinateService.getAll().get(2));
        propertyList.add(property);
        propertyService.saveProperty(property);
    }

    @After
    public void clearUp() {
        propertyService.removeAll();
        coordinateService.removeAll();
    }

    @Test
    public void getAllCoordinates() {
        List<Coordinate> result = coordinateService.getAll();
        Assert.assertEquals(coordinateList, result);
    }

    @Test
    public void getProperties() {
        List<Property> expected = propertyList.stream()
                .limit(2)
                .collect(Collectors.toList());
        Page<Property> properties = propertyService.getAll(pageableProperties);
        List<Property> result = properties.getContent();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void getPropertiesInRadius() {//TODO test real coordinates
        List<Property> expected = propertyList;
        expected.remove(1);
        List<Property> result =
                propertyService.getPropertiesInRadius(32.9697, -96.80322, 250, pageableProperties);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void updateProperty() {
        Property expected = new Property(2, 48.8, "Nice property",
                "Lviv", coordinateService.getAll().get(2));
        Long propertyId = propertyList.get(2).getId();
        Optional<Property> result = propertyService.getPropertyById(propertyId);
        if (result.isPresent()){
            Property property = result.get();
            property.setNumberOfRooms(2);
            property.setArea(48.8);
            property.setDescription("Nice property");
            property.setAddress("Lviv");
            propertyService.updateProperty(property);
        }
        expected.setId(propertyId);
        result = propertyService.getPropertyById(propertyId);
        Assert.assertEquals(Optional.of(expected), result);
    }

    @Test
    public void removeProperty() {
        Coordinate coordinate = new Coordinate(39.46786, -88.53506);
        coordinateList.add(coordinate);
        coordinateService.saveCoordinate(coordinate);
        Property property = new Property(4, 178.8, "VIP property",
                "Borispil", coordinate);
        propertyList.add(property);
        propertyService.saveProperty(property);
        Optional<Property> result = propertyService.getPropertyById(property.getId());
        Assert.assertEquals(Optional.of(property), result);
        propertyService.removeProperty(property);
        result = propertyService.getPropertyById(property.getId());
        Assert.assertEquals(Optional.empty(), result);
    }
}
