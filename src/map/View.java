package map;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/*
 * View.
 *
 * David Wakeling 2018.
 */
class View extends JPanel implements Observer {
  private BufferedImage image;
  private BufferedImage dot;
  private int rotation;

  public View(Maps map) {
    try {
      image = ImageIO.read( new File( "output.png" ) );
      dot = ImageIO.read( new File( "red.png"));
    } catch ( Exception ex ) {
      System.out.println( ex ); System.exit( 1 );
    }

    //addMouseListener( controller );
    //model.addObserver( this );
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

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    double radians = Math.toRadians( (double) rotation );
    Graphics2D g2d = (Graphics2D) g;
    g2d.clearRect( 0, 0, getWidth(), getHeight() );
    g2d.rotate( radians, image.getWidth() / 2, image.getHeight() / 2 );
    g2d.drawImage( image, 0, 0, this );
    g2d.drawImage( dot, 300, 300, this );
    
  }

  public Dimension getPreferredSize() {
    return new Dimension( image.getWidth(), image.getHeight() );
  }
}
