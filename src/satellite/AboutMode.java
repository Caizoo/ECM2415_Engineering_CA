package satellite;

import main.NavigationAction;
import main.StateManager;
import menu.MenuState;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class AboutMode implements MenuState {

    private JFrame frame;
    private JPanel screen;
    private JLabel info1, info2, info3, logo;
    private ActionListener listener;
    private Graphics2D renderer;
    private BufferedImage image;


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
        info1 = new JLabel("<html><div style='text-align: left;'>XTrek</div></html>");
        info2 = new JLabel("<html><div style='text-align: right;'>7.01a</div></html>");
        info3 = new JLabel("<html><div style='text-align: center;'>(C) 2018<br/>Dinosoft</div></html>");

        try {
           image = ImageIO.read(new File("src/satellite/dino.png"));
           //logo = new JLabel(new ImageIcon(image));
        } catch (IOException e) {
            e.printStackTrace();
        }

        info1.setPreferredSize(new Dimension((this.screen.getWidth()-10)/2, (this.screen.getHeight()-10)/2));
        info2.setPreferredSize(new Dimension((this.screen.getWidth()-10)/2, (this.screen.getHeight()-10)/2));
        info3.setPreferredSize(new Dimension(this.screen.getWidth()-10, (this.screen.getHeight()-10)/2));
        //logo.setPreferredSize(new Dimension((this.screen.getWidth()-10)/3, 3*this.screen.getHeight()/4));

        info1.setHorizontalAlignment(SwingConstants.LEFT);
        info2.setHorizontalAlignment(SwingConstants.RIGHT);
        info3.setHorizontalAlignment(SwingConstants.CENTER);
        //logo.setHorizontalAlignment(SwingConstants.CENTER);
        //logo.setVerticalAlignment(SwingConstants.CENTER);
        info1.setVerticalAlignment(SwingConstants.CENTER);
        info2.setVerticalAlignment(SwingConstants.CENTER);
        info3.setVerticalAlignment(SwingConstants.BOTTOM);


        //632, 338

        Font f = new Font("Ariel", Font.BOLD, 20);
        info1.setFont(f);
        info2.setFont(f);
        info3.setFont(f);


        this.screen.add(info1);
        this.screen.add(info2);
        //this.screen.add(logo);
        this.screen.add(info3);


        this.screen.setBackground(Color.WHITE);
    }

    @Override
    public void stop() {
        this.screen.setBackground(new Color(27,27,27,255));
        screen.removeAll();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void render() {
        renderer.drawImage( image, 632, 338, image.getWidth(), image.getHeight(), screen );
        info1.repaint();
        info2.repaint();
        info3.repaint();
        //logo.repaint();
    }

    @Override
    public void navigationButton(NavigationAction e) {

    }
}
