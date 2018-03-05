package speech;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import main.NavigationAction;
import menu.MenuState;

/*
 * Code by Joshua Chalcraft
 */



public class SpeechMode extends JFrame implements MenuState
{
    //Attributes
    private JFrame frame;
    private JPanel screen;
    private ActionListener listener;
    private Graphics2D renderer;
    ArrayList<LanguageButton> buttons = new ArrayList<>();
    private int buttonIndex = -1;

    //Constructor
    public SpeechMode()
    {

    }


    //Methods
    @Override
    public void setRenderer(Graphics2D renderer) {this.renderer = renderer;}

    @Override
    public void setFrame (JFrame frame) {this.frame = frame;}

    @Override
    public void setPanel(JPanel screen) {this.screen = screen;}

    @Override
    public void setListener(ActionListener listener){this.listener = listener;}

    @Override
    public void start()
    {
        buttons.add(new LanguageButton("Off", null, null, null));
        buttons.add(new LanguageButton("English", "en-US", "Apollo", "(en-GB, Susan, Apollo)"));
        buttons.add(new LanguageButton("French", "fr-FR", "Apollo", "(fr-FR, Julie, Apollo)"));
        buttons.add(new LanguageButton("German", "de-DE", "Hedda", "(de-DE, Hedda)"));
        buttons.add(new LanguageButton("Italian", "it-IT", "Apollo", "(it-IT, Cosimo, Apollo)"));
        buttons.add(new LanguageButton("Spanish", "es-ES", "Apollo", "(es-ES, Laura, Apollo)"));

        for (LanguageButton langButton : buttons)
        {
            langButton.setPreferredSize(new Dimension(191, 35));
            langButton.addActionListener(listener);
            screen.add(langButton);
        }

    }

    @Override
    public void stop()
    {
        for(LanguageButton langButton:buttons) screen.remove(langButton);
    }

    /** for when a button is pressed, use e.getSource() to return the button object **/
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(buttons.get(0)))
        {
            System.out.println("Off button clicked");
        }
    }


    /** render only buttons and images, don't redraw panel or frame **/
    @Override
    public void render()
    {
        for (LanguageButton langButton : buttons) langButton.repaint();
    }


    /** for when a navigation button has been pressed **/
    @Override
    public void navigationButton(NavigationAction e)
    {
        if ((e == NavigationAction.PLUS) && (buttonIndex > 0)) //Go upwards
        {
            buttonIndex--;
            buttons.get(buttonIndex+1).setBackground(Color.WHITE);
            buttons.get(buttonIndex).setBackground(Color.ORANGE);
        }

        if ((e == NavigationAction.MINUS) && (buttonIndex < (buttons.size()-1))) //Go downwards
        {
            buttonIndex++;
            if (buttonIndex == 0)
            {
                buttons.get(buttonIndex).setBackground(Color.ORANGE);
            }
            else
            {
                buttons.get(buttonIndex - 1).setBackground(Color.WHITE);
                buttons.get(buttonIndex).setBackground(Color.ORANGE);
            }
        }

        if (e == NavigationAction.SELECT)
        {
            SpeechGenerator.setLanguage(buttons.get(buttonIndex).languageCode);
            SpeechGenerator.setGender(buttons.get(buttonIndex).languageGender);
            SpeechGenerator.setArtist(buttons.get(buttonIndex).languageArtist);
            System.out.println("Language is now set to: " + SpeechGenerator.getLanguage());
            System.out.println("Gender is now set to: " + SpeechGenerator.getGender());
            System.out.println("Artist is now set to: " + SpeechGenerator.getArtist());
        }
    }

//A Commit test from Intellij

    public class LanguageButton extends JButton
    {
        public String languageType;
        public String languageCode;
        public String languageGender;
        public String languageArtist;
        LanguageButton(String languageType, String languageCode, String languageGender, String languageArtist)
        {
            this.languageType = languageType;
            this.languageCode = languageCode;
            this.languageGender = languageGender;
            this.languageArtist = languageArtist;
            this.setText(languageType);
            this.setFont(new Font("Ariel", Font.BOLD, 24));
            this.setBackground(Color.WHITE);

        }
    }
}
