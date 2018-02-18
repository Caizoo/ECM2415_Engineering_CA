package menu;

import main.NavigationAction;
import main.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenuState implements MenuState {

    private JFrame frame = null;
    private JPanel screen = null;
    private ActionListener listener;
    private Graphics2D renderer = null;

    ArrayList<JButton> buttons = new ArrayList<>();

    public MainMenuState() {

    }

    public void setRenderer(Graphics2D renderer) {
        this.renderer = renderer;
    }
    public void setFrame(JFrame frame) { this.frame = frame; }
    public void setPanel(JPanel screen) { this.screen = screen; }
    public void setListener(ActionListener listener) { this.listener = listener; }

    private void loadResources() {
        /*
         JButton btnPower = null;
         JButton btnWhereTo = null;
         JButton btnTripComputer = null;
         JButton btnMap = null;
         JButton btnSpeech = null;
         JButton btnSatellite = null;
         JButton btnAbout = null;
         */

        buttons.add(new JButton("Where To"));
        buttons.add(new JButton("Trip Computer"));
        buttons.add(new JButton("Map"));
        buttons.add(new JButton("Speech"));
        buttons.add(new JButton("Satellite"));
        buttons.add(new JButton("About"));

        for(JButton b:buttons) {
            b.setPreferredSize(new Dimension(90,75));
            b.addActionListener(listener);
            screen.add(b);
        }

    }

    public void start() {
        loadResources();
    }

    public void stop() {
        for(JButton b:buttons) {
            screen.remove(b);
        }
    }

    public void render() {
        for(JButton b:buttons) {
            b.repaint();
        }
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void navigationButton(NavigationAction e) {

    }

}
