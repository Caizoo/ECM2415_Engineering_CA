package menu;

import java.awt.*;
import java.awt.event.ActionEvent;

public interface MenuState {

    public void actionPerformed(ActionEvent e);
    public void setRenderer(Graphics2D renderer);
    public void render();
    public void start();

}
