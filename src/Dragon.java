import java.util.Arrays;
import java.util.List;

public class Dragon implements Element {

    @Override
    public String getName() {
        return "Dragon";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Dragon is strong against these types
        return Arrays.asList(new Dragon());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Dragon is weak against these types
        return Arrays.asList(new Steel());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Dragon Pokemon
        return Arrays.asList(new Fire(), new Water(), new Electric(), new Grass());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Dragon Pokemon
        return Arrays.asList(new Ice(), new Dragon(), new Fairy());
    }
}
