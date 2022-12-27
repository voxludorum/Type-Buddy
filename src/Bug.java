import java.util.Arrays;
import java.util.List;

public class Bug implements Element {

    @Override
    public String getName() {
        return "Bug";
    }

    @Override
    public List<Element> getStrongAtk() {
        // Bug is strong against these types
        return Arrays.asList(new Grass(), new Psychic(), new Dark());
    }

    @Override
    public List<Element> getWeakAtk() {
        // Bug is weak against these types
        return Arrays.asList(new Fire(), new Fighting(), new Poison(), new Flying(), new Ghost(), new Steel(), new Fairy());
    }

    public List<Element> getStrongDef() {
        // These types are weak against Bug Pokemon
        return Arrays.asList(new Grass(), new Fighting(), new Ground());
    }

    public List<Element> getWeakDef() {
        // These types are strong against Bug Pokemon
        return Arrays.asList(new Fire(), new Flying(), new Rock());
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
