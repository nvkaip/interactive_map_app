package com.test_tasks.interactive_map_app;

import com.test_tasks.interactive_map_app.controller.PropertyController;
import com.test_tasks.interactive_map_app.entity.Property;
import com.test_tasks.interactive_map_app.helper.TestHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaginationTests {

    @Autowired
    private PropertyController propertyController;
    @Autowired
    private TestHelper testHelper;

    @Before
    public void setUp() {
        testHelper.createPropertyList();
    }

    @After
    public void tearDown() {
        testHelper.deleteAll();
    }

    @Test
    public void gettingListSizeOfFirstPage(){
        int expectedSize = 10;
        Page<Property> properties = propertyController.getAllProperties(0, 10);
        Assert.assertEquals(expectedSize, properties.getNumberOfElements());
    }

    @Test
    public void gettingListSizeOfSecondPage(){
        int expectedSize = 7;
        Page<Property> properties = propertyController.getAllProperties(1, 10);
        Assert.assertEquals(expectedSize, properties.getNumberOfElements());
    }

    @Test
    public void gettingNumberOfPagesForTenElements(){
        int expected = 2;
        Page<Property> properties = propertyController.getAllProperties(0, 10);
        Assert.assertEquals(expected, properties.getTotalPages());
    }

    @Test
    public void gettingNumberOfPagesForFourElements(){
        int expected = 5;
        Page<Property> properties = propertyController.getAllProperties(0, 4);
        Assert.assertEquals(expected, properties.getTotalPages());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void pageOutOfBounds(){
        Page<Property> properties = propertyController.getAllProperties(7, 4);
        Property property = properties.getContent().get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void elementOutOfBounds(){
        Page<Property> properties = propertyController.getAllProperties(1, 10);
        Property property = properties.getContent().get(8);
    }
}
