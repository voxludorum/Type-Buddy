import java.util.Arrays;
import java.util.List;

public class Ice implements Element {

    @Override
    public String getName() {
        return "Ice";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Ice is strong against these types
        return Arrays.asList(new Grass(), new Ground(), new Flying(), new Dragon());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Ice is weak against these types
        return Arrays.asList(new Fire(), new Water(), new Ice(), new Steel());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Ice Pokémon
        return Arrays.asList(new Ice());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Ice Pokémon
        return Arrays.asList(new Fire(), new Fighting(), new Rock(), new Steel());
    }
}
