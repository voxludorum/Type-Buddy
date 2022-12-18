import java.util.Arrays;
import java.util.List;

public class Ghost implements Element {

    @Override
    public String getName() {
        return "Ghost";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Ghost is strong against these types
        return Arrays.asList(new Psychic(), new Ghost());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Ghost is weak against these types
        return Arrays.asList(new Dark());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Ghost Pokemon
        return Arrays.asList(new Poison(), new Bug());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Ghost Pokemon
        return Arrays.asList(new Ghost(), new Dark());
    }
}
