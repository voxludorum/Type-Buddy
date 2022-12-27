import java.util.Arrays;
import java.util.List;

public class Normal implements Element {

    @Override
    public String getName() {
        return "Normal";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Normal is strong against these types
        return Arrays.asList(new Rock(), new Steel());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Normal is weak against these types
        return Arrays.asList();
    }

    public List<Element> getStrongDef() {
        // These types are weak against Normal Pokemon
        return Arrays.asList();
    }

    public List<Element> getWeakDef() {
        // These types are strong against Normal Pokemon
        return Arrays.asList(new Fighting());
    }

    public List<Element> getNoDamage() {
        // Normal has no effect on these types
        return Arrays.asList(new Ghost());
    }

    public List<Element> getImmune() {
        return Arrays.asList();
    }

}
