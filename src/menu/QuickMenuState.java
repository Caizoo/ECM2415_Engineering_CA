package menu;

import menu.MenuState;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QuickMenuState implements MenuState {

    JFrame frame;
    Graphics2D renderer;

    int x = 200;
    int y = 200;

    public QuickMenuState() {

    }

    public void setRenderer(Graphics2D renderer) {
        this.renderer = renderer;
    }
    public void setFrame(JFrame frame) { this.frame = frame; }

    public void render() {
        renderer.setColor(Color.BLACK);
        renderer.clearRect(0,0,1280,720);
        renderer.drawRect(x,y,200,200);
        try {
            BufferedImage image = ImageIO.read(new File("res/gpsDeviceMock.png"));
            renderer.drawImage(image,340,100,600,600,frame);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {

    }

    public void actionPerformed(ActionEvent e) {

    }


}
