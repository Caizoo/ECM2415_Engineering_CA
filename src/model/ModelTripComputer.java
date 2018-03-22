/**
 * @author Rob Wells
 */
package model;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ModelTripComputer {

    long startTime;
    public ModelTripComputer(){
        startTime=System.currentTimeMillis();
    }
    public static Double deg2rad(Double deg) {
        return deg * (Math.PI / 180);
    }


    public static double getDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
        int r = 6371;
        double dLat = deg2rad(lat2 - lat1);
        double dLon = deg2rad(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = r* c;
        return d;
    }

    public static String getTimeInMins(int timeSeconds){
        int timeMins =0;
        while ((timeSeconds -60) >=0){
            timeSeconds-=60;
            timeMins+=1;
        }
        return Integer.toString(timeMins)+" Min "+Integer.toString(timeSeconds)+" Sec";
    }
    public static int getCurrentTime(){
        long startTime = ModelManager.getStartTime();
        long elapsedTime = System.currentTimeMillis() - startTime;
        long elapsedSeconds = elapsedTime / 1000;
        return (int) elapsedSeconds;

    }
    public  static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();

    }


}
