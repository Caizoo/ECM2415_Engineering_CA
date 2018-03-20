/**
 * @author Joshua Chalcraft
 */
package model;


/*
import java.util.HashMap;

public class Language
{
    private LanguageType language = LanguageType.OFF; //Default

    public void setLanguageType(LanguageType l)
    {
        this.language = l;
    }

    public LanguageType getLanguage()
    {
        return language;
    }

    public String getCode()
    {
        return language.getData().get("Code");
    }

    public String getGender()
    {
        return language.getData().get("Gender");
    }

    public String getArtist()
    {
        return language.getData().get("Artist");
    }

    public Language()
    {

    }


    public enum LanguageType
    {
        OFF(new HashMap<String, String>() {{
            put(null, null);
            put(null, null);
            put(null, null);
        }}),
        ENGLISH(new HashMap<String, String>() {{
            put("Code", "en-US");
            put("Gender", "Apollo");
            put("Artist", "(en-GB,Susan,Apollo)");
        }}),
        FRENCH(new HashMap<String, String>() {{
            put("Code", "fr-FR");
            put("Gender", "Apollo");
            put("Artist", "(fr-FR,Julie,Apollo)");
        }}),
        GERMAN(new HashMap<String, String>() {{
            put("Code", "de-DE");
            put("Gender", "Hedda");
            put("Artist", "(de-DE,Hedda)");
        }}),
        ITALIAN(new HashMap<String, String>() {{
            put("Code", "it-IT");
            put("Gender", "Apollo");
            put("Artist", "(fr-FR,Cosimo,Apollo)");
        }}),
        SPANISH(new HashMap<String, String>() {{
            put("Code", "es-ES");
            put("Gender", "Apollo");
            put("Artist", "(fr-FR,Laura,Apollo)");
        }}),;


        private HashMap<String, String> data;

        LanguageType(HashMap<String, String> data) {
            this.data = data;
        }

        public HashMap<String,String> getData()
        {
            return data;
        }

    }

    public static void main(String[] args)
    {
        Language language = new Language();
        language.setLanguageType(LanguageType.FRENCH);
        String code = language.getCode();
        String gender = language.getGender();
        String artist = language.getArtist();
        System.out.println(code + " " + gender + " " + artist);
    }
}
*/

import java.util.HashMap;

public enum Language
{
    OFF(new HashMap<String, String>() {{
        put(null, null);
        put(null, null);
        put(null, null);
    }}),
    ENGLISH(new HashMap<String, String>() {{
        put("Code", "en-US");
        put("Gender", "Apollo");
        put("Artist", "(en-GB,Susan,Apollo)");
    }}),
    FRENCH(new HashMap<String, String>() {{
        put("Code", "fr-FR");
        put("Gender", "Apollo");
        put("Artist", "(fr-FR,Julie,Apollo)");
    }}),
    GERMAN(new HashMap<String, String>() {{
        put("Code", "de-DE");
        put("Gender", "Hedda");
        put("Artist", "(de-DE,Hedda)");
    }}),
    ITALIAN(new HashMap<String, String>() {{
        put("Code", "it-IT");
        put("Gender", "Apollo");
        put("Artist", "(fr-FR,Cosimo,Apollo)");
    }}),
    SPANISH(new HashMap<String, String>() {{
        put("Code", "es-ES");
        put("Gender", "Apollo");
        put("Artist", "(fr-FR,Laura,Apollo)");
    }}),;


    private HashMap<String, String> data;

    Language(HashMap<String, String> data) {
        this.data = data;
    }

    public HashMap<String,String> getData()
    {
        return data;
    }
    public String getCode() { return data.get("Code"); }
    public String getGender() { return data.get("Gender"); }
    public String getArtist() { return data.get("Artist"); }

}

