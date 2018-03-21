package model;


import java.net.URLEncoder;


/**
 * Directions using the Google Maps APIs.
 *
 * See https://developers.google.com/maps/documentation/directions/intro
 *
 * David Wakeling, 2018.
 *
 * Modified by Gabriel Mulcahy and Joshua Chalcraft
 * @author David Wakeling, Gabriel Mulcahy, Joshua Chalcraft
 */
public class Directions {
    private static final String KEY   = "AIzaSyD-VVgKS5-_C_ptg68nJ6xr5RI7BsTCpRo";
    private static String origin      = "The Forum, Exeter University";//"The Forum, Exeter University";
    private static String destination = "Cathedral Green, Exeter";
    private static String region      = "uk";
    private static String mode        = "walking"; /* "driving" */
    private static String language    = "en-GB";
    /*
     * Read directions.
     */
    private static byte[] readDirections( String origin
            , String destination
            , String region
            , String mode
            , String language) {
        try {
            final String encOrigin      = URLEncoder.encode( origin,      "UTF-8" );
            final String encDestination = URLEncoder.encode( destination, "UTF-8" );
            final String method = "GET";
            final String url
                    = ( "https://maps.googleapis.com/maps/api/directions/json"
                    + "?" + "origin"      + "=" + encOrigin
                    + "&" + "destination" + "=" + encDestination
                    + "&" + "region"      + "=" + region
                    + "&" + "mode"        + "=" + mode
                    + "&" + "language"    + "=" + language
                    + "&" + "key"         + "=" + KEY
            );
            final byte[] body
                    = {};
            final String[][] headers
                    = {};
            byte[] response = HttpConnect.httpConnect( method, url, headers, body );
            return response;
        } catch ( Exception ex ) {
            System.out.println("Sat-nav has failed to obtain directions. Please try again."); return null; //Edited exception - Josh
        }
    }

    /*
     * Turns byte array into string ready for JSON parsing - Joshua Chalcraft
     */
    public static String sendToParser() { //Add all parameters as arguments
        final byte[] ds = readDirections( origin, destination, region, mode, language );
        String directions = new String(ds);
        return directions;
    }

    public static void setOrigin(String newOrigin){
        Directions.origin = newOrigin;
    }

    public static void setDestination(String newDestination){
        Directions.destination = newDestination;
    }

    public static void setRegion(String newRegion) {
        Directions.region = newRegion;
    }

    public static void setLanguage(String newLanguage) {
        Directions.language = newLanguage;
    }

    public String getLanguage() {
        return language;
    }
}
