package satellite;

import main.NavigationAction;
import menu.MenuState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * From rxtx-2.2pre2-bins.zip, extract RXTXcomm.jar and
 * the win64 version of rxtxSerial.dll.
 *
 * RXTXcomm.jar should be added to the CLASSPATH and 
 * rxtxSerial.dll should be placed in current directory.
 */
public class SatelliteMode implements MenuState{

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

        MockLocation loc = new MockLocation();
        loc.openPort("COM4");
        String[] data;
        Thread t = new Thread(loc);
        t.start();
        for (int i=0; i<72; i++){
            data = loc.getData();
            System.out.printf("LAT: %s\n", data[0]);
            System.out.printf("LONG: %s\n", data[1]);
            System.out.printf("TIME: %s\n", data[2]);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        /*Comment in when all machines work with GPS*/
        /*Location loc = new Location();
        loc.openPort("COM4");
        String[] data;
        Thread t = new Thread(loc);
        t.start();
        for (int i = 0; i < 72; i++) {
            data = loc.getData();
            System.out.printf("LAT: %s\n", data[0]);
            System.out.printf("LONG: %s\n", data[1]);
            System.out.printf("TIME: %s\n", data[2]);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
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