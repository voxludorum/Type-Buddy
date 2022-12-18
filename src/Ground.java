import java.util.Arrays;
import java.util.List;

public class Ground implements Element {

    @Override
    public String getName() {
        return "Ground";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Ground is strong against these types
        return Arrays.asList(new Fire(), new Electric(), new Poison(), new Rock(), new Steel());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Ground is weak against these types
        return Arrays.asList(new Grass(), new Bug());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Ground Pokemon
        return Arrays.asList(new Poison(), new Rock());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Ground Pokemon
        return Arrays.asList(new Water(), new Grass(), new Ice());
    }
}
