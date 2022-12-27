import java.util.Arrays;
import java.util.List;

public class Rock implements Element {

    @Override
    public String getName() {
        return "Rock";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Rock is strong against these types
        return Arrays.asList(new Fire(), new Ice(), new Flying(), new Bug());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Rock is weak against these types
        return Arrays.asList(new Fighting(), new Ground(), new Steel());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Rock Pokemon
        return Arrays.asList(new Normal(), new Fire(), new Poison(), new Flying());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Rock Pokemon
        return Arrays.asList(new Water(), new Grass(), new Fighting(), new Ground(), new Steel());
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
