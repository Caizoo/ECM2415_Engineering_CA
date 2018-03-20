package view;

import controller.UserController;
import controller.MockLocation;

import model.Maps;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * MapState.
 *
 * @author Gabriel Mulcahy
 */
public class MapState extends JPanel implements MenuState {
  private BufferedImage image;
  private BufferedImage dot;
  private double rotation;
  private JFrame frame;
  private JPanel screen;
  private ActionListener listener;
  private Graphics2D renderer;
  private Maps map;
  private Rectangle clip;


  @Override
  public void setRenderer(Graphics2D renderer){
    this.renderer = renderer;
  }

  @Override
  public void setFrame(JFrame frame){
    this.frame = frame;
  }

  @Override
  public void setPanel(JPanel panel){
    this.screen = panel;
  }

  @Override
  public void setListener(ActionListener listener){
    this.listener = listener;
  }

  @Override
  public void start(){
    map = new Maps();
    clip = new Rectangle(UserController.SCREEN_X+8, UserController.SCREEN_Y+32, 191, 241); //only draw the part of the image that fits the screen
    renderer.clip(clip);
    try {
      dot = ImageIO.read(new File("res/red.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void stop(){
    screen.removeAll();
  }

  @Override
  public void actionPerformed(ActionEvent e){

  }

  @Override
  public void render(){
    if(image==null) return;
    renderer.drawImage( image, UserController.SCREEN_X-51, UserController.SCREEN_Y-2,/*screen.getWidth()-4,screen.getHeight()-4,*/screen);
    System.out.println("Update");
    renderer.drawImage( dot, UserController.SCREEN_X+101, UserController.SCREEN_Y+147, 10, 10, screen ); //centre the red dot to the screen
  }

  @Override
  public void navigationButton(NavigationAction e){
    if(e== NavigationAction.PLUS){
      map.zoomIn();
      map.make();
        try {
            image = ImageIO.read(new File("res/output.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        render();
    } else if(e== NavigationAction.MINUS) {
      map.zoomOut();
      map.make();
      try {
          image = ImageIO.read(new File("res/output.png"));
      } catch (IOException e1) {
          e1.printStackTrace();
      }
      render();
    }
  }


  public MapState() {

  }

  public void update( String latitude, String longitude, String direction ) {
    map.setLat(latitude);
    map.setLong(longitude);
    map.make();
    //Needed to change image each time -Scott
    try {
      image = ImageIO.read(new File("res/output.png"));
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    if (!direction.equals("")) {
        resetDirection();
        setDirection(Double.parseDouble(direction));
        System.out.println("NEW DIRECTION!!!");
      }else{
        System.out.println("No new direction");
    }
    render();
  }
  
  private void setDirection(double angle){
    rotation = angle;
    double radians = Math.toRadians( angle );
    renderer.rotate( radians, UserController.SCREEN_X+104, UserController.SCREEN_Y+153);
  }

  private void resetDirection(){
    double radians = Math.toRadians(-rotation);
    renderer.rotate( radians, UserController.SCREEN_X+104, UserController.SCREEN_Y+153);
  }
}
