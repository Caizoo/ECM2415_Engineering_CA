package model;

public class ModelTripComputer {


    public ModelTripComputer(){}
    public static Double deg2rad(Double deg) {
        return deg * (Math.PI / 180);
    }


    public static double getDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
        int r = 6371; // Radius of the earth in km
        double dLat = deg2rad(lat2 - lat1);  // deg2rad below
        double dLon = deg2rad(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = r* c; // Distance in km
        return d;
    }



}
