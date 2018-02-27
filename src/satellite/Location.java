/*
package satellite;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.InputStream;

/**
 * COMMENT IN WHEN ALL MACHINES CAN RUN THE GPS
 * Code modified, with permission, from David Wakeling
 */
/*public class Location implements Runnable {
    //private final String[] data; Changin from array of strings for concurrency
    private String latitude, longitude, time;
    private SerialPort serialPort;
    private final Object lock = new Object();
    //final static String PORT_NAME = "COM4";
    final static int BAUD_RATE = 9600;
    final static int TIMEOUT = 2000;
    final static int BUFF_SIZE = 1024;

    public Location() {
        this.latitude = "";
        this.longitude = "";
        this.time = "0";
    }

    public String[] getData() {
        synchronized (lock) {
            return new String[]{this.latitude, this.longitude, this.time};
        }
    }

    public void openPort(String portName) {
        try {
            CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier(portName);
            if (portId.isCurrentlyOwned()) {
                System.out.println("port in use");
                return;
            }
            CommPort commPort = portId.open("LocationObject", TIMEOUT);

            if (commPort instanceof SerialPort) {
                this.serialPort = (SerialPort) commPort;
                this.serialPort.setSerialPortParams(BAUD_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                this.serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN);
                serialPort.setRTS(true);

            } else {
                System.out.println("not a serial port");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    /*private void updateLocation() throws IOException{
        InputStream in = this.serialPort.getInputStream();
	    byte[] buffer  = new byte[ BUFF_SIZE ];
        String s;
        int    n;
                
        while ((n = in.read( buffer ) ) > -1 ) {
          s = new String( buffer, 0, n );       
          //System.out.print( s );
          if (s.startsWith("GLL", 3)){
              String ss[] = s.split(",");
              //System.out.printf("%s %s\n%s %s\n%s\n", ss[1], ss[2], ss[3], ss[4], ss[5]);
              if (ss[1].equals("")) {
                  this.data[0] = "";
                  this.data[1] = "";
              }else{
                  this.data[0] = (ss[2].equals("N")) ? ss[1] : "-" + ss[1];
                  this.data[1] = (ss[4].equals("E")) ? ss[3] : "-" + ss[3];
              }
              this.data[2] = ss[5];
              break;
          }
        }
        //serialPort.getOutputStream().close();
        //serialPort.close();
    }

   /* @Override*/
    /*public void run() {
        try {
            InputStream in = this.serialPort.getInputStream();
            byte[] buffer = new byte[BUFF_SIZE];
            String s;
            int n;

            while ((n = in.read(buffer)) > -1) {
                s = new String(buffer, 0, n);
                //System.out.print( s );
                if (s.startsWith("GLL", 3)) {
                    String ss[] = s.split(",");
                    //System.out.printf("%s %s\n%s %s\n%s\n", ss[1], ss[2], ss[3], ss[4], ss[5]);
                    synchronized (lock) {
                        if (ss[1].equals("")) {
                            this.latitude = "";
                            this.longitude = "";
                        } else {
                            this.latitude = (ss[2].equals("N")) ? ss[1] : "-" + ss[1];
                            this.longitude = (ss[4].equals("E")) ? ss[3] : "-" + ss[3];
                        }
                        this.time = ss[5];
                        break;
                    }
                }
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/**/