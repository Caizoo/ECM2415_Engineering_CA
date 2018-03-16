package main;

import java.awt.event.ActionEvent;
import controller.*;
import model.ModelManager;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        StateManager sm = new StateManager();
        sm.setVisible(true);
        sm.start();
        ModelManager m = new ModelManager(sm);
        sm.setModelManager(m);

        while(true) {
            m.update();
            Thread.sleep(1000);
        }

    }


}
