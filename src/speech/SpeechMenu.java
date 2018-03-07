
package speech;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import main.NavigationAction;
import menu.MenuState;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;

/*
public class SpeechMenu extends JFrame implements MenuState
{
    //Attributes
    private JFrame frame;
    private JPanel screen;
    private ActionListener listener;
    private Graphics2D renderer;
    private JMenuBar menuBar = new VerticalMenuBar();
    private int menuIndex = -1;


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
    public void actionPerformed(ActionEvent e) { }

    @Override
    public void start()
    {
        menuBar.add(new LanguageMenu("Off", null, null, null));
        menuBar.add(new LanguageMenu("English", "en-US", "Apollo", "(en-GB, Susan, Apollo)"));
        menuBar.add(new LanguageMenu("French", "fr-FR", "Apollo", "(fr-FR, Julie, Apollo)"));
        menuBar.add(new LanguageMenu("German", "de-DE", "Hedda", "(de-DE, Hedda)"));
        menuBar.add(new LanguageMenu("Italian", "it-IT", "Apollo", "(it-IT, Cosimo, Apollo)"));
        menuBar.add(new LanguageMenu("Spanish", "es-ES", "Apollo", "(es-ES, Laura, Apollo)"));

        for (int i = 0; i < menuBar.getMenuCount(); ) screen.add(menuBar.getMenu(i));
    }

    @Override
    public void stop()
    {
        for (int i = 0; i < menuBar.getMenuCount(); i++) screen.remove(menuBar.getMenu(i));
    }

    @Override
    public void render()
    {
       for (int i = 0; i < menuBar.getMenuCount(); i++) menuBar.getMenu(i).repaint();
    }

    @Override
    public void navigationButton(NavigationAction e)
    {
        if ((e == NavigationAction.PLUS) && (menuIndex > 0)) //Go upwards
        {
            menuIndex--;
            menuBar.getMenu(menuIndex+1).setBackground(Color.WHITE);
            menuBar.getMenu(menuIndex).setBackground(Color.ORANGE);
        }

        if ((e == NavigationAction.MINUS) && (menuIndex < (menuBar.getMenuCount()-1))) //Go downwards
        {
            menuIndex++;
            if (menuIndex == 0)
            {
                menuBar.getMenu(menuIndex).setBackground(Color.ORANGE);
            }
            else
            {
                menuBar.getMenu(menuIndex - 1).setBackground(Color.WHITE);
                menuBar.getMenu(menuIndex).setBackground(Color.ORANGE);
            }
        }

        if (e == NavigationAction.SELECT)
        {
            Component menu = menuBar.getComponent(menuIndex);
            SpeechGenerator.setLanguage(menuBar.getComponent(menuIndex).languageCode);
            SpeechGenerator.setGender(menuBar.getComponent(menuIndex).languageGender);
            SpeechGenerator.setArtist(menuBar.getComponent(menuIndex).languageArtist);
            System.out.println("Language is now set to: " + SpeechGenerator.getLanguage());
            System.out.println("Gender is now set to: " + SpeechGenerator.getGender());
            System.out.println("Artist is now set to: " + SpeechGenerator.getArtist());
        }
    }


    @Override
    public void navigationButton(NavigationAction e)
    {
        if ((e == NavigationAction.PLUS) && (buttonIndex > 0)) //Go upwards
        {
            buttonIndex--;
            menus.get(buttonIndex+1).setBackground(Color.WHITE);
            menus.get(buttonIndex).setBackground(Color.ORANGE);
        }

        if ((e == NavigationAction.MINUS) && (buttonIndex < (menus.size()-1))) //Go downwards
        {
            buttonIndex++;
            if (buttonIndex == 0)
            {
                menus.get(buttonIndex).setBackground(Color.ORANGE);
            }
            else
            {
                menus.get(buttonIndex - 1).setBackground(Color.WHITE);
                menus.get(buttonIndex).setBackground(Color.ORANGE);
            }
        }

        if (e == NavigationAction.SELECT)
        {
            SpeechGenerator.setLanguage(menus.get(buttonIndex).languageCode);
            SpeechGenerator.setGender(menus.get(buttonIndex).languageGender);
            SpeechGenerator.setArtist(menus.get(buttonIndex).languageArtist);
            System.out.println("Language is now set to: " + SpeechGenerator.getLanguage());
            System.out.println("Gender is now set to: " + SpeechGenerator.getGender());
            System.out.println("Artist is now set to: " + SpeechGenerator.getArtist());
        }
    }




    /*
    public class VerticalMenuBar extends JMenuBar
    {
        private final LayoutManager grid = new GridLayout(0,1);
        VerticalMenuBar()
        {
            setLayout(grid);
        }
    }

    public class LanguageMenu extends JMenu
    {
        String languageType;
        String languageCode;
        String languageGender;
        String languageArtist;
        LanguageMenu(String languageType, String languageCode, String languageGender, String languageArtist)
        {
            this.languageType = languageType;
            this.languageCode = languageCode;
            this.languageGender = languageGender;
            this.languageArtist = languageArtist;
            this.setText(languageType);
            this.setFont(new Font("Ariel", Font.BOLD, 24));
           // this.setBorder(new LineBorder(Color.BLACK, 3));
            this.setPreferredSize((new Dimension(191, 35)));
            this.setBackground(Color.WHITE);
        }
    }
}
    */
