/**
 * @author Scott Woodward
 */

package controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MockLocation implements Runnable{

    private String latitude, longitude, time, velocity, direction;
    private final Object lock = new Object();

    public MockLocation() {
        this.latitude = "";
        this.longitude = "";
        this.time = "0";
        this.velocity = "";
        this.direction = "";
    }

    public String[] getData() {
        synchronized (lock) {
            return new String[]{this.latitude, this.longitude, this.direction, this.velocity, this.time};
        }
    }

    public void openPort(String portName){

    }

    @Override
    public void run(){
        //Simulates a 6 minute journey walking 0.3km
        //NOTE: Data might not be currently be fully realistic, the purpose is to only simulate real data in a way that will replicate the full location object
        /*try {
            //Thread.sleep(1000); //Will add in in further sprint to simulate waiting to connect
            double lat = 50.729694; //50.733372
            double lon = -3.549088; //-3.524982
            double time = 120000.00;
            int i = 0;
            while (lat < 50.750817) {
                synchronized (lock) {
                    //Simulates temporary loss of signal
                    if (i % 27 == 0){
                        this.latitude = "";
                        this.longitude = "";
                    }else {
                        this.latitude = String.format("%.4f", lat);
                        this.longitude = String.format("%.4f", lon);
                    }
                    this.time = String.valueOf(time);
                    lat += 0.000051;
                    lon -= 0.000335;
                    time += 5;
                    i++;
                }
                Thread.sleep(5000);
            }
        }catch (Exception e){
            System.out.println();
        }*/
        String lat="";
        String lon="";
        try{
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("res/MockLocationData.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = br.readLine();
            //Read File Line By Line
            while (strLine != null)   {
                // Print the content on the console
                while(!strLine.startsWith("$GPVTG")){
                    strLine = br.readLine();
                }
                String s[] = strLine.split(",");
                String direction = s[1];
                String speed = s[7];
                strLine = br.readLine();

                while(!strLine.startsWith("$GPGLL")){
                    strLine = br.readLine();
                }
                String ss[] = strLine.split(",");
                if (ss[1].equals("")||ss[3].equals("")){
                    lat="";
                    lon="";
                }else {
                    lat = String.format("%.6f", Integer.valueOf(ss[1].substring(0, 2)) + Float.valueOf(ss[1].substring(2)) / 60);
                    lon = String.format("%.6f", Integer.valueOf(ss[3].substring(0, 3)) + Float.valueOf(ss[3].substring(3)) / 60);
                    if (ss[2].equals("S")) lat = "-" + lat;
                    if (ss[4].equals("W")) lon = "-" + lon;
                }
                String time = String.format("%f", Integer.valueOf(ss[5].substring(0,2))*3600 + Integer.valueOf(ss[5].substring(2,4))*60 + Float.valueOf(ss[5].substring(4)));
                //if (strLine.startsWith("$GPGLL")||strLine.startsWith("$GPVTG")) System.out.println (strLine);
                synchronized (lock){
                    this.velocity = speed;
                    this.direction = direction;
                    this.latitude = lat;
                    this.longitude = lon;
                    this.time = time;
                }
                Thread.sleep(1000);
            }
            //Close the input stream
            in.close();
        }catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}


