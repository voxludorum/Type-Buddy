import java.util.Arrays;
import java.util.List;

public class Fighting implements Element {

    @Override
    public String getName() {
        return "Fighting";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Fighting is strong against these types
        return Arrays.asList(new Normal(), new Ice(), new Rock(), new Dark(), new Steel());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Fighting is weak against these types
        return Arrays.asList(new Poison(), new Flying(), new Psychic(), new Bug(), new Fairy());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Fighting Pokémon
        return Arrays.asList(new Bug(), new Rock(), new Dark());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Fighting Pokémon
        return Arrays.asList(new Flying(), new Psychic(), new Fairy());
    }
}
