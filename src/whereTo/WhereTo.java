package whereTo;

import main.NavigationAction;
import menu.MenuState;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.reflect.*;
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


        charButtons[0]= new CharacterButton(" a",1);
        charButtons[1]= new CharacterButton(" b",2);
        charButtons[2]= new CharacterButton("c",3);
        charButtons[3]= new CharacterButton(" d",4);
        charButtons[4]= new CharacterButton("e",5);
        charButtons[5]= new CharacterButton(" f",6);
        charButtons[6]= new CharacterButton(" g",7);
        charButtons[7]= new CharacterButton(" h",8);
        charButtons[8]= new CharacterButton(" i",9);
        charButtons[9]= new CharacterButton(" j",10);
        charButtons[10]= new CharacterButton(" k",11);
        charButtons[11]= new CharacterButton(" l",12);
        charButtons[12]= new CharacterButton(" m",13);
        charButtons[13]= new CharacterButton(" n",14);
        charButtons[14]= new CharacterButton(" o",15);
        charButtons[15]= new CharacterButton(" p",16);
        charButtons[16]= new CharacterButton(" q",17);
        charButtons[17]= new CharacterButton(" r",18);
        charButtons[18]= new CharacterButton(" s",19);
        charButtons[19]= new CharacterButton(" t",20);
        charButtons[20]= new CharacterButton(" u",21);
        charButtons[21]= new CharacterButton(" v",22);
        charButtons[22]= new CharacterButton(" w",23);
        charButtons[23] = new CharacterButton("x",24);
        charButtons[24] = new CharacterButton("y",25);
        charButtons[25]= new CharacterButton(" z",26);
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



        txtf.setBounds(150,360,300,30); screen.add(txtf);
        charButtons[0].setBounds(150,400,75,45); screen.add(charButtons[0]);charButtons[0].setBackground(Color.ORANGE);
        charButtons[1].setBounds(225,400,75,45); screen.add(charButtons[1]);
        charButtons[2].setBounds(300,400,75,45); screen.add(charButtons[2]);
        charButtons[3].setBounds(375,400,75,45); screen.add(charButtons[3]);
        charButtons[4].setBounds(150,445,75,45); screen.add(charButtons[4]);
        charButtons[5].setBounds(225,445,75,45); screen.add(charButtons[5]);
        charButtons[6].setBounds(300,445,75,45); screen.add(charButtons[6]);
        charButtons[7].setBounds(375,445,75,45); screen.add(charButtons[7]);
        charButtons[8].setBounds(150,490,75,45); screen.add(charButtons[8]);
        charButtons[9].setBounds(225,490,75,45); screen.add(charButtons[9]);
        charButtons[10].setBounds(300,490,75,45); screen.add(charButtons[10]);
        charButtons[11].setBounds(375,490,75,45); screen.add(charButtons[11]);
        charButtons[12].setBounds(150,535,75,45); screen.add(charButtons[12]);
        charButtons[13].setBounds(225,535,75,45); screen.add(charButtons[13]);
        charButtons[14].setBounds(300,535,75,45); screen.add(charButtons[14]);
        charButtons[15].setBounds(375,535,75,45); screen.add(charButtons[15]);
        charButtons[16].setBounds(150,580,75,45); screen.add(charButtons[16]);
        charButtons[17].setBounds(225,580,75,45); screen.add(charButtons[17]);
        charButtons[18].setBounds(300,580,75,45); screen.add(charButtons[18]);
        charButtons[19].setBounds(375,580,75,45); screen.add(charButtons[19]);
        charButtons[20].setBounds(150,625,75,45); screen.add(charButtons[20]);
        charButtons[21].setBounds(225,625,75,45); screen.add(charButtons[21]);
        charButtons[22].setBounds(300,625,75,45); screen.add(charButtons[22]);
        charButtons[23].setBounds(375,625,75,45); screen.add(charButtons[23]);
        charButtons[24].setBounds(150,670,75,45); screen.add(charButtons[24]);
        charButtons[25].setBounds(225,670,75,45); screen.add(charButtons[25]);
        charButtons[26].setBounds(300,670,75,45);screen.add(charButtons[26]);
        charButtons[27].setBounds(375,670,75,45); screen.add(charButtons[27]);

        numButtons[0].setBounds(150,400,75,45); screen.add(numButtons[0]);numButtons[0].setBackground(Color.ORANGE);numButtons[0].setVisible(false);
        numButtons[1].setBounds(225,400,75,45); screen.add(numButtons[1]);numButtons[1].setVisible(false);
        numButtons[2].setBounds(300,400,75,45); screen.add(numButtons[2]);numButtons[2].setVisible(false);
        numButtons[3].setBounds(375,400,75,45); screen.add(numButtons[3]);numButtons[3].setVisible(false);
        numButtons[4].setBounds(150,445,75,45); screen.add(numButtons[4]);numButtons[4].setVisible(false);
        numButtons[5].setBounds(225,445,75,45); screen.add(numButtons[5]);numButtons[5].setVisible(false);
        numButtons[6].setBounds(300,445,75,45); screen.add(numButtons[6]);numButtons[6].setVisible(false);
        numButtons[7].setBounds(375,445,75,45); screen.add(numButtons[7]);numButtons[7].setVisible(false);
        numButtons[8].setBounds(150,490,75,45); screen.add(numButtons[8]);numButtons[8].setVisible(false);
        numButtons[9].setBounds(225,490,75,45); screen.add(numButtons[9]);numButtons[9].setVisible(false);
        numButtons[10].setBounds(300,490,75,45); screen.add(numButtons[10]); numButtons[10].setVisible(false);
        charButtons[27].setBounds(375,670,75,45); screen.add(charButtons[27]);charButtons[27].setVisible(false);
        numButtons[11].setBounds(375,670,75,45); screen.add(numButtons[11]);

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
                if (currentButton == 11){
                    numButtons[currentButton].backSpace();
                }
                else if(currentButton == 12){
                numButtons[currentButton].switchToChars();
                }
                else {
                numButtons[currentButton].numInput();
                }
            }

         }
        else if(e== NavigationAction.PLUS){

            if (currentMode>0){

                if (this.currentButton<27) {
                    charButtons[currentButton].setBackground(Color.WHITE);
                    this.currentButton++;
                    charButtons[currentButton].setBackground(Color.ORANGE);


                }
            }
            else{
                if (currentButton<12){
                    numButtons[currentButton].setBackground(Color.WHITE);
                    currentButton++;
                    numButtons[currentButton].setBackground(Color.ORANGE);
                }
            }
        }
        else if (e== NavigationAction.MINUS){
            if (currentButton >=1) {
                if(currentMode>0) {
                    charButtons[currentButton].setBackground(Color.WHITE);
                    currentButton--;
                    charButtons[currentButton].setBackground(Color.ORANGE);
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
        }
        NumberButton(String special){
            this.setText(special);
            this.setBackground(Color.WHITE);
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

