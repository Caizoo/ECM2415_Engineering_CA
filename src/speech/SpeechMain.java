package speech;

/*
 * Code by Joshua Chalcraft
 */

import java.util.ArrayList;

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
       // SpeechGenerator.generate();
        //SoundPlayer.play();
    }
}
