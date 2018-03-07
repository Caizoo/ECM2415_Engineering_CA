
package speech;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import main.NavigationAction;
import menu.MenuState;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.border.LineBorder;

/*
 * Code by Joshua Chalcraft
 *
 * Changes made since last scrum:
 *   - Changed the structure
 */
public class abc extends JFrame implements MenuState
{
    //Attributes
    private JFrame frame;
    private JPanel screen;
    private ActionListener listener;
    private Graphics2D renderer;
    private LanguageMenuBar menuBar = new LanguageMenuBar();
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
    public void actionPerformed(ActionEvent e)
    {
        {
            if(e.getSource().equals(menuBar.getMenu(0)))
            {
                System.out.println("Off button clicked");
            }
        }
    }

    @Override
    public void start()
    {
        menuBar.add(new LanguageMenu("Off", null, null, null));
        menuBar.add(new LanguageMenu("English", "en-US", "Apollo", "(en-GB, Susan, Apollo)"));
        menuBar.add(new LanguageMenu("French", "fr-FR", "Apollo", "(fr-FR, Julie, Apollo)"));
        menuBar.add(new LanguageMenu("German", "de-DE", "Hedda", "(de-DE, Hedda)"));
        menuBar.add(new LanguageMenu("Italian", "it-IT", "Apollo", "(it-IT, Cosimo, Apollo)"));
        menuBar.add(new LanguageMenu("Spanish", "es-ES", "Apollo", "(es-ES, Laura, Apollo)"));
        screen.add(menuBar);
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
            LanguageMenu menu = (LanguageMenu) menuBar.getMenu(menuIndex);
            SpeechGenerator.setLanguage(menu.languageCode);
            SpeechGenerator.setGender(menu.languageGender);
            SpeechGenerator.setArtist(menu.languageArtist);
            //System.out.println("Language is now set to: " + SpeechGenerator.getLanguage());
            //System.out.println("Gender is now set to: " + SpeechGenerator.getGender());
            //System.out.println("Artist is now set to: " + SpeechGenerator.getArtist());
        }
    }

    //Used to make the menu vertical.
    public class LanguageMenuBar extends JMenuBar
    {
        private final LayoutManager grid = new GridLayout(0,1);
        LanguageMenuBar()
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
            this.setBorder(new LineBorder(Color.BLACK, 3));
            this.setPreferredSize((new Dimension(191, 40)));
            this.setOpaque(true);
            this.setBackground(Color.WHITE);
            this.addActionListener(listener);
        }
    }
}

