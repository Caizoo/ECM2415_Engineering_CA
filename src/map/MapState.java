package map;

import main.NavigationAction;
import menu.MenuState;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.*;

/*
 * MapState.
 *
 * David Wakeling 2018.
 */
public class MapState extends JPanel implements Observer, MenuState{
  private BufferedImage image;
  private BufferedImage dot;
  private int rotation;
  private JFrame frame;
  private JPanel screen;
  private ActionListener listener;
  private Graphics2D renderer;
  private Maps map;

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
    try {
      map = new Maps();
      map.make();
      image = ImageIO.read( new File( "src/map/output.png" ) );
      dot = ImageIO.read( new File( "src/map/red.png"));
    } catch ( Exception ex ) {
      System.out.println( ex ); System.exit( 1 );
    }
  }

  @Override
  public void stop(){

  }

  @Override
  public void actionPerformed(ActionEvent e){

  }

  @Override
  public void render(){
    double radians = Math.toRadians( (double) rotation );
    renderer.clearRect( 0, 0, screen.getWidth(), screen.getHeight() );
    renderer.rotate( radians, image.getWidth() / 2, image.getHeight() / 2 );
    renderer.drawImage( image, 0, 0, this );
    renderer.drawImage( dot, 300, 300, this );

  }

  @Override
  public void navigationButton(NavigationAction e){
    if(e== NavigationAction.PLUS){
      map.zoomIn();
      map.make();
      render();
    } else if(e== NavigationAction.MINUS) {
      map.zoomOut();
      map.make();
      render();
    }
  }


  public MapState() {
    try {
      image = ImageIO.read( new File( "output.png" ) );
      dot = ImageIO.read( new File( "red.png"));
      map = new Maps();
    } catch ( Exception ex ) {
      System.out.println( ex ); System.exit( 1 );
    }
  }

  public void update( Observable obs, Object obj ) {
    rotation = (int) obj;
    repaint();
  }
  
  public void setRotation(int rotation){
    this.rotation = rotation;
  }
  
  
  public void north(){
    rotation = 0;
  }
  
  public void west(){
    rotation = 90;
  }
  
  public void south(){
    rotation = 180;
  }
  
  public void east(){
    rotation = 270;
  }

  /*public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    double radians = Math.toRadians( (double) rotation );
    Graphics2D g2d = (Graphics2D) g;
    g2d.clearRect( 0, 0, getWidth(), getHeight() );
    g2d.rotate( radians, image.getWidth() / 2, image.getHeight() / 2 );
    g2d.drawImage( image, 0, 0, this );
    g2d.drawImage( dot, 300, 300, this );
    
  }*/

  public Dimension getPreferredSize() {
    return new Dimension( image.getWidth(), image.getHeight() );
  }
}
