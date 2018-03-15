package model;

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
