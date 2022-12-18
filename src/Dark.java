import java.util.Arrays;
import java.util.List;

public class Dark implements Element {

    @Override
    public String getName() {
        return "Dark";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Dark is strong against these types
        return Arrays.asList(new Psychic(), new Ghost());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Dark is weak against these types
        return Arrays.asList(new Fighting(), new Dark(), new Fairy());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Dark Pokemon
        return Arrays.asList(new Ghost(), new Dark());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Dark Pokemon
        return Arrays.asList(new Fighting(), new Bug(), new Fairy());
    }
}
