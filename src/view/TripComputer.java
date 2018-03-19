/*
@Author-Rob Wells
 */
package view;

import java.lang.Math;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class TripComputer implements MenuState, Runnable  {
    Graphics2D renderer;
    private JFrame frame;
    private JPanel screen;
    private ActionListener listener;
    MyText[] textLabels = new MyText[3];
    private  double currentLat= 360.00;//impossible value to tell its the inital latitiude
    private  double currentLong= 360.00;//impossible value to tell its the inital longitiude
    private static double currentTime;
    private double totalDistace=0;
    @Override
    public void setRenderer(Graphics2D renderer) {
        this.renderer = renderer;
    }

    @Override
    public void setFrame(JFrame frame) {
        this.frame=frame;
    }

    @Override
    public void setPanel(JPanel panel) {
        this.screen=panel;
    }

    @Override
    public void setListener(ActionListener listener) {
        this.listener=listener;
    }

    @Override
    public void start() {
        textLabels[0]= new MyText("Trip odem", "0.0 KM");
        textLabels[1] = new MyText("Speed", "7 KM/H");
        textLabels[2]= new MyText("Moving time", "27min 8 sec");
        for (MyText x: textLabels){
            x.setPreferredSize(new Dimension(180, 77));
            screen.add(x);
        }
    }

    @Override
    public void stop() {
        screen.removeAll();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void render() {
        for (MyText x: textLabels){
            if(x!=null) x.repaint();
        }
    }
    @Override
    public void navigationButton(NavigationAction e) {
        if (e== NavigationAction.POWER){
            stop();
        }
        else if (e == NavigationAction.MENU){
            stop();}
        else if (e == NavigationAction.SELECT);
    }

    @Override
    public void run(){
        int x=2;
        while(x==2){}
    }
    StyledDocument doc;
    public class MyText extends JTextPane  {
        String infoHeader;
        String infoValue;
        MyText(String header, String value){
            StyledDocument doc = this.getStyledDocument();
            SimpleAttributeSet center = new SimpleAttributeSet();
            StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
            doc.setParagraphAttributes(0, doc.getLength(), center, false);
            this.setFont(new Font("Verdana", Font.BOLD, 20));
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
            this.infoHeader=header;
            this.infoValue=value;
            this.setText(infoHeader+"\n"+infoValue);
        }
        public void resetValues(String newValue){
            setText(infoHeader+"\n"+newValue);
        }
    }


    public Double deg2rad(Double deg) {
        return deg * (Math.PI/180);
    }

    public void setCoords(String latitude, String longitude) {
            currentLat = Double.parseDouble(latitude);
            currentLong = Double.parseDouble(longitude);
    }

    public double getDistanceFromLatLonInKm(Double lat1,Double lon1,Double lat2, Double lon2) {
        int R = 6371; // Radius of the earth in km
        double dLat = deg2rad(lat2-lat1);  // deg2rad below
        double dLon = deg2rad(lon2-lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = R * c; // Distance in km
        return d;
    }


    public void updateTripSpeedAndTime(String speed,String time){
        textLabels[1].resetValues(speed);
        textLabels[2].resetValues(time);
    }

    public void resetTripComputer(String time, String speed,String distance){
        if( distance != null){textLabels[0].resetValues(distance);}
        if(speed != null){textLabels[1].resetValues(speed);}
        if(time != null ){textLabels[2].resetValues(time);}
    }
    public void updateTripDistance(String latitude,String longitude){
        if (latitude.equals("")|| longitude.equals("")){

        }
        else {
            if(currentLat == 360.00 ||currentLong==360.00){
                setCoords(latitude,longitude);
            }
            double distance = getDistanceFromLatLonInKm(currentLat, currentLong, Double.parseDouble(latitude), Double.parseDouble(longitude));
            totalDistace += distance;
            textLabels[0].resetValues(Double.toString(totalDistace));
            setCoords(latitude, longitude);
        }

    }
}