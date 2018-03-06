package whereTo;
import main.NavigationAction;
import menu.MenuState;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TripComputer implements MenuState  {


    Graphics2D renderer;
    private JFrame frame;
    private JPanel screen;
    private ActionListener listener;



    @Override
    public void setRenderer(Graphics2D renderer) {
        this.renderer = renderer;
    }

    @Override
    public void setFrame(JFrame frame) {
        this.frame=frame;
    }

    @Override
    public void setPanel(JPanel panel) {
        this.screen=panel;
    }

    @Override
    public void setListener(ActionListener listener) {
        this.listener=listener;
    }

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

    }
    @Override
    public void navigationButton(NavigationAction e) {

    }
}
