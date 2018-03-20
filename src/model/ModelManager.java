/**
 * @author Cai Davies, Scott Woodward
 */

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
    double distance;

    public static String longitude,latitude,direction,time;


    // views

    private MenuState views[] = new MenuState[8];


    public ModelManager(UserController uc) {

        this.uc = uc;

        location = new MockLocation();
        mapGenerator = new Maps();
        directions = new Directions();
        speech = new SpeechGenerator();
        currentLanguage = new Language();
        currentLanguage.setLanguageType(Language.LanguageType.OFF);
        currentView = MenuAction.ON_OFF_STATE;
        longitude = "";
        latitude = "";
        direction = "0";
        time = "0";
        distance = 0;

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

        if(x[0]!=("") && latitude!=("")) {
            distance += ModelTripComputer.getDistance(Double.parseDouble(latitude),Double.parseDouble(longitude),
                    Double.parseDouble(x[0]),Double.parseDouble(x[1]));
        }

        latitude = x[0];
        longitude = x[1];
        direction = x[2];

        if(currentView==MenuAction.SATELLITE_STATE) {
            ((SatelliteMode)views[currentView.getVal()]).update(latitude,longitude);
        }else if(currentView==MenuAction.MAP_STATE){ //Added basic map state -Scott

            //Need to consider loss of signal and what to display
            if (Float.valueOf(time) + 10 < Float.valueOf(x[4]) || !direction.equals("")){
                ((MapState)views[currentView.getVal()]).update(latitude, longitude, direction, currentLanguage.getCode());
                time = x[4];
                if (!direction.equals("")) System.out.println(direction);
            }

        }else if(currentView==MenuAction.TRIP_COMPUTER_STATE){
            ((TripComputer)views[currentView.getVal()]).updateTripComputerMode(String.valueOf(distance),x[3],time);
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
