package menu;

import main.NavigationAction;
import main.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnOffState implements MenuState {

    private JFrame frame = null;
    private JPanel screen = null;
    private ActionListener listener;
    private Graphics2D renderer = null;

    public OnOffState() {

    }

    public void setRenderer(Graphics2D renderer) {
        this.renderer = renderer;
    }
    public void setFrame(JFrame frame) { this.frame = frame; }
    public void setPanel(JPanel screen) { this.screen = screen; }
    public void setListener(ActionListener listener) { this.listener = listener; }

    private void loadResources() {

    }

    public void start() {
        loadResources();
    }

    public void stop() {

    }

    public void render() {

    }

    public void actionPerformed(ActionEvent e) {

    }

    public void navigationButton(NavigationAction e) {

    }


}
