package model;
/*
public enum Language {

    ENGLISH(new String[] {"en-US","Apollo","(en-GB,Susan,Apollo)"}),
    FRENCH(new String[] {"fr-FR","Apollo","(fr-FR, Julie, Apollo)"}),
    GERMAN(new String[] {"de-DE","Hedda","(de-DE, Hedda)"}),
    ITALIAN(new String[] {"it-IT","Apollo","(it-IT, Cosimo, Apollo)"}),
    SPANISH(new String[] {"es-ES","Apollo","(es-ES, Laura, Apollo)"})
    ;
    private String[] data;
    Language(String[] data) { this.data = data; }
    public String[] getData() { return data; }

}

public enum Language
{
    OFF(new HashMap<>(){{put(null,null);put(null,null);put(null,null);}}),
    ENGLISH(new HashMap<>(){{put("Code","en-US");put("Gender","Apollo");put("Artist", "(en-GB,Susan,Apollo)");}}),
    FRENCH(new HashMap<>(){{put("Code","fr-FR");put("Gender","Apollo");put("Artist", "(fr-FR,Julie,Apollo)");}}),
    GERMAN(new HashMap<>(){{put("Code","de-DE");put("Gender","Hedda");put("Artist", "(de-DE,Hedda)");}}),
    ITALIAN(new HashMap<>(){{put("Code","it-IT");put("Gender","Apollo");put("Artist", "(fr-FR,Cosimo,Apollo)");}}),
    SPANISH(new HashMap<>(){{put("Code","es-ES");put("Gender","Apollo");put("Artist", "(fr-FR,Laura,Apollo)");}}),
    ;



    private HashMap<String,String> data;

    Language(HashMap<String,String> data)
    {
        this.data = data;
    }
    public HashMap<String,String> getdata()
    {
        return data;
    }
}
*/


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
        return language.getdata().get("Code");
    }

    public String getGender()
    {
        return language.getdata().get("Gender");
    }


    public String getArtist()
    {
        return language.getdata().get("Artist");
    }

    public Language()
    {

    }


    public enum LanguageType
    {
        OFF(new HashMap<>() {{
            put(null, null);
            put(null, null);
            put(null, null);
        }}),
        ENGLISH(new HashMap<>() {{
            put("Code", "en-US");
            put("Gender", "Apollo");
            put("Artist", "(en-GB,Susan,Apollo)");
        }}),
        FRENCH(new HashMap<>() {{
            put("Code", "fr-FR");
            put("Gender", "Apollo");
            put("Artist", "(fr-FR,Julie,Apollo)");
        }}),
        GERMAN(new HashMap<>() {{
            put("Code", "de-DE");
            put("Gender", "Hedda");
            put("Artist", "(de-DE,Hedda)");
        }}),
        ITALIAN(new HashMap<>() {{
            put("Code", "it-IT");
            put("Gender", "Apollo");
            put("Artist", "(fr-FR,Cosimo,Apollo)");
        }}),
        SPANISH(new HashMap<>() {{
            put("Code", "es-ES");
            put("Gender", "Apollo");
            put("Artist", "(fr-FR,Laura,Apollo)");
        }}),;


        private HashMap<String, String> data;

        LanguageType(HashMap<String, String> data) {
            this.data = data;
        }

        public HashMap<String,String> getdata()
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

/*
import java.util.HashMap;

public enum Language
{
    OFF(new HashMap<>() {{
        put(null, null);
        put(null, null);
        put(null, null);
    }}),
    ENGLISH(new HashMap<>() {{
        put("Code", "en-US");
        put("Gender", "Apollo");
        put("Artist", "(en-GB,Susan,Apollo)");
    }}),
    FRENCH(new HashMap<>() {{
        put("Code", "fr-FR");
        put("Gender", "Apollo");
        put("Artist", "(fr-FR,Julie,Apollo)");
    }}),
    GERMAN(new HashMap<>() {{
        put("Code", "de-DE");
        put("Gender", "Hedda");
        put("Artist", "(de-DE,Hedda)");
    }}),
    ITALIAN(new HashMap<>() {{
        put("Code", "it-IT");
        put("Gender", "Apollo");
        put("Artist", "(fr-FR,Cosimo,Apollo)");
    }}),
    SPANISH(new HashMap<>() {{
        put("Code", "es-ES");
        put("Gender", "Apollo");
        put("Artist", "(fr-FR,Laura,Apollo)");
    }}),;


    private HashMap<String, String> data;

    Language(HashMap<String, String> data)
    {
        this.data = data;
    }


    public String getCode()
    {
        return Language
    }


    public void setLanguage(Language l)
    {
        this.language = l;
    }


    public static void main(String[] args)
    {
        Language language = Language.OFF; //default

    }
}
*/

