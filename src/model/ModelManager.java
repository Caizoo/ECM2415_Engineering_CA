package model;

import controller.MenuAction;
import controller.MockLocation;
import controller.UserController;
import view.*;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ModelManager {

    UserController uc;

    MockLocation location;
    Maps mapGenerator;
    Directions directions;
    SpeechGenerator speech;
    Language currentLanguage;
    private static MenuAction currentView = MenuAction.ON_OFF_STATE;

    public static String longitude,latitude,direction,time;


    // views

    private MenuState views[] = new MenuState[8];


    public ModelManager(UserController uc) {

        this.uc = uc;

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

        // create new state objects
        hardReset();

        // start the first state, and paint
        views[currentView.getVal()].start();
        uc.repaint();

        location.openPort("COM4");
        Thread thread = new Thread(location);
        thread.start();

    }

    public void update() {

        String[] x = location.getData();

        //Around +- 0.00002 roughly 2m radius

        if(currentView==MenuAction.ON_OFF_STATE) return;
        if(currentView==MenuAction.SATELLITE_STATE) {
            ((SatelliteMode)views[currentView.getVal()]).update(x[0],x[1]);
        }else if(currentView==MenuAction.MAP_STATE){ //Added basic map state -Scott
            //Only update if:
            //      - A certain amount of time has elapsed (Say 10-15 seconds)
            //      - The rotation needs to be changed
            //Need to consider loss of signal and what to display
            ((MapState)views[currentView.getVal()]).update(x[0], x[1], x[2]);
        }else if(currentView==MenuAction.TRIP_COMPUTER_STATE){
            //Update with lat, long and velocity with no restrictions
        }
    }

    public void doAction(NavigationAction action) {
        switch(action) {
            case POWER:
                if(currentView==MenuAction.ON_OFF_STATE) {
                    views[currentView.getVal()].stop();
                    currentView = MenuAction.MAIN_STATE;
                    views[currentView.getVal()].start();
                }else {
                    views[currentView.getVal()].stop();
                    currentView = MenuAction.ON_OFF_STATE;
                    views[currentView.getVal()].start();
                    uc.getScreen().removeAll();
                    uc.getScreen().repaint();
                    hardReset();
                }
                break;
            case MENU:
                if(currentView==MenuAction.MAIN_STATE) return;
                views[currentView.getVal()].stop();
                currentView = MenuAction.MAIN_STATE;
                views[currentView.getVal()].stop();
                views[currentView.getVal()].start();
                //states[state.getVal()].render();
                break;
            case SELECT:
                views[currentView.getVal()].navigationButton(NavigationAction.SELECT);
                break;
            case PLUS:
                views[currentView.getVal()].navigationButton(NavigationAction.PLUS);
                break;
            case MINUS:
                views[currentView.getVal()].navigationButton(NavigationAction.MINUS);
                break;
        }
    }

    public void actionPerformed(ActionEvent e) {
        views[currentView.getVal()].actionPerformed(e);
    }

    public void goToState(MenuAction state) {
        if(views[currentView.getVal()]==null) return;
        views[currentView.getVal()].stop();
        currentView = state;
        views[currentView.getVal()].start();
        uc.revalidate();
        views[currentView.getVal()].render();
    }

    public void paint(Graphics2D g2d) {
        if(views[currentView.getVal()]!=null) views[currentView.getVal()].render();
    }

    public void paintScreen(Graphics2D g2d) {
        if(views[currentView.getVal()]!=null) views[currentView.getVal()].render();
    }

    public void hardReset() {
        views[MenuAction.ON_OFF_STATE.getVal()] = new OnOffState();
        views[MenuAction.MAIN_STATE.getVal()] = new MainMenuState(this);
        views[MenuAction.TRIP_COMPUTER_STATE.getVal()] = new TripComputer();
        views[MenuAction.WHERE_TO_STATE.getVal()] = new WhereTo();
        views[MenuAction.MAP_STATE.getVal()] = new MapState();
        views[MenuAction.SPEECH_STATE.getVal()] = new SpeechMode(); //change by Josh - renamed class
        views[MenuAction.SATELLITE_STATE.getVal()] = new SatelliteMode();
        views[MenuAction.ABOUT_STATE.getVal()] = new AboutMode();

        for(MenuState view:views) {
            if(view!=null) {
                view.setRenderer((Graphics2D)(uc.getGraphics()));
                view.setFrame(uc);
                view.setListener(uc);
                view.setPanel(uc.getScreen());
            }
        }

    }

    public boolean isOff() { return currentView==MenuAction.ON_OFF_STATE; }

    public void setLanguage(Language language) { this.currentLanguage = language; }
    public void setView(MenuAction view) { this.currentView = view; }
    public Language getLanguage() { return this.currentLanguage; }
    public MenuAction getView() { return this.currentView; }
    public static MenuAction getViewState() { return currentView; }

}
