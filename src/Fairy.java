import java.util.Arrays;
import java.util.List;

public class Fairy implements Element {

    @Override
    public String getName() {
        return "Fairy";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Fairy is strong against these types
        return Arrays.asList(new Fighting(), new Dragon(), new Dark());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Fairy is weak against these types
        return Arrays.asList(new Fire(), new Poison(), new Steel());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Fairy Pokemon
        return Arrays.asList(new Fighting(), new Bug(), new Dark());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Fairy Pokemon
        return Arrays.asList(new Poison(), new Steel());
    }
}
