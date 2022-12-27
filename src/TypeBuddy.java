import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TypeBuddy extends JFrame {
    // Stores a reference to the previous window
    static JFrame homeWindow;
    static JFrame detailWindow;
    static ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Check which button was clicked
            JButton selected = (JButton) e.getSource();

            // Replace window contents with PType specific information
            String description = ((ImageIcon) selected.getIcon()).getDescription();
            elements.get(description);

        }
    };

    // Create Map of Element types
    static Map<String, Element> elements = new HashMap<>();

    static Font font = new Font("Arial", Font.BOLD, 20);
    static Font noneFont = new Font("Arial",Font.ITALIC,20);

    public TypeBuddy() throws IOException {

        // Instantiates helper class
        new TypeBuddyBuddy();

        // Sets this frame as the home frame
        homeWindow = this;





        // Sets title and default close operation
        setTitle("Type Buddy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TODO: 12/26/2022
        BufferedImage img = ImageIO.read(new File("Backgrounds/TypeBuddyBG.jpg"));
        BackgroundPanel bg = new BackgroundPanel(img);

        // Create panel to house the interactive buttons
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        panel.setBorder(new EmptyBorder(25, 25, 25, 25)); // creates margin whitespace

        // Sets default window size  // Might leave this out depending on the preferred medium
        //setPreferredSize(new Dimension(1600, 900));

        // Loads the images
        ImageIcon[] icons = TypeBuddyBuddy.loadImage();

        // Create a map of Element objects with their descriptions as keys
        TypeBuddyBuddy.fillMap(elements);

        // Counter for button layout
        int buttonCount = 0;

        // create the buttons and add to panel
        for (ImageIcon icon : icons) {

            JButton button = new JButton(icon);
            button.setIcon(icon);
            button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight())); // Set the size of the button to the size of the image
            button.setBackground(new Color(0,0,0,0));
            button.setBorderPainted(false);

            // Create a listener for clicking the button
            listener = e -> {
                // Check which button was clicked
                JButton selected = (JButton) e.getSource();

                // Replace window contents with PType specific information
                String description = ((ImageIcon) selected.getIcon()).getDescription();
                Element type = elements.get(description);

                // Check if a different window is open
                if (detailWindow != null) {
                    detailWindow.setVisible(false);
                }

                // replace window with detail information
                details(type, TypeBuddy.this); // pass the current TypeBuddy object (i.e., the JFrame) as an argument
                TypeBuddy.this.setVisible(false);
            };

            // Apply constraints and add the buttons to the panel in a 3x6 grid
            c.gridx = buttonCount % 3;
            c.gridy = buttonCount / 3 + 1; // Add 1 to the row to leave space for the back button
            c.gridwidth = 1;
            c.gridheight = 1;
            c.insets = new Insets(5,5,10,5); // Make buffer between buttons
            buttonCount++;
            button.addActionListener(listener);
            button.setBackground(new Color(0,0,0,0));
            button.setBorderPainted(false);
            panel.add(button,c);
        }

        // Add panel to the frame and pack it
        add(bg);
        add(panel);
        pack();
    }

    static void details(Element type, JFrame frame) {

        // Creates a back button, adding it to the top left corner
        JButton backButton = new JButton("Home");

        // counter
        int count;

        // Creates new JFrame object for the detail panel
        JFrame detailsWindow = new JFrame();

        // Store reference
        homeWindow = frame;
        detailWindow = detailsWindow;

        // Create the detail panel for offense and defense
        JPanel menuPanel = new JPanel(new GridBagLayout());
        JPanel detailPanel = new JPanel(new GridBagLayout());
        JPanel detailPanelAtk = new JPanel(new GridBagLayout());
        JPanel detailPanelDef = new JPanel(new GridBagLayout());
        JPanel detailPanelSpcl = new JPanel(new GridBagLayout());
        GridBagConstraints p = new GridBagConstraints();
        detailPanel.setBorder(new EmptyBorder(10,10,10,10)); // margin whitespace

        // Modify the ActionListener for the back button to show the main page and hide detail page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeWindow.setVisible(true);
                detailWindow.setVisible(false);
            }
        });

        // Add the back button to the top of the panel
        p.gridx = 0;
        p.gridy = 0;
        p.gridwidth = 1;
        p.gridheight = 1;
        p.insets = new Insets(10,10,10,10); // buffer between buttons
        backButton.setBackground(new Color(252, 115, 60));
        backButton.setBorderPainted(false);
        menuPanel.add(backButton, p);

        // Create a listener for clicking the button
        listener = e -> {
            // Check which button was clicked
            JButton selected = (JButton) e.getSource();

            // Replace window contents with PType specific information
            String description = ((ImageIcon) selected.getIcon()).getDescription();
            Element dType = elements.get(description);

            // Check if a different window is open
            if (detailWindow != null) {
                detailWindow.setVisible(false);
            }

            // replace window with detail information
            details(dType, homeWindow); // pass the current TypeBuddy object (i.e., the JFrame) as an argument
            detailWindow.setVisible(true);
        };

        // Add label
        JLabel strongAtkLabel = new JLabel();
        strongAtkLabel.setText(type.getName() + " moves are super-effective against:");
        strongAtkLabel.setFont(font);


        // Add buttons for types current type is strong against
        JPanel strongAtkButtonPanel = new JPanel(new GridBagLayout());
        count = 0;
        for (Element t : type.getStrongAtk()) {
            count = makeButton(count, p, strongAtkButtonPanel, t);
        }

        // Add Label
        JLabel weakAtkLabel = new JLabel();
        weakAtkLabel.setText(type.getName() + " moves are not very effective against:");
        weakAtkLabel.setFont(font);


        // Add buttons for types current type is weak against
        JPanel weakAtkButtonPanel = new JPanel(new GridBagLayout());
        count = 0;
        for (Element t : type.getWeakAtk()) {
            count = makeButton(count, p, weakAtkButtonPanel, t);
        }

        // Add label
        JLabel strongDefLabel = new JLabel();
        strongDefLabel.setText("These types of moves are not very effective against " + type.getName() + " Pokémon:");
        strongDefLabel.setFont(font);


        // Add buttons for types current type is strong against
        JPanel strongDefButtonPanel = new JPanel(new GridBagLayout());
        count = 0;
        for (Element t : type.getStrongDef()) {
            count = makeButton(count, p, strongDefButtonPanel, t);
        }

        // Add label
        JLabel weakDefLabel = new JLabel();
        weakDefLabel.setText("These types of moves are super-effective against " + type.getName() + " Pokémon:");
        weakDefLabel.setFont(font);


        // Add buttons for types current type is strong against
        JPanel weakDefButtonPanel = new JPanel(new GridBagLayout());
        count = 0;
        for (Element t : type.getWeakDef()) {
            count = makeButton(count, p, weakDefButtonPanel, t);
        }

        // Add label and button if type does no damage
        JLabel noDamageLabel = new JLabel();
        JPanel noDamageButtonPanel = new JPanel(new GridBagLayout());
        if (type.getNoDamage().size() > 0) {
            noDamageLabel.setText(type.getName() + " moves have no effect on: ");
            noDamageLabel.setFont(font);
            count = 0;
            for (Element t : type.getNoDamage()) {
                count = makeButton(count, p, noDamageButtonPanel, t);
            }
        }

        // Add label and button if type is immune
        JLabel immuneLabel = new JLabel();
        JPanel immuneButtonPanel = new JPanel(new GridBagLayout());
        if (type.getImmune().size() > 0) {
            immuneLabel.setText("These types of moves have no effect on : " + type.getName() + " Pokémon:");
            immuneLabel.setFont(font);
            count = 0;
            for (Element t : type.getImmune()) {
                count = makeButton(count, p, immuneButtonPanel, t);
            }
        }

        // Add the label/button pairs to their respective detailPanel

        // create label for if no type is available to show
        JLabel noneLabel1 = new JLabel("None"), noneLabel2 = new JLabel("None"),
                noneLabel3 = new JLabel("None"), noneLabel4 = new JLabel("None");
        noneLabel1.setFont(noneFont);
        noneLabel2.setFont(noneFont);
        noneLabel3.setFont(noneFont);
        noneLabel4.setFont(noneFont);

        TypeBuddyBuddy.pBag(p,0, 1, 1,1,5);
        detailPanelAtk.add(strongAtkLabel,p);
        TypeBuddyBuddy.pBag(p,0, 2, 1,1,5);
        detailPanelAtk.add(strongAtkButtonPanel,p);
        // If no element to show, state none
        if (type.getStrongAtk().size() == 0) {
            detailPanelAtk.add(noneLabel1,p);
        }

        TypeBuddyBuddy.pBag(p,0, 3, 1,1,5);
        detailPanelAtk.add(weakAtkLabel, p);
        TypeBuddyBuddy.pBag(p,0, 4, 1,1,5);
        detailPanelAtk.add(weakAtkButtonPanel, p);
        // If no element to show, state none
        if (type.getWeakAtk().size() == 0) {
            detailPanelAtk.add(noneLabel2,p);
        }

        TypeBuddyBuddy.pBag(p,0, 1, 1,1,5);
        detailPanelDef.add(strongDefLabel,p);
        TypeBuddyBuddy.pBag(p,0, 2, 1,1,5);
        detailPanelDef.add(strongDefButtonPanel,p);
        // If no element to show, state none
        if (type.getStrongDef().size() == 0) {
            detailPanelDef.add(noneLabel3,p);
        }

        TypeBuddyBuddy.pBag(p,0, 3, 1,1,5);
        detailPanelDef.add(weakDefLabel,p);
        TypeBuddyBuddy.pBag(p,0, 4, 1,1,5);
        detailPanelDef.add(weakDefButtonPanel,p);
        // If no element to show, state none
        if (type.getWeakDef().size() == 0) {
            detailPanelDef.add(noneLabel4,p);
        }

        // Add subpanels to the main panel
        TypeBuddyBuddy.pBag(p,0,0,1,1,5);
        detailPanel.add(menuPanel,p);
        TypeBuddyBuddy.pBag(p,0,1,1,1,5);
        detailPanel.add(detailPanelAtk,p);
        TypeBuddyBuddy.pBag(p,0,2,1,1,5);
        detailPanel.add(detailPanelDef,p);

        // Check to see whether to add the special panel
        if (type.getNoDamage().size() > 0 || type.getImmune().size() > 0) {

            // Check if element has no effect on certain Pokémon
            if (type.getNoDamage().size() > 0) {
                TypeBuddyBuddy.pBag(p, 0, 0, 1, 1, 5);
                detailPanelSpcl.add(noDamageLabel, p);
                TypeBuddyBuddy.pBag(p, 0, 1, 1, 1, 5);
                detailPanelSpcl.add(noDamageButtonPanel, p);
            }

            // Check if element is immune to certain damage
            if (type.getImmune().size() > 0) {
                TypeBuddyBuddy.pBag(p, 1, 0, 1, 1, 5);
                detailPanelSpcl.add(immuneLabel, p);
                TypeBuddyBuddy.pBag(p, 1, 1, 1, 1, 5);
                detailPanelSpcl.add(immuneButtonPanel, p);
            }

            TypeBuddyBuddy.pBag(p,0,3,1,1,5);
            detailPanel.add(detailPanelSpcl,p);
        }


        // refresh the window
        detailPanel.revalidate();
        detailPanel.repaint();

        // Set the panel as the content pane
        detailsWindow.setContentPane(detailPanel);
        detailsWindow.pack();
        detailsWindow.setVisible(true);
    }

    private static int makeButton(int count, GridBagConstraints p, JPanel buttonPanel, Element t) {
        JButton button = new JButton(new ImageIcon("PTypes/" + t.getName() + ".png", t.getName()));
        button.setSize(new Dimension(120, 24));
        button.setBackground(new Color(0,0,0,0));
        button.setBorderPainted(false);
        button.addActionListener(TypeBuddy.listener);
        TypeBuddyBuddy.pBag(p,count % 3, count / 3 + 1, 1,1,0);
        buttonPanel.add(button,p);
        count++;
        return count;
    }


    public static void main(String[] args) {
        // Creates the main page
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = null;
            try {
                mainFrame = new TypeBuddy();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // show main page
            mainFrame.setVisible(true);

        });
    }
}




