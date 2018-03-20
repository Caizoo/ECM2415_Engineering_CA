/**
 * @author Gabriel Mulcahy
 */

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
import javax.imageio.ImageIO;
import javax.swing.*;


public class MapState extends JPanel implements MenuState {
  private BufferedImage image;
  private BufferedImage dot;
  private BufferedImage error;
  private double rotation;
  private JFrame frame;
  private JPanel screen;
  private ActionListener listener;
  private Graphics2D renderer;
  private Maps map;
  private Rectangle clip;
  private Boolean newInstance = true;



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
    if (newInstance) {
      clip = new Rectangle(UserController.SCREEN_X+8, UserController.SCREEN_Y+32, 191, 241);
      renderer.clip(clip); //only draw the part of the image that fits the screen
      newInstance = false;
    }

    try {
      error = ImageIO.read(new File("res/NoSat.png"));
      dot   = ImageIO.read(new File("res/red.png"));
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
    renderer.drawImage( image, UserController.SCREEN_X-51, UserController.SCREEN_Y-2, screen);
    System.out.println("Update");
    renderer.drawImage( dot, UserController.SCREEN_X+101, UserController.SCREEN_Y+147, 10, 10, screen ); //centre the red dot to the screen
  }

  private void renderError(){
      renderer.drawImage( error, UserController.SCREEN_X+165, UserController.SCREEN_Y+35, 30, 30, screen );
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

  public void update( String latitude, String longitude, String direction, String language ) {
    map.setLat(latitude);
    map.setLong(longitude);
    map.setLanguage(language);
    map.make(); //create a new map image based on current information
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
    if (latitude.equals("")){
        resetDirection();
        renderError();
        //setDirection(Double.parseDouble(direction));
        System.out.println("NO COORDINATES");
    }else{
        render();
    }
  }


  private void setDirection(double angle){
    rotation = -angle; //negative as a turn to the left requires a rotation anti-clockwise
    double radians = Math.toRadians( -angle );
    renderer.rotate( radians, UserController.SCREEN_X+104, UserController.SCREEN_Y+153);
  }

  private void resetDirection(){
    double radians = Math.toRadians(-rotation);
    renderer.rotate( radians, UserController.SCREEN_X+104, UserController.SCREEN_Y+153);
    rotation = 0; //stops more rotations occurring in case this method is called twice before a new direction is given
  }

  private double getDirection(double lat1, double lng1, double lat2, double lng2) {
    double PI = Math.PI;
    double dTeta = Math.log(Math.tan((lat2/2)+(PI/4))/Math.tan((lat1/2)+(PI/4)));
    double dLon = Math.abs(lng1-lng2);
    double teta = Math.atan2(dLon,dTeta);
    double direction = Math.round(Math.toDegrees(teta));
    return direction; //direction in degree

    }
}
