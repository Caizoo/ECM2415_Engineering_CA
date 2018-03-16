package main;

import controller.*;
import model.ModelManager;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        UserController uc = new UserController();
        uc.setVisible(true);
        uc.start();
        ModelManager m = new ModelManager(uc);
        uc.setModelManager(m);

        while(true) {
            m.update();
            Thread.sleep(1000);
        }

    }


}
