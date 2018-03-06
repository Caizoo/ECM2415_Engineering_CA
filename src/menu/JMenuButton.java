package menu;

import main.MenuAction;

import javax.swing.*;
import java.awt.*;

public class JMenuButton extends JButton {

    MenuAction menuAction;

    public JMenuButton(String text, MenuAction action) {
        super(text);
        this.menuAction = action;
    }

    public MenuAction getMenuAction() {
        return menuAction;
    }
}
