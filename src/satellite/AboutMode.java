package satellite;

import main.NavigationAction;
import menu.MenuState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutMode implements MenuState {

    private JFrame frame;
    private JPanel screen;
    private ActionListener listener;
    private Graphics2D renderer;


    @Override
    public void setRenderer(Graphics2D renderer) { this.renderer = renderer; }
    @Override
    public void setFrame(JFrame frame) { this.frame = frame; }
    @Override
    public void setPanel(JPanel panel) { this.screen = panel; }
    @Override
    public void setListener(ActionListener listener) { this.listener = listener; }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void render() {
        // draw picture size of screen
    }

    @Override
    public void navigationButton(NavigationAction e) {

    }
}
