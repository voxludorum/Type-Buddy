import java.util.Arrays;
import java.util.List;

public class Poison implements Element {

    @Override
    public String getName() {
        return "Poison";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Poison is strong against these types
        return Arrays.asList(new Grass(), new Fairy());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Poison is weak against these types
        return Arrays.asList(new Poison(), new Ground(), new Rock(), new Ghost());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Poison Pokémon
        return Arrays.asList(new Grass(), new Fighting(), new Poison(), new Bug(), new Fairy());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Poison Pokémon
        return Arrays.asList(new Ground(), new Psychic());
    }
}
