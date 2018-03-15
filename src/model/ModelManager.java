package model;

import controller.MenuAction;
import controller.MockLocation;
import controller.StateManager;

import java.awt.*;

public class ModelManager {

    MockLocation location;
    Maps mapGenerator;
    Directions directions;
    SpeechGenerator speech;
    Language currentLanguage;
    MenuAction currentView;


    public static String longitude,latitude,direction,time;


    public ModelManager() {
        location = new MockLocation();
        mapGenerator = new Maps();
        directions = new Directions();
        speech = new SpeechGenerator();
        currentLanguage = null;
        currentView = MenuAction.ON_OFF_STATE;
        longitude = "";
        latitude = "";
        direction = "0";
        time = "0";

        Thread thread = new Thread(location);
        thread.start();

    }

    /**TODO: BRING STATEMANAGER MODEL METHODS TO HERE*/

    public void update() {
        if(StateManager.getViewState()==MenuAction.SATELLITE_STATE) {

        }
    }



    public void setLanguage(Language language) { this.currentLanguage = language; }
    public void setView(MenuAction view) { this.currentView = view; }
    public Language getLanguage() { return this.currentLanguage; }
    public MenuAction getView() { return this.currentView; }


}
