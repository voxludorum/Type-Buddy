import java.util.Arrays;
import java.util.List;

public class Flying implements Element {

    @Override
    public String getName() {
        return "Flying";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Flying is strong against these types
        return Arrays.asList(new Grass(), new Fighting(), new Bug());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Flying is weak against these types
        return Arrays.asList(new Electric(), new Rock(), new Steel());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Flying Pokemon
        return Arrays.asList(new Grass(), new Fighting(), new Bug());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Flying Pokemon
        return Arrays.asList(new Electric(), new Ice(), new Rock());
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
