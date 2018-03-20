package model;

public class ModelTripComputer {
    private double currentLat = 360.00;//impossible value to tell its the inital latitiude
    private double currentLong = 360.00;//impossible value to tell its the inital longitiude
    private static double currentTime;
    private double totalDistance = 0;
    private double speed =0;

    public ModelTripComputer(){}
    public static Double deg2rad(Double deg) {
        return deg * (Math.PI / 180);
    }

    public void setVals(String latitude, String longitude, String speed, String time) {
        this.currentLat = Double.parseDouble(latitude);
        this.currentLong = Double.parseDouble(longitude);
        this.currentTime= Double.parseDouble(time);
        this.speed= Double.parseDouble(speed);
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


    public void setvalues(String latitude, String longitude, String speed, String time) {
        if (latitude.equals("") || longitude.equals("")) {

        } else {
            if (this.currentLat == 360.00 || this.currentLong == 360.00) {
                setVals(latitude, longitude,speed,time);
            }
            double distance = getDistance(currentLat, currentLong, Double.parseDouble(latitude), Double.parseDouble(longitude));
            totalDistance += distance;

            setVals(latitude, longitude,speed,time);
        }

    }
}
