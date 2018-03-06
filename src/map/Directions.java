package map;

import java.net.URLEncoder;

/*
 * Directions using the Google Maps APIs.
 *
 * See https://developers.google.com/maps/documentation/directions/intro
 *
 * David Wakeling, 2018.
 *
 * Modified by Gabriel
 */
public class Directions {
    final static String ORIGIN      = "The Forum, Exeter University";
    static String DESTINATION = null;
    final static String REGION      = "uk";
    final static String MODE        = "walking"; /* "driving" */
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
     * Print directions.
     */
    static void printDirections( byte[] dirs ) {
        for ( int i = 0; i < dirs.length; i++ ) {
            System.out.print( (char) dirs[ i ] );
        }
    }





    /*
     * Find directions.
     */
    public static void main( String[] argv ) {

        final byte[] ds = readDirections( ORIGIN, DESTINATION, REGION, MODE );
        printDirections( ds );
    }
}
