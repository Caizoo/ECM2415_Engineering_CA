package main;

import menu.MainMenuState;
import menu.MenuState;
import menu.OnOffState;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static main.NavigationAction.MINUS;
import static main.NavigationAction.POWER;

public class StateManager extends JFrame implements ActionListener, MouseListener {

    private MenuState states[] = new MenuState[6];
    private Graphics2D g2d = null;
    private JPanel screen = null;

    private static BufferedImage gpsImage = null;
    private JButton power = null;

    private static final int ON_OFF_STATE = 0;
    private static final int MAIN_STATE = 1;
    private static final int WHERE_TO_STATE = 2;
    private static final int TRIP_COMPUTER_STATE = 3;
    private static final int MAP_STATE = 4;
    private static final int SPEECH_STATE = 5;
    private static final int SATELLITE_STATE = 6;
    private static final int ABOUT_STATE = 7;

    private static int state = 0;

    public static final int GPS_WIDTH = 650;
    public static final int GPS_HEIGHT = 650;
    public static final int GPS_X = 340;
    public static final int GPS_Y = 60;
    public static final int SCREEN_WIDTH = 191;
    public static final int SCREEN_HEIGHT = 241;
    public static final int SCREEN_X = 561;
    public static final int SCREEN_Y = 278;

    public final Rectangle boundsPlusButton = new Rectangle(512,154,6,40);
    public final Rectangle boundsMinusButton = new Rectangle(508,206,6,40);

    public final Rectangle boundsSelectButton = new Rectangle(508,279,8,50);
    public final Rectangle boundsMenuButton = new Rectangle(810,158,14,52);

    public StateManager() {
        setTitle("GPS");
        setSize(1280,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
    }

    public void start() {
        this.g2d = (Graphics2D)(super.getGraphics());
        this.addMouseListener(this);

        screen = new JPanel();
        screen.setOpaque(false);
        screen.setBackground(new Color(27,27,27,255));
        screen.setBounds(SCREEN_X,SCREEN_Y,SCREEN_WIDTH,SCREEN_HEIGHT);

        power = new JButton("Power");
        power.addActionListener(this);
        power.setSize(80,40);
        power.setLocation(690,195);
        this.add(power);

        /**TODO:  change layout of screen to null when using absolute locations for buttons**/
        //screen.setLayout(null);

        getContentPane().add(screen);

        try {
            gpsImage = ImageIO.read(new File("res/gpsDevice.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        states[0] = new OnOffState();
        states[1] = new MainMenuState();

        for(MenuState state:states) {
            if(state!=null) {
                state.setRenderer(g2d);
                state.setFrame(this);
                state.setListener(this);
                state.setPanel(screen);
            }
        }

        states[state].start();
        screen.revalidate();
        super.repaint();
    }

    public void doAction(NavigationAction action) {
        switch(action) {
            case POWER:
                if(state==ON_OFF_STATE) {
                    states[state].stop();
                    state = MAIN_STATE;
                    states[state].start();
                }else if(state==MAIN_STATE) {
                    states[state].stop();
                    state = ON_OFF_STATE;
                    states[state].start();
                }
            case MENU:
                states[state].navigationButton(NavigationAction.MENU);
            case SELECT:
                states[state].navigationButton(NavigationAction.SELECT);
            case PLUS:
                states[state].navigationButton(NavigationAction.PLUS);
            case MINUS:
                states[state].navigationButton(NavigationAction.MINUS);
        }

        paintScreen();
    }

    /** paints everything including the device, need only render when opening the program **/
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.clearRect(0,0,1280,720);
        g2d.drawImage(gpsImage,GPS_X,GPS_Y,GPS_WIDTH,GPS_HEIGHT,this);
        if(states[state]!=null) states[state].render();
        if(power!=null) power.repaint();
    }

    /** paints the screen and the power button **/

    public void paintScreen() {
        super.repaint();
        screen.revalidate();
        if(states[state]!=null) states[state].render();
        power.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(power)) {
            doAction(NavigationAction.POWER);
        }else{
            states[state].actionPerformed(e);
            screen.revalidate();
        }

        paintScreen();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point mousePoint = e.getPoint();
        System.out.println(mousePoint);
        if(intersects(mousePoint,boundsSelectButton)) {
            doAction(NavigationAction.SELECT);
        }
        if(intersects(mousePoint,boundsPlusButton)) {
            doAction(NavigationAction.PLUS);
        }
        if(intersects(mousePoint,boundsMinusButton)) {
            doAction(MINUS);
        }
        if(intersects(mousePoint,boundsMenuButton)) {
            if(state!=ON_OFF_STATE) doAction(NavigationAction.MENU);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean intersects(Point point, Rectangle rectangle) {
        if(point.x>=rectangle.x && point.x<=rectangle.x+rectangle.width) {
            if(point.y>=rectangle.y && point.y<=rectangle.y+rectangle.height) return true;
        }
        return false;
    }
}
