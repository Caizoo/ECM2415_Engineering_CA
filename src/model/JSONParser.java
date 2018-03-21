package model;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * @author Joshua Chalcraft
 *
 * Class takes in JSON data stored as a string and extracts directions, which are stored in an ArrayList
 *
 * Code is open for extension. Could be used later to extract lang and long info, as well as distance and other things
 *
 * Examples of this are given (commented out) in the parseJSON method
 *
 * Code requires gson-2.2.2.jar to run, which is stored in the lib folder
 */

public class JSONParser
{
    /*
     * Traverse through JSON data and extract useful information. Commented code to be extended for another sprint.
     */
    private static void parseJSON(String data, ArrayList<String> directions)
    {
        try
        {
            //Moving to the 'steps' JsonArray, which is where the data we want is stored.
            JsonObject obj1 = new JsonParser().parse(data).getAsJsonObject(); //Parse string from Directions.
            if(obj1.get("error_message") != null) throw new IndexOutOfBoundsException();
            JsonArray routes = obj1.getAsJsonArray("routes");
            JsonObject obj2 = routes.get(0).getAsJsonObject();
            JsonArray legs = obj2.getAsJsonArray("legs");
            JsonObject obj3 = legs.get(0).getAsJsonObject();
            JsonArray steps = obj3.getAsJsonArray("steps");

            //Go through the 'steps' and pick out the data required.
            Iterator<JsonElement> it = steps.iterator();
            while (it.hasNext())
            {
                JsonObject names = it.next().getAsJsonObject();
                String direction = names.get("html_instructions").toString();
                directions.add(direction);

                //JsonObject distance = names.getAsJsonObject("distance");
                //String text = distance.get("text").toString();
                //Double value = distance.get("value").getAsDouble();

                //JsonObject startLocation = names.getAsJsonObject("start_location");
                //Double sLat = startLocation.get("lat").getAsDouble();
                //Double sLng = startLocation.get("lng").getAsDouble();

                //JsonObject endLocation = names.getAsJsonObject("end_location");
                //Double eLat = endLocation.get("lat").getAsDouble();
                //Double eLng = endLocation.get("lng").getAsDouble();
            }
        }
        catch (IndexOutOfBoundsException ex) {SoundPlayer.playError("res/errorMessages/GoogleError.wav");}
        catch (Exception ex) {SoundPlayer.playError("res/errorMessages/GoogleError.wav");}
    }

    /*
     * Removes the HTML tags from the direction strings and elongates abbreviated terms. Used before generating speech.
     */
    private static ArrayList<String> filter(ArrayList<String> directions)
    {
        for (int i =0; i<directions.size(); i++)
        {
            directions.set(i, directions.get(i).replaceAll("<.*?>", " "));
            directions.set(i, enlongator(directions.get(i)));
        }
        return directions;
    }

    /*
     * Elongates abbreviated words. E.g. 'rd' to 'road'
     */
    private static String enlongator(String line)
    {
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++)
        {
            switch (words[i])
            {
                case "Rd": words[i] = "Road"; break;
                case "Ln": words[i] = "Lane"; break;
                case "Dr": words[i] = "Drive"; break;
                case "Av": words[i] = "Avenue"; break;
                case "St": words[i] = "Street"; break;
                default: break;
            }
        }
        return line.join(" ", words);
    }

    /*
     * Returns the directions.
     */
    public static ArrayList<String> getDirections(String data, ArrayList<String> directions)
    {
        JSONParser.parseJSON(data, directions);
        directions = JSONParser.filter(directions);
        return directions;
    }
}





