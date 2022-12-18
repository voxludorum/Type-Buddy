import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TypeBuddy extends JFrame {
    public TypeBuddy() {
        // Sets title and default close operation
        setTitle("Type Buddy");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel to house the interactive buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 3, 50, 50));
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
        Map<String, Element> elements = new HashMap<>();
        elements.put("Normal", new Normal());
        elements.put("Fire", new Fire());
        elements.put("Water", new Water());
        // Add other Element objects to the map as needed


        // create the buttons and add to panel
        for (ImageIcon icon : icons) {
            JButton button = new JButton(icon);
            button.setIcon(icon);
            button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight())); // Set the size of the button to the size of the image

            // Create a listener for clicking the button
            ActionListener listener = e -> {
                // Replace window contents with PType specific information
                String description = icon.getDescription();
                Element type = elements.get(description);
                details(type, TypeBuddy.this, listener); // pass the current TypeBuddy object (i.e., the JFrame) as an argument
            };

            button.addActionListener(listener);
            panel.add(button);
        }
        // Add panel to the frame and pack it
        add(panel);
        pack();

    }

    static void details(Element type, JFrame frame, ActionListener listener) {
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));
        detailPanel.setBorder(new EmptyBorder(50,50,50,50));

        JLabel strongAtkLabel = new JLabel();
        strongAtkLabel.setText(type.getName() + " moves are super-effective against:");
        //detailPanel.setLayout(new GridLayout(1,6, 50, 50));

        // Add buttons for types current type is strong against
        JPanel strongAtkButtonPanel = new JPanel(new GridLayout(1,6,50,50));
        for (Element t : type.getStrongAtk()) {
            JButton button = new JButton(new ImageIcon("PTypes/" + t.getName() + ".png", t.getName()));
            button.setPreferredSize(new Dimension(120, 24));
            strongAtkButtonPanel.add(button);
        }

        JLabel weakAtkLabel = new JLabel();
        weakAtkLabel.setText(type.getName() + " moves are not very effective against:");
        //detailPanel.setLayout(new GridLayout(1,6, 50, 50));

        // Add buttons for types current type is weak against
        JPanel weakAtkButtonPanel = new JPanel(new GridLayout(1,6,50,50));
        for (Element t : type.getWeakAtk()) {
            JButton button = new JButton(new ImageIcon("PTypes/" + t.getName() + ".png", t.getName()));
            button.setPreferredSize(new Dimension(120, 24));
            weakAtkButtonPanel.add(button);
        }

        JLabel strongDefLabel = new JLabel();
        strongDefLabel.setText("These types of moves are not very effective against " + type.getName() + " Pokemon:");
        //detailPanel.setLayout(new GridLayout(1,6, 50, 50));

        // Add buttons for types current type is strong against
        JPanel strongDefButtonPanel = new JPanel(new GridLayout(1,6,50,50));
        for (Element t : type.getStrongDef()) {
            JButton button = new JButton(new ImageIcon("PTypes/" + t.getName() + ".png", t.getName()));
            button.setPreferredSize(new Dimension(120, 24));
            strongDefButtonPanel.add(button);
        }

        JLabel weakDefLabel = new JLabel();
        weakDefLabel.setText("These types of moves are super-effective against " + type.getName() + " Pokemon:");
        //detailPanel.setLayout(new GridLayout(1,6, 50, 50));

        // Add buttons for types current type is strong against
        JPanel weakDefButtonPanel = new JPanel(new GridLayout(1,6,50,50));
        for (Element t : type.getWeakDef()) {
            JButton button = new JButton(new ImageIcon("PTypes/" + t.getName() + ".png", t.getName()));
            button.setPreferredSize(new Dimension(120, 24));
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

        // Add an action listener to each button
        for (Component component : strongAtkButtonPanel.getComponents()) {
            JButton button = (JButton) component;
            button.addActionListener(listener);
        }

        for (Component component : weakAtkButtonPanel.getComponents()) {
            JButton button = (JButton) component;
            button.addActionListener(listener);
        }

        for (Component component : strongDefButtonPanel.getComponents()) {
            JButton button = (JButton) component;
            button.addActionListener(listener);
        }

        for (Component component : weakDefButtonPanel.getComponents()) {
            JButton button = (JButton) component;
            button.addActionListener(listener);
        }

        // refresh the window
        detailPanel.revalidate();
        detailPanel.repaint();

        // Set the panel as the content pane
        frame.setContentPane(detailPanel);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // What does this do?
            JFrame frame = new TypeBuddy();
            frame.setVisible(true);
        });
    }
}







//    static void details(Type type) {
//        JPanel detailPanel = new JPanel();
//        detailPanel.setBorder(new EmptyBorder(50,50,50,50));
//        JLabel strongAtkLabel = new JLabel();
//        strongAtkLabel.setText(type.getName() + " moves are super-effective against:");
//        detailPanel.setLayout(new GridLayout(1,6, 50, 50));
//
//        // Add buttons for types that the current type is strong against
//        for (Type t : type.getStrongAgainst()) {
//            JButton button = new JButton(new ImageIcon("PTypes/" + t.getName() + ".png", t.getName()));
//            button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
//            detailPanel.add(button);
//        }
//
//        JLabel weakAtkLabel = new JLabel();
//        strongAtkLabel.setText(type.getName() + " moves are not very effective against:");
//        detailPanel.setLayout(new GridLayout(1,6, 50, 50));
//
//        // Add buttons for types that the current type is weak against
//        for (Type t : type.getWeakAgainst()) {
//            JButton button = new JButton(new ImageIcon("PTypes/" + t.getName() + ".png", t.getName()));
//            button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
//            detailPanel.add(button);
//        }
//
//        // Add other labels and buttons for strong/weak defense here...
//    }





