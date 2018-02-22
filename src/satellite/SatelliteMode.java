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

       /*Comment in when all machines work with GPS*/
        /*Location l = new Location();
        l.openPort("COM4");
        String[] data = l.getData();
        System.out.println(data[0]);
        System.out.println(data[1]);
        System.out.println(data[2]);
        data = l.getData();
        System.out.println(data[0]);
        System.out.println(data[1]);
        System.out.println(data[2]);*/


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