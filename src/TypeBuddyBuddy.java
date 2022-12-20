import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class TypeBuddyBuddy {

    public TypeBuddyBuddy() {
    }

    static void fillMap(Map<String, Element> elements) {

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
    }

    static ImageIcon[] loadImage() {

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

        return icons;
    }

    static GridBagConstraints pBag(GridBagConstraints c, int x, int y, int width, int height) {

        // Sets the constraints
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;

        return c;
    }

    static GridBagConstraints buffer(GridBagConstraints c) {
        c.insets = new Insets(10,10,10,10);
        return c;
    }

}
