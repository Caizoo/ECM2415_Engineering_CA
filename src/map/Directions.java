package map;


import java.net.URLEncoder;


/*
 * Directions using the Google Maps APIs.
 *
 * See https://developers.google.com/maps/documentation/directions/intro
 *
 * David Wakeling, 2018.
 *
 * Modified by Gabriel and Joshua.
 */
public class Directions {
    static String ORIGIN      = "The Forum, Exeter University";
    static String DESTINATION       = "Cathedral Green, Exeter";
    static String REGION      = "uk";
    static String MODE        = "walking"; /* "driving" */
    /*
     * Read directions.
     */
    static byte[] readDirections( String origin
            , String destination
            , String region
            , String mode ) {
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
            );
            final byte[] body
                    = {};
            final String[][] headers
                    = {};
            byte[] response = HttpConnect.httpConnect( method, url, headers, body );
            return response;
        } catch ( Exception ex ) {
            System.out.println( ex ); System.exit( 1 ); return null;
        }
    }

    /*
     * Turns byte array into string ready for JSON parsing.
     *
     * Method by Joshua Chalcraft
     */
    public static String sendToParser() {

        final byte[] ds = readDirections( ORIGIN, DESTINATION, REGION, MODE );
        String directions = new String(ds);
        return directions;
    }

    public void setOrigin(String origin){
        this.ORIGIN = origin;
    }

    public void setDestination(String destination){
        this.DESTINATION = destination;
    }

    public void setRegion(String region) {
        this.REGION = region;
    }
}
