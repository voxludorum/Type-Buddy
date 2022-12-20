import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
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

    public TypeBuddy() {

        // Instantiates helper class
        new TypeBuddyBuddy();

        // Sets this frame as the home frame
        homeWindow = this;

        // Creates a back button, adding it to the top left corner
        JButton backButton = new JButton("Home");


        // Sets title and default close operation
        setTitle("Type Buddy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel to house the interactive buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
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
            button.setSize(new Dimension(icon.getIconWidth(), icon.getIconHeight())); // Set the size of the button to the size of the image

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
                details(type, TypeBuddy.this, backButton); // pass the current TypeBuddy object (i.e., the JFrame) as an argument
                TypeBuddy.this.setVisible(false);
            };
            // Apply constraints and add the buttons to the panel in a 3x6 grid
            c.gridx = buttonCount % 3;
            c.gridy = buttonCount / 3 + 1; // Add 1 to the row to leave space for the back button
            c.gridwidth = 1;
            c.gridheight = 1;
            c.insets = new Insets(10,10,10,10); // Make buffer between buttons
            buttonCount++;
            button.addActionListener(listener);
            panel.add(button,c);
        }

        // Add panel to the frame and pack it
        add(panel);
        pack();
    }

    static void details(Element type, JFrame frame, JButton backButton) {

        // counter
        int count;

        // Creates new JFrame object for the detail panel
        JFrame detailsWindow = new JFrame();

        // Store reference
        homeWindow = frame;
        detailWindow = detailsWindow;

        // Create the detail panel
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new GridBagLayout());
        GridBagConstraints p = new GridBagConstraints();
        detailPanel.setBorder(new EmptyBorder(25,25,25,25)); // margin whitespace

        // Modify the ActionListener for the back button to show the main page and hide detail page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeWindow.setVisible(true);
                detailWindow.setVisible(false);
            }
        });

        // Add the back button to the top left corner of the panel
        p.gridx = 0;
        p.gridy = 0;
        p.gridwidth = 1;
        p.gridheight = 1;
        p.insets = new Insets(10,10,10,10); // buffer between buttons
        detailPanel.add(backButton, p);

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
            details(dType, homeWindow, backButton); // pass the current TypeBuddy object (i.e., the JFrame) as an argument
            detailWindow.setVisible(true);
        };

        // Add label
        JLabel strongAtkLabel = new JLabel();
        strongAtkLabel.setText(type.getName() + " moves are super-effective against:");

        // Add buttons for types current type is strong against
        JPanel strongAtkButtonPanel = new JPanel(new GridBagLayout());
        count = 0;
        for (Element t : type.getStrongAtk()) {
            count = makeButton(count, p, strongAtkButtonPanel, t);
        }

        // Add Label
        JLabel weakAtkLabel = new JLabel();
        weakAtkLabel.setText(type.getName() + " moves are not very effective against:");

        // Add buttons for types current type is weak against
        JPanel weakAtkButtonPanel = new JPanel(new GridBagLayout());
        count = 0;
        for (Element t : type.getWeakAtk()) {
            count = makeButton(count, p, weakAtkButtonPanel, t);
        }

        // Add label
        JLabel strongDefLabel = new JLabel();
        strongDefLabel.setText("These types of moves are not very effective against " + type.getName() + " Pokémon:");

        // Add buttons for types current type is strong against
        JPanel strongDefButtonPanel = new JPanel(new GridBagLayout());
        count = 0;
        for (Element t : type.getStrongDef()) {
            count = makeButton(count, p, strongDefButtonPanel, t);
        }

        // Add label
        JLabel weakDefLabel = new JLabel();
        weakDefLabel.setText("These types of moves are super-effective against " + type.getName() + " Pokémon:");

        // Add buttons for types current type is strong against
        JPanel weakDefButtonPanel = new JPanel(new GridBagLayout());
        count = 0;
        for (Element t : type.getWeakDef()) {
            count = makeButton(count, p, weakDefButtonPanel, t);
        }

        // Add the label/button pairs to the detailPanel
        TypeBuddyBuddy.pBag(p,0, 1, 1,1,10);
        detailPanel.add(strongAtkLabel,p);

        TypeBuddyBuddy.pBag(p,0, 2, 1,1,10);
        detailPanel.add(strongAtkButtonPanel,p);

        TypeBuddyBuddy.pBag(p,0, 3, 1,1,10);
        detailPanel.add(weakAtkLabel,p);

        TypeBuddyBuddy.pBag(p,0, 4, 1,1,10);
        detailPanel.add(weakAtkButtonPanel,p);

        TypeBuddyBuddy.pBag(p,0, 5, 1,1,10);
        detailPanel.add(strongDefLabel,p);

        TypeBuddyBuddy.pBag(p,0, 6, 1,1,10);
        detailPanel.add(strongDefButtonPanel,p);

        TypeBuddyBuddy.pBag(p,0, 7, 1,1,10);
        detailPanel.add(weakDefLabel,p);

        TypeBuddyBuddy.pBag(p,0, 8, 1,1,10);
        detailPanel.add(weakDefButtonPanel,p);

        // refresh the window
        detailPanel.revalidate();
        detailPanel.repaint();

        // Set the panel as the content pane
        detailsWindow.setContentPane(detailPanel);
        detailsWindow.pack();
        detailsWindow.setVisible(true);
    }

    private static int makeButton(int count, GridBagConstraints p, JPanel strongAtkButtonPanel, Element t) {
        JButton button = new JButton(new ImageIcon("PTypes/" + t.getName() + ".png", t.getName()));
        button.setSize(new Dimension(120, 24));
        button.addActionListener(TypeBuddy.listener);
        TypeBuddyBuddy.pBag(p,count, 1, 1,1,10);
        strongAtkButtonPanel.add(button,p);
        count++;
        return count;
    }


    public static void main(String[] args) {
        // Creates the main page
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new TypeBuddy();

            // show main page
            mainFrame.setVisible(true);

        });
    }
}




