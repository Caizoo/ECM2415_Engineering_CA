package menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

/**
 * TODO: implement as a JButton that uses an image to render instead of a clunky button
 */

public class JImageButton extends JComponent implements MouseListener {

    private BufferedImage img;
    private int imgWidth;
    private int imgHeight;

    public JImageButton(BufferedImage img) {
        this.img = img;
        setMinimumSize(new Dimension(img.getWidth(),img.getHeight()));
        setOpaque(false);
        addMouseListener(this);
        this.imgWidth = img.getWidth();
        this.imgHeight = img.getHeight();
    }

    public void setSize(int width, int height) {
        this.imgWidth = width;
        this.imgHeight = height;
        setMinimumSize(new Dimension(width,height));
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img,0,0,imgWidth,imgHeight,null);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Hello");
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
