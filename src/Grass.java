import java.util.Arrays;
import java.util.List;

public class Grass implements Element {

    @Override
    public String getName() {
        return "Grass";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Grass is strong against these types
        return Arrays.asList(new Water(), new Ground(), new Rock());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Grass is weak against these types
        return Arrays.asList(new Fire(), new Grass(), new Poison(), new Flying(), new Bug(), new Dragon(), new Steel());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Grass Pokémon
        return Arrays.asList(new Water(), new Electric(), new Grass(), new Ground());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Grass Pokémon
        return Arrays.asList(new Fire(), new Ice(), new Poison(), new Flying(), new Bug());
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
