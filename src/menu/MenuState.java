package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public interface MenuState {

    void actionPerformed(ActionEvent e);
    void setRenderer(Graphics2D renderer);
    void setFrame(JFrame frame);
    void render();
    void start();

}
