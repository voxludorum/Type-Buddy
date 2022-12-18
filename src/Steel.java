import java.util.Arrays;
import java.util.List;

public class Steel implements Element {

    @Override
    public String getName() {
        return "Steel";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Steel is strong against these types
        return Arrays.asList(new Ice(), new Rock(), new Fairy());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Steel is weak against these types
        return Arrays.asList(new Fire(), new Water(), new Electric(), new Steel());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Steel Pokemon
        return Arrays.asList(new Normal(), new Grass(), new Ice(), new Flying(), new Psychic(), new Bug(), new Rock(), new Dragon(), new Steel(), new Fairy());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Steel Pokemon
        return Arrays.asList(new Fire(), new Fighting(), new Ground());
    }
}
