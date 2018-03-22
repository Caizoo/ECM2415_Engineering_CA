/**
 * @author Joshua Chalcraft
 */

package model;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Joshua Chalcraft
 *
 * Simulation class
 * - JSON data being sent from Directions.java
 * - JSONParser class handles the data and returns an ArrayList of the directions
 * - SpeechGenerator sets the language, gender and artist
 * - Go through each line of directions, convert text to speech and play the output
 *
 * By scrum 3, this behaviour should be exhibited through the GPS gui application (or behaviour similar)
 */


public class MockSpeechGeneration
{
    private static ArrayList<String> directions = new ArrayList<>();

    /*public static void play()
    {
        String data = Directions.sendToParser();
        JSONParser.getDirections(data, directions);
        for (String line : directions)
        {
            SpeechGenerator.setText(line);
            SpeechGenerator.generate();
            SoundPlayer.play();
        }
    }*/

    public static void main(String[] args)
    {
        Directions.setLanguage(Language.FRENCH.getCode());
        String data = Directions.sendToParser();
        ArrayList<HashMap<String,String>> directions = JSONParser.getDirections(data);


        for (HashMap<String,String> leg : directions)
        {
            String token = SpeechGenerator.renewAccessToken();
            String line = leg.get("Directions");
            System.out.println(line);
            SpeechGenerator.generate(token, line, Language.FRENCH.getCode(), Language.FRENCH.getGender(), Language.FRENCH.getArtist());
            SoundPlayer.playDirection();
        }
    }
}

/**/

















/*
public class SpeechMain
{
    private static ArrayList<String> directions = new ArrayList<>();
    //static String input = "directions.json";
    //static String pathInput = "res/directions/" + input;
    public static void main(String[] args)
    {
        SpeechJSONParser.formDirections(directions);
        SpeechGenerator.setLanguage("en-US");
        SpeechGenerator.setGender("Apollo");
        SpeechGenerator.setArtist("(en-GB, Susan, Apollo)");
        for (String line : directions)
        {
            SpeechGenerator.setText(line);
            SpeechGenerator.generate();
            SoundPlayer.play();
        }
    }
}
*/