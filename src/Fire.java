import java.util.Arrays;
import java.util.List;

public class Fire implements Element { //Inherits from Element class


//    public Fire(){
//        String[] strongAtk = {"Grass", "Ice", "Bug", "Steel"};
//        String[] weakAtk = {"Fire", "Water", "Rock", "Dragon"};
//        String[] strongDef = {"Fire", "Grass", "Ice", "Bug", "Steel", "Fairy"};
//        String[] weakDef = {"Water", "Ground", "Rock"};
//    }

    @Override
    public String getName() {
        return "Fire";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Fire is strong against these types
        return Arrays.asList(new Grass(), new Ice(), new Bug(), new Steel());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Fire is weak against these types
        return Arrays.asList(new Fire(), new Water(), new Rock(), new Dragon());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Fire Pokémon
        return Arrays.asList(new Fire(), new Grass(), new Ice(), new Bug(), new Steel(), new Fairy());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Fire Pokémon
        return Arrays.asList(new Water(), new Ground(), new Rock());
    }

    @Override
    public List<Element> getNoDamage() {
        return Arrays.asList();
    }

    @Override
    public List<Element> getImmune() {
        return Arrays.asList();
    }
}
