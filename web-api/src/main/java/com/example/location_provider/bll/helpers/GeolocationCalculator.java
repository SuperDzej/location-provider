package com.example.location_provider.bll.helpers;

public class GeolocationCalculator {
    public static double calculateDistanceInKilometers(double startLat, double startLong,
                                      double endLat, double endLong) {
        double startLatRadian = Math.toRadians(startLat);
        double endLatRadian = Math.toRadians(endLat);
        double startLongRadian = Math.toRadians(startLong);
        double endLongRadian = Math.toRadians(endLong);

        double distance = Math.acos(Math.sin(startLatRadian) * Math.sin(endLatRadian) +
                Math.cos(startLatRadian) * Math.cos(endLatRadian) * Math.cos(startLongRadian - endLongRadian));

        return Constants.EARTH_RADIUS * distance;
    }

    public static double calculateDistanceInMiles(double startLat, double startLong,
                                         double endLat, double endLong) {
        double kilometers = calculateDistanceInKilometers(startLat, startLong, endLat, endLong);
        return kilometers * Constants.MILE_FACTOR;
    }

    public static boolean isWithinDistanceFromCenter(double centerLat, double centerLong, double latitude, double longitude, double distance) {
        double resultDistance = calculateDistanceInMiles(centerLat, centerLong, latitude, longitude);
        return resultDistance <= distance;
    }
}
