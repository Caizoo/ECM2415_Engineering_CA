package speech;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/*
 * Joshua Chalcraft
 *
 */
public class SpeechJSONParser
{
    static String filePath = "res/directions/directions.json";
    public static ArrayList<String> readJSONFile(String file, ArrayList<String> directions)
    {
        try
        {
            JsonReader jsonReader = new JsonReader(new FileReader(file));
            jsonReader.beginObject();
            JsonToken token;
            mainLoop:
            while (jsonReader.hasNext())
            {
                while (jsonReader.hasNext()) //Will iterate until it finds the end of an object
                {
                    token = jsonReader.peek();

                    if (JsonToken.BEGIN_OBJECT.equals(token)) jsonReader.beginObject();
                    else if (JsonToken.BEGIN_ARRAY.equals(token)) jsonReader.beginArray();
                    else if (JsonToken.END_DOCUMENT.equals(token)) break mainLoop;
                    else if (JsonToken.STRING.equals(token)) jsonReader.nextString();
                    else if (JsonToken.NUMBER.equals(token)) jsonReader.nextDouble();
                    else if ((JsonToken.NAME.equals(token)))
                    {
                        if (jsonReader.nextName().equals("html_instructions"))
                        {
                            directions.add(jsonReader.nextString());
                        }
                    }
                }

                while (!jsonReader.hasNext()) //Will backtrack until jsonReader hasNext()
                {
                    token = jsonReader.peek();
                    if (JsonToken.END_OBJECT.equals(token)) jsonReader.endObject();
                    else if (JsonToken.END_ARRAY.equals(token)) jsonReader.endArray();
                }

            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
            System.exit(1);
        }
        catch (IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }
        return directions;
    }

    public static ArrayList<String> tagRemover(ArrayList<String> directions)
    {
        for (String line : directions)
        {
            line = line.replaceAll("\\<.*?\\>", " ");
            System.out.println(line);
        }
        return directions;
    }


    public static ArrayList<String> formDirections(ArrayList<String> directions)
    {
        directions = SpeechJSONParser.readJSONFile(filePath, directions);
        directions = SpeechJSONParser.tagRemover(directions);
        return directions;
    }

    public static ArrayList<String> getDirections(ArrayList<String> directions)
    {
        return directions;
    }




}

