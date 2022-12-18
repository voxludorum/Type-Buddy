import java.util.Arrays;
import java.util.List;

public class Psychic implements Element {

    @Override
    public String getName() {
        return "Psychic";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Psychic is strong against these types
        return Arrays.asList(new Fighting(), new Poison());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Psychic is weak against these types
        return Arrays.asList(new Psychic(), new Steel());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Psychic Pokemon
        return Arrays.asList(new Fighting(), new Psychic());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Psychic Pokemon
        return Arrays.asList(new Bug(), new Ghost(), new Dark());
    }
}
