package whereTo;

import main.NavigationAction;
import menu.MenuState;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WhereTo implements MenuState {

    Graphics2D renderer;
    private JFrame frame;
    private JPanel screen;
    private ActionListener listener;
    final TextField txtf = new TextField();
    int currentButton;
    int currentMode;

    CharacterButton[] charButtons = new CharacterButton[28];
    NumberButton[] numButtons = new NumberButton[12];


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

        currentButton=0;
        currentMode=1;


        charButtons[0]= new CharacterButton("A",1);
        charButtons[1]= new CharacterButton("B",2);
        charButtons[2]= new CharacterButton("C",3);
        charButtons[3]= new CharacterButton("D",4);
        charButtons[4]= new CharacterButton("E",5);
        charButtons[5]= new CharacterButton("F",6);
        charButtons[6]= new CharacterButton("G",7);
        charButtons[7]= new CharacterButton("H",8);
        charButtons[8]= new CharacterButton("I",9);
        charButtons[9]= new CharacterButton("J",10);
        charButtons[10]= new CharacterButton("K",11);
        charButtons[11]= new CharacterButton("L",12);
        charButtons[12]= new CharacterButton("M",13);
        charButtons[13]= new CharacterButton("N",14);
        charButtons[14]= new CharacterButton("O",15);
        charButtons[15]= new CharacterButton("P",16);
        charButtons[16]= new CharacterButton("Q",17);
        charButtons[17]= new CharacterButton("R",18);
        charButtons[18]= new CharacterButton("S",19);
        charButtons[19]= new CharacterButton("T",20);
        charButtons[20]= new CharacterButton("U",21);
        charButtons[21]= new CharacterButton("V",22);
        charButtons[22]= new CharacterButton("W",23);
        charButtons[23]= new CharacterButton("X",24);
        charButtons[24]= new CharacterButton("Y",25);
        charButtons[25]= new CharacterButton("X",26);
        charButtons[26]= new CharacterButton("  ",27);
        charButtons[27] = new CharacterButton(28);


        numButtons[0] = new NumberButton(1);
        numButtons[1]= new NumberButton(2);
        numButtons[2] = new NumberButton(3);
        numButtons[3] = new NumberButton(4);
        numButtons[4] = new NumberButton(5);
        numButtons[5] = new NumberButton(6);
        numButtons[6] = new NumberButton(7);
        numButtons[7] = new NumberButton(8);
        numButtons[8]= new NumberButton(9);
        numButtons[9] = new NumberButton(0);
        numButtons[10] = new NumberButton("DEL");
        numButtons[11] = new NumberButton("<=");



        txtf.setPreferredSize(new Dimension(170, 30));
        txtf.setFont(new Font("Ariel", Font.BOLD, 18));
        screen.add(txtf);
        for(CharacterButton x: charButtons){
            if(x.getChar()=="A"){
                x.setPreferredSize(new Dimension(40, 25));
                screen.add(x);
                x.setBackground(Color.ORANGE);
            }
            x.setPreferredSize(new Dimension(40, 25));
            screen.add(x);
        }
        for (NumberButton x: numButtons){
            if(x.getNum()==1){
                x.setPreferredSize(new Dimension(40, 40));
                x.setVisible(false);
                x.setBackground(Color.ORANGE);
                screen.add(x);

            }
            x.setPreferredSize(new Dimension(40, 40));
            x.setVisible(false);
            screen.add(x);
        }
    }

    @Override
    public void stop() {
        System.out.println("STOP");
        for(CharacterButton x: charButtons){
            screen.remove(x);
        }
        for(NumberButton x: numButtons){
            screen.remove(x);
        }
        screen.remove(txtf);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void render() {
        for(CharacterButton x: charButtons){
           if(x!=null) x.repaint();
        }
        for(NumberButton x: numButtons){
            if(x!=null) x.repaint();
        }
    }
    @Override
    public void navigationButton(NavigationAction e) {
        if(e== NavigationAction.SELECT){
            if (currentMode > 0) {
                if (currentButton ==27){
                    charButtons[currentButton].switchToNums();
                }
                else {
                    charButtons[currentButton].textInput();
                }
            }
            else{
                if (currentButton == 10){
                    numButtons[currentButton].backSpace();
                }
                else if(currentButton == 11){
                numButtons[currentButton].switchToChars();
                }
                else {
                numButtons[currentButton].numInput();
                }
            }

         }
        else if(e== NavigationAction.PLUS){
            if (currentMode>0){
                if (this.currentButton==27) {
                    charButtons[currentButton].setBackground(Color.WHITE);
                    this.currentButton=0;
                    charButtons[currentButton].setBackground(Color.ORANGE);
                }
                else {
                    charButtons[currentButton].setBackground(Color.WHITE);
                    this.currentButton++;
                    charButtons[currentButton].setBackground(Color.ORANGE);
                }
            }
            else{
                if (currentButton==12){
                    numButtons[currentButton].setBackground(Color.WHITE);
                    currentButton=0;
                    numButtons[currentButton].setBackground(Color.ORANGE);
                }
                else{
                    numButtons[currentButton].setBackground(Color.WHITE);
                    currentButton++;
                    numButtons[currentButton].setBackground(Color.ORANGE);
                }
            }
        }
        else if (e== NavigationAction.MINUS){
            if (currentMode>0){
                if (this.currentButton==0) {
                    charButtons[currentButton].setBackground(Color.WHITE);
                    this.currentButton=27;
                    charButtons[currentButton].setBackground(Color.ORANGE);
                }
                else {
                    charButtons[currentButton].setBackground(Color.WHITE);
                    this.currentButton--;
                    charButtons[currentButton].setBackground(Color.ORANGE);
                }
                System.out.println(currentButton);
            }
            else{
                if (currentButton==0){
                    numButtons[currentButton].setBackground(Color.WHITE);
                    currentButton=27;
                    numButtons[currentButton].setBackground(Color.ORANGE);
                }
                else{
                    numButtons[currentButton].setBackground(Color.WHITE);
                    currentButton--;
                    numButtons[currentButton].setBackground(Color.ORANGE);
                }
            }
        }
        else if (e== NavigationAction.POWER){
            stop();
        }
        else if (e == NavigationAction.MENU);
        String directions = whereTo();
    }

    public class NumberButton extends JButton{
        public int Num;
        NumberButton(int i){
            this.Num =i;
            String num= Integer.toString(i);
            this.setText(num);
            this.setBackground(Color.WHITE);
            this.setFont(new Font("Ariel", Font.BOLD, 18));
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 6));
        }
        NumberButton(String special){
            this.setText(special);
            this.setBackground(Color.WHITE);
            this.setFont(new Font("Ariel", Font.BOLD, 18));
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 6));
        }
        public void switchToChars(){
            currentMode=-(currentMode);
            for (CharacterButton x : charButtons) {
                x.setVisible(true);
            }
            for (NumberButton x: numButtons){
                x.setVisible(false);
            }
            numButtons[currentButton].setBackground(Color.WHITE);
            currentButton=0;
            numButtons[currentButton].setBackground(Color.ORANGE);
        }
        public int getNum(){
            return this.Num;
        }
        public void numInput(){
            txtf.setText(txtf.getText() +this.getNum());
        }
        public void backSpace(){
            String currentField=txtf.getText();
            currentField = currentField.substring(0, currentField.length()-1);
            txtf.setText(currentField);
        }
    }
    public class CharacterButton extends JButton {
        public int alphaNum;
        public String s;
        CharacterButton(String s, int i) {
            this.alphaNum =i;
            this.s=s;
            this.setBackground(Color.WHITE);
            this.setFont(new Font("Ariel", Font.BOLD, 18));
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
            if (s == " "){
                this.setText("Space");
            }
            else {
                this.setText(s);
            }
        }
        CharacterButton(int i){
            this.setText("=>");
            this.setBackground(Color.WHITE);
            this.setFont(new Font("Ariel", Font.BOLD, 18));
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        }
        public void textInput(){
            txtf.setText(txtf.getText() +this.getChar());
        }
        public String getChar(){
            System.out.println(this.s);
            return this.s;
        }

        public void switchToNums(){
            currentMode=-(currentMode);
            for (CharacterButton x : charButtons) {
                x.setVisible(false);
            }
            for (NumberButton x: numButtons){
                x.setVisible(true);
            }
            charButtons[currentButton].setBackground(Color.WHITE);
            currentButton=0;
            charButtons[currentButton].setBackground(Color.ORANGE);
        }
    }
    public WhereTo(){
    }
    public  String whereTo (){
        String destination = txtf.getText();
        return destination;
    }
    public int increment(){
        currentButton++;
        return currentButton;
    }

}

