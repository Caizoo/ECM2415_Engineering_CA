package whereTo;

import main.NavigationAction;
import menu.MenuState;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.reflect.*;
public class whereTo implements MenuState {

    Graphics2D renderer;
    private JFrame frame;
    private JPanel screen;
    private ActionListener listener;
    final TextField txtf = new TextField();
    public int currentButton=0;
    public int currentMode=1;

    CharacterButton[] charButtons= new CharacterButton[28];
    NumberButton[] numButtons = new NumberButton[13];


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
        CharacterButton btnHideNum = new CharacterButton(28);
        CharacterButton btna = new CharacterButton("a",1);
        CharacterButton btnb = new CharacterButton("b",2);
        CharacterButton btnc = new CharacterButton("c",3);
        CharacterButton btnd = new CharacterButton("d",4);
        CharacterButton btne = new CharacterButton("e",5);
        CharacterButton btnf = new CharacterButton("f",6);
        CharacterButton btng = new CharacterButton("g",7);
        CharacterButton btnh = new CharacterButton("h",8);
        CharacterButton btni = new CharacterButton("i",9);
        CharacterButton btnj = new CharacterButton("j",10);
        CharacterButton btnk = new CharacterButton("k",11);
        CharacterButton btnl = new CharacterButton("l",12);
        CharacterButton btnm = new CharacterButton("m",13);
        CharacterButton btnn = new CharacterButton("n",14);
        CharacterButton btno = new CharacterButton("o",15);
        CharacterButton btnp = new CharacterButton("p",16);
        CharacterButton btnq = new CharacterButton("q",17);
        CharacterButton btnr = new CharacterButton("r",18);
        CharacterButton btns = new CharacterButton("s",19);
        CharacterButton btnt = new CharacterButton("t",20);
        CharacterButton btnu = new CharacterButton("u",21);
        CharacterButton btnv = new CharacterButton("v",22);
        CharacterButton btnw = new CharacterButton("w",23);
        CharacterButton btnx = new CharacterButton("x",24);
        CharacterButton btny = new CharacterButton("y",25);
        CharacterButton btnz = new CharacterButton("z",26);
        CharacterButton btnSpace = new CharacterButton(" ",27);
        CharacterButton[] charButtons={btna,btnb,btnc,btnd,btne,btnf,btng,btnh,btni,btnj,btnk
                ,btnl,btnm,btnn,btno,btnp,btnq,btnr,btns,btnt,btnu,btnv,btnw,btnx,btny,btnz,btnSpace,btnHideNum};
        NumberButton btn1 = new NumberButton(1);
        NumberButton btn2 = new NumberButton(2);
        NumberButton btn3 = new NumberButton(3);
        NumberButton btn4 = new NumberButton(4);
        NumberButton btn5 = new NumberButton(5);
        NumberButton btn6 = new NumberButton(6);
        NumberButton btn7 = new NumberButton(7);
        NumberButton btn8 = new NumberButton(8);
        NumberButton btn9 = new NumberButton(9);
        NumberButton btn0 = new NumberButton(0);
        NumberButton btnDel = new NumberButton("DEL");
        NumberButton btnHideChar = new NumberButton("<=");
        NumberButton[] numButtons={btn1,btn2,btn3,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDel,btnHideChar};

