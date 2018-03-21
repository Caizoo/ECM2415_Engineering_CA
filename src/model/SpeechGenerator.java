package model;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.File;
import java.io.FileOutputStream;
import java.io.DataOutputStream;

/**
 * Speech generation using Microsoft Cognitive Services
 *
 * Original code by David Wakeling
 *
 * @auhtor David Wakeling, Joshua Chalcroft
 *  - Changed some attributes to non-final as they could be changed via the SpeechMode class
 *  - Added set and (currently unused) get methods for these attributes
 *  - Changed access modifiers of attributes and provided methods
 */
public class SpeechGenerator
{
    private final static String KEY = "e9488f2304204a599d806da749983124";
    private final static String OUTPUT = "sound_output.wav";
    private final static String PATH   = "res/directions/"+OUTPUT;
    private final static String FORMAT = "riff-16khz-16bit-mono-pcm";

    private static String renewAccessToken(String key1)
    {
        final String method = "POST";
        final String url = "https://api.cognitive.microsoft.com/sts/v1.0/issueToken";
        final byte[] body = {};
        final String[][] headers = {{"Ocp-Apim-Subscription-Key", key1}, {"Content-Length", String.valueOf(body.length)}};
        byte[] response = HttpConnect.httpConnect(method, url, headers, body);
        return new String(response);
    }

    /*
     * Synthesize speech.
     */
    private static byte[] generateSpeech( String token, String text, String lang, String gender, String artist, String format)
    {
        try
        {
            if (text == null) throw new NullPointerException("No directions have been given");

            if ((lang == null) || (gender == null) || (artist == null)) throw new NullPointerException("language and artist must be specified");



            final String method = "POST";
            final String url = "https://speech.platform.bing.com/synthesize";
            final byte[] body = ("<speak version='1.0' xml:lang='en-us'>" + "<voice xml:lang='" + lang + "' " + "xml:gender='" + gender + "' " + "name='Microsoft Server Speech Text to Speech Voice " + artist + "'>" + text + "</voice></speak>").getBytes();
            final String[][] headers
                    = { { "Content-Type"             , "application/ssml+xml"      }
                    , { "Content-Length"           , String.valueOf( body.length ) }
                    , { "Authorization"            , "Bearer " + token             }
                    , { "X-Microsoft-OutputFormat" , format                        }
            };
            byte[] response = HttpConnect.httpConnect(method, url, headers, body);
            return response;
        }
        catch (NullPointerException e)
        {
            System.out.println(e);
            return null;
        }

        catch (Exception ex)
        {
            SoundPlayer.playError("res/errorMessages/MicrosoftError");
            return null;
        }
    }

    /*
     * Write data to file.
     */
    private static void writeData(byte[] buffer, String name)
    {
        try
        {
            File             file = new File(name);
            FileOutputStream fos  = new FileOutputStream(file);
            DataOutputStream dos  = new DataOutputStream(fos);
            dos.write(buffer);
            dos.flush();
            dos.close();
        }
        catch (Exception ex)
        {
            SoundPlayer.playError("The sat-nav has come across an error when producing voice for directions. Please try again");
        }
    }

    /*
     * Generate speech.
     */


    //text would likely be something like directions[0] or any other number
    //Using these parameters avoids using SpeechGenerator 'set' methods. E.g.
    //The setText method used in the MockSpeechGeneration class
    //Will look like generate(directions[0], mm.getLanguage(), mm.getGender(), mm.getArtist())
    public static void generate(String text, String lang, String gender, String artist)
    {
        //Store token in model manager, have thread that sleeps for 10 mins that renews token.
        final String token = renewAccessToken(KEY);
        System.out.println(lang);
        System.out.println(gender);
        System.out.println(artist);
        final byte[] speech = generateSpeech(token, text, lang, gender, artist, FORMAT);
        writeData(speech, PATH);
    }



}
