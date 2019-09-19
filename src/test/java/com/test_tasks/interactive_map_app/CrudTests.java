package com.test_tasks.interactive_map_app;

import com.test_tasks.interactive_map_app.controller.PropertyController;
import com.test_tasks.interactive_map_app.entity.Coordinate;
import com.test_tasks.interactive_map_app.entity.Property;
import com.test_tasks.interactive_map_app.helper.TestHelper;
import com.test_tasks.interactive_map_app.service.CoordinateService;
import com.test_tasks.interactive_map_app.service.PropertyService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudTests {

    @Autowired
    private CoordinateService coordinateService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private TestHelper testHelper;
    private List<Property> propertyList = new ArrayList<>();

    @Before
    public void setUp() {
        propertyList = testHelper.createPropertyList();
    }

    @After
    public void tearDown() {
        testHelper.deleteAll();
    }

    @Test
    public void createProperty() {
        Coordinate coordinate = new Coordinate(50.449540, 30.518483);
        coordinateService.saveCoordinate(coordinate);

        Property property = new Property();
        property.setCoordinate(coordinate);
        propertyList.add(property);
        propertyService.saveProperty(property);

        Integer expectedListSize = propertyList.size();
        Integer actualListSize = propertyService.getAll().size();

        Assert.assertEquals(expectedListSize, actualListSize);
    }

    @Test
    public void getPropertyById() {
        Optional<Property> optionalProperty = propertyService.getPropertyById(2L);
        Assert.assertTrue(optionalProperty.isPresent());
    }

    @Test
    public void updateProperty() {
        String expectedAddress = "Kiev";

        Property property = propertyService.getPropertyById(2L).get();
        property.setAddress(expectedAddress);
        propertyService.updateProperty(property);
        Property updatedProperty = propertyService.getPropertyById(2L).get();
        Assert.assertEquals(expectedAddress, updatedProperty.getAddress());

        Integer expectedListSize = propertyList.size();
        Integer actualListSize = propertyService.getAll().size();
        Assert.assertEquals(expectedListSize, actualListSize);
    }

    @Test
    public void deleteProperty() {
        Property property = propertyService.getPropertyById(2L).get();
        propertyService.removeProperty(property);
        Integer expectedListSize = propertyList.size();
        Integer actualListSize = propertyService.getAll().size();
        Assert.assertTrue(expectedListSize > actualListSize);
        expectedListSize --;
        Assert.assertEquals(expectedListSize, actualListSize);
    }
}
