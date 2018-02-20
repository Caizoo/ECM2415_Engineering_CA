package menu;

import main.NavigationAction;
import main.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenuState implements MenuState {

    private StateManager sm;

    private JFrame frame;
    private JPanel screen;
    private ActionListener listener;
    private Graphics2D renderer;

    ArrayList<JButton> buttons = new ArrayList<>();

    public MainMenuState(StateManager sm) {
        this.sm = sm;
    }

    public void setRenderer(Graphics2D renderer) {
        this.renderer = renderer;
    }
    public void setFrame(JFrame frame) { this.frame = frame; }
    public void setPanel(JPanel screen) { this.screen = screen; }
    public void setListener(ActionListener listener) { this.listener = listener; }

    private void loadResources() {

        buttons.add(new JButton("Where To"));
        buttons.add(new JButton("Trip Computer"));
        buttons.add(new JButton("Map"));
        buttons.add(new JButton("Speech"));
        buttons.add(new JButton("Satellite"));
        buttons.add(new JButton("About"));

        for(JButton b:buttons) {
            b.setPreferredSize(new Dimension(90,75)); // set preferred dimensions of buttons for 2x3 display
            b.addActionListener(listener); // add the action listener from StateManager to listen to the buttons' events
            screen.add(b); // add button to JPanel screen
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
        if(e.getSource().equals(buttons.get(0))) {
            sm.goToState(StateManager.WHERE_TO_STATE);
        }
    }

    public void navigationButton(NavigationAction e) {

    }

}
