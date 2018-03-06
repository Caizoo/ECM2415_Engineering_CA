package speech;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
/*
 * Utilise JSON data stored via strings.
 *
 * Joshua Chalcraft
 */

public class JSONParser
{
    /*
     * Traverse through JSON data and extract useful information. Commented code to be extended for another sprint.
     */
    public static void parseJSON(String data, ArrayList<String> directions)
    {
        //Moving to the 'steps' JsonArray, which is where the data we want is stored.
        JsonObject obj1 = new JsonParser().parse(data).getAsJsonObject(); //Parse string from Directions.
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

    /*
     * Removes the HTML tags from the direction strings. Used before generating speech.
     */
    public static ArrayList<String> tagRemover(ArrayList<String> directions)
    {
        for (String line : directions)
        {
            line = line.replaceAll("\\<.*?\\>", " ");
            System.out.println(line);
        }
        return directions;
    }


    public static ArrayList<String> formDirections(String data, ArrayList<String> directions)
    {
        JSONParser.parseJSON(data, directions);
        directions = JSONParser.tagRemover(directions);
        return directions;
    }

    public static ArrayList<String> getDirections(ArrayList<String> directions)
    {
        return directions;
    }
}





