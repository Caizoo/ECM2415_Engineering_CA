package main;

import menu.MenuState;
import menu.QuickMenuState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StateManager extends JFrame implements ActionListener{

    MenuState states[] = new MenuState[6];
    Graphics2D g;

    public static final int MAIN_STATE = 0;
    public static final int WHERE_TO_STATE = 1;
    public static final int TRIP_COMPUTER_STATE = 2;
    public static final int MAP_STATE = 3;
    public static final int SPEECH_STATE = 4;
    public static final int SATELLITE_STATE = 5;
    public static final int ABOUT_STATE = 6;

    public static int state = 0;

    public StateManager() {
        setTitle("GPS");
        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void start() {
        this.g = (Graphics2D)(super.getGraphics());

        states[0] = new QuickMenuState();
        states[0].setRenderer(g);
        states[0].setFrame(this);
        states[state].start();
        states[state].render();
    }

    public void backFromState() {
        state = 0;
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        states[state].render();
    }

    public void actionPerformed(ActionEvent e) {
        states[state].actionPerformed(e);
    }


}
