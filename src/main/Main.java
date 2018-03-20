/**
 * @author Cai Davies, Scott Woodward
 */

package main;

import controller.*;
import model.ModelManager;

import java.awt.event.WindowEvent;

public class Main {

    public static boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        UserController uc = new UserController();
        uc.setVisible(true);
        uc.start();
        ModelManager m = new ModelManager(uc);
        uc.setModelManager(m);

        while(running) {
            m.update();
            Thread.sleep(1000);
        }

        // resource cleanup if necessary

        uc.dispose();
        System.exit(0);

    }


}