        txtf.setBounds(150,360,300,30); screen.add(txtf);
        btna.setBounds(150,400,75,45); screen.add(btna);btna.setBackground(Color.ORANGE);
        btnb.setBounds(225,400,75,45); screen.add(btnb);
        btnc.setBounds(300,400,75,45); screen.add(btnc);
        btnd.setBounds(375,400,75,45); screen.add(btnd);
        btne.setBounds(150,445,75,45); screen.add(btne);
        btnf.setBounds(225,445,75,45); screen.add(btnf);
        btng.setBounds(300,445,75,45); screen.add(btng);
        btnh.setBounds(375,445,75,45); screen.add(btnh);
        btni.setBounds(150,490,75,45); screen.add(btni);
        btnj.setBounds(225,490,75,45); screen.add(btnj);
        btnk.setBounds(300,490,75,45); screen.add(btnk);
        btnl.setBounds(375,490,75,45); screen.add(btnl);
        btnm.setBounds(150,535,75,45); screen.add(btnm);
        btnn.setBounds(225,535,75,45); screen.add(btnn);
        btno.setBounds(300,535,75,45); screen.add(btno);
        btnp.setBounds(375,535,75,45); screen.add(btnp);
        btnq.setBounds(150,580,75,45); screen.add(btnq);
        btnr.setBounds(225,580,75,45); screen.add(btnr);
        btns.setBounds(300,580,75,45); screen.add(btns);
        btnt.setBounds(375,580,75,45); screen.add(btnt);
        btnu.setBounds(150,625,75,45); screen.add(btnu);
        btnv.setBounds(225,625,75,45); screen.add(btnv);
        btnw.setBounds(300,625,75,45); screen.add(btnw);
        btnx.setBounds(375,625,75,45); screen.add(btnx);
        btny.setBounds(150,670,75,45); screen.add(btny);
        btnz.setBounds(225,670,75,45); screen.add(btnz);
        btnSpace.setBounds(300,670,75,45);screen.add(btnSpace);
        btn1.setBounds(150,400,75,45); screen.add(btn1);btn1.setBackground(Color.ORANGE);btn1.setVisible(false);
        btn2.setBounds(225,400,75,45); screen.add(btn2);btn2.setVisible(false);
        btn3.setBounds(300,400,75,45); screen.add(btn3);btn3.setVisible(false);
        btn4.setBounds(375,400,75,45); screen.add(btn4);btn4.setVisible(false);
        btn5.setBounds(150,445,75,45); screen.add(btn5);btn5.setVisible(false);
        btn6.setBounds(225,445,75,45); screen.add(btn6);btn6.setVisible(false);
        btn7.setBounds(300,445,75,45); screen.add(btn7);btn7.setVisible(false);
        btn8.setBounds(375,445,75,45); screen.add(btn8);btn8.setVisible(false);
        btn9.setBounds(150,490,75,45); screen.add(btn9);btn9.setVisible(false);
        btn0.setBounds(225,490,75,45); screen.add(btn0);btn0.setVisible(false);
        btnDel.setBounds(300,490,75,45); screen.add(btnDel); btnDel.setVisible(false);
        btnHideChar.setBounds(375,670,75,45); screen.add(btnHideChar);btnHideChar.setVisible(false);
        btnHideNum.setBounds(375,670,75,45); screen.add(btnHideNum);

    }

    @Override
    public void stop() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void render() {

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
                if (currentButton<27) {
                    charButtons[currentButton].setBackground(Color.WHITE);
                    currentButton++;
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
            if (currentButton >= 1) {
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
            boolean powerOn=true;
            if (powerOn) {
                for (CharacterButton x : charButtons) {
                    x.setVisible(false);
                }
                for (NumberButton x : numButtons) {
                    x.setVisible(false);
                }
                txtf.setVisible(false);
                powerOn = false;
            }
            else {
                for (CharacterButton x : charButtons) {
                    x.setVisible(true);
                }
                for (NumberButton x : numButtons) {
                    x.setVisible(true);
                }
                txtf.setText("");
                txtf.setVisible(true);
                powerOn=true;
            }
            currentButton=0;
        }
        else if (e == NavigationAction.MENU);
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
    public class IncrementUpButton extends JButton{
        IncrementUpButton (){
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (currentMode>0){
                        if (currentButton<27) {
                            charButtons[currentButton].setBackground(Color.WHITE);
                            currentButton++;
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
            });
        }
    }
    public class IncrementDownButton extends JButton{
        IncrementDownButton () {
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (currentButton >= 1) {
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
            });
        }
    }
    public class SelectButton extends JButton{
        SelectButton () {
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
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
            });
        }
    }
    public class PowerButton extends JButton{
        boolean powerOn = true;

        PowerButton(){
            this.setVisible(true);
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (powerOn) {
                        for (CharacterButton x : charButtons) {
                            x.setVisible(false);
                        }
                        for (NumberButton x : numButtons) {
                            x.setVisible(false);
                        }
                        txtf.setVisible(false);
                        powerOn = false;
                    }
                    else {
                        for (CharacterButton x : charButtons) {
                            x.setVisible(true);
                        }
                        for (NumberButton x : numButtons) {
                            x.setVisible(true);
                        }
                        txtf.setText("");
                        txtf.setVisible(true);
                        powerOn=true;
                    }
                    currentButton=0;
                }
            });
        }
    }
    public class HideButtons extends JButton{
        HideButtons () {
            this.setText("=>");
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    currentMode=-(currentMode);
                    if(currentMode<0) {
                        for (CharacterButton x : charButtons) {
                            x.setVisible(false);

                        }
                        for (NumberButton x: numButtons){
                            x.setVisible(true);
                        }
                        currentButton=0;
                    }
                    else{
                        for (CharacterButton x : charButtons) {
                            x.setVisible(true);
                        }
                        for (NumberButton x: numButtons){
                            x.setVisible(false);
                        }
                        currentButton=0;
                    }
                }
            });
        }
    }
    public whereTo(){



    }
    public  String whereTo (){
        String destination = txtf.getText();
        return destination;
    }

}

