package com.test_tasks.interactive_map_app.util;

public class DistanceCalculator {
    /**
     *
     * @param lat1 first latitude in double type
     * @param lon1 first latitude in double type
     * @param lat2 second latitude in double type
     * @param lon2 second latitude in double type
     * @param unit "K" - for Kilometers, "N" - for Nautical Miles, any other - for Miles
     * @return double type of distance in chosen units
     */
    public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        }
        else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
                    + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }
}
