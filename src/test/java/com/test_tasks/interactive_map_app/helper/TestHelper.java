package com.test_tasks.interactive_map_app.helper;

import com.test_tasks.interactive_map_app.entity.Coordinate;
import com.test_tasks.interactive_map_app.entity.Property;
import com.test_tasks.interactive_map_app.service.CoordinateService;
import com.test_tasks.interactive_map_app.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestHelper {
    @Autowired
    private CoordinateService coordinateService;
    @Autowired
    private PropertyService propertyService;

    public void deleteAll(){
        propertyService.removeAll();
        coordinateService.removeAll();
    }

    public List<Property> createPropertyList(){
        List<Property> propertyList = new ArrayList<>();
        List<String> imagesList = new ArrayList<>();

        Coordinate coordinate = new Coordinate(50.434585, 30.546012);
        coordinateService.saveCoordinate(coordinate);
        Property property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.436203, 30.553883);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.444163, 30.536600);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.359571, 30.937878);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.444737, 30.525099);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.439899, 30.527073);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.521334, 30.495959);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.514894, 30.495444);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.516204, 30.439311);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.492184, 30.419913);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.483351, 30.419451);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.415588, 30.628953);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.388015, 30.604148);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.416736, 30.600286);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.427570, 30.326840);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.463426, 30.340058);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        coordinate = new Coordinate(50.490082, 30.376708);
        coordinateService.saveCoordinate(coordinate);
        property = new Property();
        property.setCoordinate(coordinate);
        property.setImages(imagesList);
        propertyList.add(property);
        propertyService.saveProperty(property);

        return propertyList;
    }
}
