package map;

import javax.swing.JFrame;

public class ModelViewController {
  public static void main( String[] argv ) {
    Maps map = new Maps();
    map.setLat("50");
    map.setLong("300");
    map.make();
     
    View       view       = new View(map);
   
    JFrame frame = new JFrame();
    frame.add( view );
    frame.pack();
    frame.setVisible( true );
    
    
    
  }
}
