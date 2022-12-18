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
            Element type = elements.get(description);

        }
    };
    static Map<String, Element> elements = new HashMap<>();

    public TypeBuddy() {

        homeWindow = this;

        // Creates a back button, adding it to the top left corner
        JButton backButton = new JButton("Home");


        // Sets title and default close operation
        setTitle("Type Buddy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel to house the interactive buttons
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //panel.setLayout(new GridLayout(6, 3, 50, 50));
        //panel.setLayout(new FlowLayout());
        panel.setBorder(new EmptyBorder(50, 50, 50, 50)); // creates margin whitespace

        // Sets default window size
        setPreferredSize(new Dimension(1600, 900));

        // Loads the images
        ImageIcon[] icons = {
                new ImageIcon("PTypes/Normal.png", "Normal"), new ImageIcon("PTypes/Fire.png", "Fire"),
                new ImageIcon("PTypes/Water.png", "Water"), new ImageIcon("PTypes/Electric.png", "Electric"),
                new ImageIcon("PTypes/Grass.png", "Grass"), new ImageIcon("PTypes/Ice.png", "Ice"),
                new ImageIcon("PTypes/Fighting.png", "Fighting"), new ImageIcon("PTypes/Poison.png", "Poison"),
                new ImageIcon("PTypes/Ground.png", "Ground"), new ImageIcon("PTypes/Flying.png", "Flying"),
                new ImageIcon("PTypes/Psychic.png", "Psychic"), new ImageIcon("PTypes/Bug.png", "Bug"),
                new ImageIcon("PTypes/Rock.png", "Rock"), new ImageIcon("PTypes/Ghost.png", "Ghost"),
                new ImageIcon("PTypes/Dragon.png", "Dragon"), new ImageIcon("PTypes/Dark.png", "Dark"),
                new ImageIcon("PTypes/Steel.png", "Steel"), new ImageIcon("PTypes/Fairy.png", "Fairy"),
        };

        // Create a map of Element objects with their descriptions as keys
        elements.put("Normal", new Normal());
        elements.put("Fire", new Fire());
        elements.put("Water", new Water());
        elements.put("Electric", new Electric());
        elements.put("Grass", new Grass());
        elements.put("Ice", new Ice());
        elements.put("Fighting", new Fighting());
        elements.put("Poison", new Poison());
        elements.put("Ground", new Ground());
        elements.put("Flying", new Flying());
        elements.put("Psychic", new Psychic());
        elements.put("Bug", new Bug());
        elements.put("Rock", new Rock());
        elements.put("Ghost", new Ghost());
        elements.put("Dragon", new Dragon());
        elements.put("Dark", new Dark());
        elements.put("Steel", new Steel());
        elements.put("Fairy", new Fairy());


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

            button.addActionListener(listener);
            panel.add(button);
        }
        // Add panel to the frame and pack it
        add(panel);
        pack();

    }

    static void details(Element type, JFrame frame, JButton backButton) {

        // Creates new JFrame object for the detail panel
        JFrame detailsWindow = new JFrame();

        // Store reference
        homeWindow = frame;
        detailWindow = detailsWindow;

        // Create the detail panel
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));
        //detailPanel.setLayout(new FlowLayout());
        detailPanel.setBorder(new EmptyBorder(50,50,50,50));

        // Modify the ActionListener for the back button to show the main page and hide detail page
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeWindow.setVisible(true);
                detailWindow.setVisible(false);
            }
        });
        detailPanel.add(backButton, BorderLayout.WEST);

        JLabel strongAtkLabel = new JLabel();
        strongAtkLabel.setText(type.getName() + " moves are super-effective against:");
        //detailPanel.setLayout(new GridLayout(1,6, 50, 50));

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

        // Add buttons for types current type is strong against
        JPanel strongAtkButtonPanel = new JPanel(new GridLayout(1,6,50,50));
        for (Element t : type.getStrongAtk()) {
            JButton button = new JButton(new ImageIcon("PTypes/" + t.getName() + ".png", t.getName()));
            button.setSize(new Dimension(120, 24));
            button.addActionListener(TypeBuddy.listener);
            strongAtkButtonPanel.add(button);
        }

        JLabel weakAtkLabel = new JLabel();
        weakAtkLabel.setText(type.getName() + " moves are not very effective against:");
        //detailPanel.setLayout(new GridLayout(1,6, 50, 50));

        // Add buttons for types current type is weak against
        JPanel weakAtkButtonPanel = new JPanel(new GridLayout(1,6,50,50));
        for (Element t : type.getWeakAtk()) {
            JButton button = new JButton(new ImageIcon("PTypes/" + t.getName() + ".png", t.getName()));
            button.setSize(new Dimension(120, 24));
            button.addActionListener(TypeBuddy.listener);
            weakAtkButtonPanel.add(button);
        }

        JLabel strongDefLabel = new JLabel();
        strongDefLabel.setText("These types of moves are not very effective against " + type.getName() + " Pokémon:");
        //detailPanel.setLayout(new GridLayout(1,6, 50, 50));

        // Add buttons for types current type is strong against
        JPanel strongDefButtonPanel = new JPanel(new GridLayout(1,6,50,50));
        for (Element t : type.getStrongDef()) {
            JButton button = new JButton(new ImageIcon("PTypes/" + t.getName() + ".png", t.getName()));
            button.setSize(new Dimension(120, 24));
            button.addActionListener(TypeBuddy.listener);
            strongDefButtonPanel.add(button);
        }

        JLabel weakDefLabel = new JLabel();
        weakDefLabel.setText("These types of moves are super-effective against " + type.getName() + " Pokémon:");
        //detailPanel.setLayout(new GridLayout(1,6, 50, 50));

        // Add buttons for types current type is strong against
        JPanel weakDefButtonPanel = new JPanel(new GridLayout(1,6,50,50));
        for (Element t : type.getWeakDef()) {
            JButton button = new JButton(new ImageIcon("PTypes/" + t.getName() + ".png", t.getName()));
            button.setSize(new Dimension(120, 24));
            button.addActionListener(TypeBuddy.listener);
            weakDefButtonPanel.add(button);
        }

        // Add the label/button pairs to the detailPanel
        detailPanel.add(strongAtkLabel);
        detailPanel.add(strongAtkButtonPanel);

        detailPanel.add(weakAtkLabel);
        detailPanel.add(weakAtkButtonPanel);

        detailPanel.add(strongDefLabel);
        detailPanel.add(strongDefButtonPanel);

        detailPanel.add(weakDefLabel);
        detailPanel.add(weakDefButtonPanel);

        // refresh the window
        detailPanel.revalidate();
        detailPanel.repaint();

        // Set the panel as the content pane
        detailsWindow.setContentPane(detailPanel);
        detailsWindow.pack();
        detailsWindow.setVisible(true);
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




