package menu;

import menu.MenuState;

import java.awt.*;
import java.awt.event.ActionEvent;

public class QuickMenuState implements MenuState {

    Graphics2D renderer;

    int x = 200;
    int y = 200;

    public QuickMenuState() {

    }

    public void setRenderer(Graphics2D renderer) {
        this.renderer = renderer;
    }

    public void render() {
        renderer.setColor(Color.BLACK);
        renderer.clearRect(0,0,1280,720);
        renderer.drawRect(x,y,200,200);
    }

    public void start() {
        while(true) {
            x+= 5;
            y+= 5;
            render();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

    }


}
