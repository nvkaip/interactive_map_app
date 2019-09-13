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
        Coordinate coordinate = new Coordinate(50.434585, 30.546012);
        coordinateList.add(coordinate);
        coordinateService.saveCoordinate(coordinate);
        coordinate = new Coordinate(50.436203, 30.553883);
        coordinateList.add(coordinate);
        coordinateService.saveCoordinate(coordinate);
        coordinate = new Coordinate(50.359571, 30.937878);
        coordinateList.add(coordinate);
        coordinateService.saveCoordinate(coordinate);
        Property property = new Property(3, 78.8, "Good property",
                "ул. Лейпцигская, 4/37, Киев, 02000", coordinateService.getAll().get(0));
        propertyList.add(property);
        propertyService.saveProperty(property);
        property = new Property(2, 58.8, "Not bad property",
                "ул. Лаврская, 17, Киев, 02000", coordinateService.getAll().get(1));
        propertyList.add(property);
        propertyService.saveProperty(property);
        property = new Property(1, 38.8, "Just a property",
                "ул. Киевский шлях, 41, Борисполь, 08300", coordinateService.getAll().get(2));
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
        expected.remove(2);
        List<Property> result =
                propertyService.getPropertiesInRadius(50.447721, 30.522350, 10, pageableProperties);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void updateProperty() {
        Property expected = propertyList.get(2);
        expected.setNumberOfRooms(2);
        expected.setArea(48.8);
        expected.setDescription("Nice property");
        propertyService.updateProperty(expected);
        Optional<Property> result = propertyService.getPropertyById(expected.getId());
        Assert.assertEquals(Optional.of(expected), result);
    }

    @Test
    public void removeProperty() {
        Coordinate coordinate = new Coordinate(50.459642, 30.370780);
        coordinateList.add(coordinate);
        coordinateService.saveCoordinate(coordinate);
        Property property = new Property(4, 178.8, "VIP property",
                "24A, ул. Беличанска, 24А, Киев, 02000", coordinate);
        propertyList.add(property);
        propertyService.saveProperty(property);
        Optional<Property> result = propertyService.getPropertyById(property.getId());
        Assert.assertEquals(Optional.of(property), result);
        propertyService.removeProperty(property);
        result = propertyService.getPropertyById(property.getId());
        Assert.assertEquals(Optional.empty(), result);
    }
}
