import java.util.Arrays;
import java.util.List;

public class Electric implements Element {

    @Override
    public String getName() {
        return "Electric";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Fire is strong against these types
        return Arrays.asList(new Grass(), new Ice(), new Bug(), new Steel());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Fire is weak against these types
        return Arrays.asList(new Fire(), new Water(), new Rock(), new Dragon());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Fire Pokemon
        return Arrays.asList(new Fire(), new Grass(), new Ice(), new Bug(), new Steel(), new Fairy());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Fire Pokemon
        return Arrays.asList(new Water(), new Ground(), new Rock());
    }
}
