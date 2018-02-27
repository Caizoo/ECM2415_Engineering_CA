package satellite;

public class MockLocation implements Runnable{

    private String latitude, longitude, time;
    private final Object lock = new Object();

    public MockLocation() {
        this.latitude = "";
        this.longitude = "";
        this.time = "0";
    }

    public String[] getData() {
        synchronized (lock) {
            return new String[]{this.latitude, this.longitude, this.time};
        }
    }

    public void openPort(String portName){

    }

    @Override
    public void run(){
        //Simulates a 6 minute journey walking 0.3km
        try {
            double lat = 50.729694; //50.733372
            double lon = -3.549088; //-3.524982
            double time = 120000.00;
            while (lat < 50.750817) {
                synchronized (lock){
                    if (this.latitude.equals("")){
                        this.latitude = String.valueOf(lat);
                        this.longitude = String.valueOf(lon);
                        this.time = String.valueOf(time);
                    }else{
                        lat+=0.000051;
                        lon-=0.000335;
                        time+=5;
                        this.latitude = String.valueOf(lat);
                        this.longitude = String.valueOf(lon);
                        this.time = String.valueOf(time);
                    }
                }
                Thread.sleep(5000);
            }
        }catch (Exception e){
            System.out.println();
        }
    }

}
