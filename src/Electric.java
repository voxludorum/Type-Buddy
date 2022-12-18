import java.util.Arrays;
import java.util.List;

public class Electric implements Element {

    @Override
    public String getName() {
        return "Electric";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Electric is strong against these types
        return Arrays.asList(new Water(), new Flying());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Electric is weak against these types
        return Arrays.asList(new Electric(), new Grass(), new Dragon());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Electric Pokémon
        return Arrays.asList(new Electric(), new Flying(), new Steel());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Electric Pokémon
        return Arrays.asList(new Ground());
    }

}
