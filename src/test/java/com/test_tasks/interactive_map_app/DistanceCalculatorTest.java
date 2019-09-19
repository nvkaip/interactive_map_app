package com.test_tasks.interactive_map_app;

import com.test_tasks.interactive_map_app.entity.Coordinate;
import com.test_tasks.interactive_map_app.util.DistanceCalculator;
import org.junit.Assert;
import org.junit.Test;

public class DistanceCalculatorTest {

    @Test
    public void distanceLessThenTenKm() {
        Coordinate firstCoordinate = new Coordinate(52.248831, 21.010460);
        Coordinate secondCoordinate = new Coordinate(52.224936, 20.938879);
        Double expected = 10.0;
        Double result = DistanceCalculator.distance(
                firstCoordinate.getLatitude(), firstCoordinate.getLongitude(),
                secondCoordinate.getLatitude(), secondCoordinate.getLongitude(), "K");
        Assert.assertTrue("Coordinates is not in 10 km distance", expected > result);
    }

    @Test
    public void distanceGraterThenTenKm() {
        Coordinate firstCoordinate = new Coordinate(52.201021, 20.860083);
        Coordinate secondCoordinate = new Coordinate(52.191387, 21.571992);
        Double expected = 10.0;
        Double result = DistanceCalculator.distance(
                firstCoordinate.getLatitude(), firstCoordinate.getLongitude(),
                secondCoordinate.getLatitude(), secondCoordinate.getLongitude(), "K");
        Assert.assertTrue("Coordinates is in 10 km distance", expected < result);
    }
}