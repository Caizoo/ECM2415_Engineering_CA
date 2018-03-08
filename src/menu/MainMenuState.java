/**
 * Author: Cai Davies
 */

package menu;

import main.MenuAction;
import main.NavigationAction;
import main.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class MainMenuState implements MenuState {

    private StateManager sm;

    private JFrame frame;
    private JPanel screen;
    private ActionListener listener;
    private Graphics2D renderer;

    ArrayList<JMenuButton> buttons = new ArrayList<>();

    public MainMenuState(StateManager sm) {
        this.sm = sm;
    }

    public void setRenderer(Graphics2D renderer) {
        this.renderer = renderer;
    }
    public void setFrame(JFrame frame) { this.frame = frame; }
    public void setPanel(JPanel screen) { this.screen = screen; }
    public void setListener(ActionListener listener) { this.listener = listener; }

    public void start() {
        // add all buttons to screen
        buttons.add(new JMenuButton("Where To", MenuAction.WHERE_TO_STATE, new File("res/buttonWhereTo.png")));
        buttons.add(new JMenuButton("Trip Computer", MenuAction.TRIP_COMPUTER_STATE, new File("res/buttonTripComputer.png")));
        buttons.add(new JMenuButton("Map", MenuAction.MAP_STATE, new File("res/buttonMap.png")));
        buttons.add(new JMenuButton("Speech", MenuAction.SPEECH_STATE, new File("res/buttonSpeech.png")));
        buttons.add(new JMenuButton("Satellite", MenuAction.SATELLITE_STATE, new File("res/buttonSatellite.png")));
        buttons.add(new JMenuButton("About", MenuAction.ABOUT_STATE, new File("res/buttonAbout.png")));

        for(JMenuButton b:buttons) {
            b.setPreferredSize(new Dimension(90,75)); // set preferred dimensions of buttons for 2x3 display
            b.setPreferredIconSize(new Dimension(40,40));
            b.addActionListener(listener); // add the action listener from StateManager to listen to the buttons' events
            screen.add(b); // add button to JPanel screen
        }
    }

    public void stop() {
        screen.removeAll();
    }

    public void render() {
        // render all buttons
        for(JMenuButton b:buttons) {
            b.repaint();
        }
    }

    public void actionPerformed(ActionEvent e) {
        // if a button has been clicked, redirect to the appropriate state
        sm.goToState(((JMenuButton)e.getSource()).menuAction);
    }

    public void navigationButton(NavigationAction e) {

    }

}
