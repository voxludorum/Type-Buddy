import java.util.Arrays;
import java.util.List;

public class Water implements Element {

    @Override
    public String getName() {
        return "Water";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Water is strong against these types
        return Arrays.asList(new Fire(), new Ground(), new Rock());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Water is weak against these types
        return Arrays.asList(new Water(), new Grass(), new Dragon());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Water Pokemon
        return Arrays.asList(new Fire(), new Water(), new Ice(), new Steel());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Water Pokemon
        return Arrays.asList(new Electric(), new Grass());
    }
}
