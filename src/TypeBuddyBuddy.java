import javax.swing.*;
import java.awt.*;
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

        // Reference the images
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image normal = toolkit.getImage("PTypes/Normal.png");
        Image fire = toolkit.getImage("PTypes/Fire.png");
        Image water = toolkit.getImage("PTypes/Water.png");
        Image electric = toolkit.getImage("PTypes/Electric.png");
        Image grass = toolkit.getImage("PTypes/Grass.png");
        Image ice = toolkit.getImage("PTypes/Ice.png");
        Image fighting = toolkit.getImage("PTypes/Fighting.png");
        Image poison = toolkit.getImage("PTypes/Poison.png");
        Image ground = toolkit.getImage("PTypes/Ground.png");
        Image flying = toolkit.getImage("PTypes/Flying.png");
        Image psychic = toolkit.getImage("PTypes/Psychic.png");
        Image bug = toolkit.getImage("PTypes/Bug.png");
        Image rock = toolkit.getImage("PTypes/Rock.png");
        Image ghost = toolkit.getImage("PTypes/Ghost.png");
        Image dragon = toolkit.getImage("PTypes/Dragon.png");
        Image dark = toolkit.getImage("PTypes/Dark.png");
        Image steel = toolkit.getImage("PTypes/Steel.png");
        Image fairy = toolkit.getImage("PTypes/Fairy.png");
        Image bg = toolkit.getImage("Backgrounds/TypeBuddyBG.jpg");

        // Loads the images
        ImageIcon[] icons = {
                new ImageIcon(normal, "Normal"), new ImageIcon(fire, "Fire"),
                new ImageIcon(water, "Water"), new ImageIcon(electric, "Electric"),
                new ImageIcon(grass, "Grass"), new ImageIcon(ice, "Ice"),
                new ImageIcon(fighting, "Fighting"), new ImageIcon(poison, "Poison"),
                new ImageIcon(ground, "Ground"), new ImageIcon(flying, "Flying"),
                new ImageIcon(psychic, "Psychic"), new ImageIcon(bug, "Bug"),
                new ImageIcon(rock, "Rock"), new ImageIcon(ghost, "Ghost"),
                new ImageIcon(dragon, "Dragon"), new ImageIcon(dark, "Dark"),
                new ImageIcon(steel, "Steel"), new ImageIcon(fairy, "Fairy"),
        };

        return icons;
    }

    static GridBagConstraints pBag(GridBagConstraints c, int x, int y, int width, int height, int insets) {

        // Sets the constraints
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.insets = new Insets(insets,insets,insets,insets);
        return c;
    }

    static GridBagConstraints buffer(GridBagConstraints c) {
        c.insets = new Insets(10,10,10,10);
        return c;
    }

}
