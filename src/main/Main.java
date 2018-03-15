package main;

import java.awt.event.ActionEvent;
import controller.*;

public class Main {

    public static void main(String[] args) {

        StateManager sm = new StateManager();
        sm.setVisible(true);
        sm.start();

    }


}
