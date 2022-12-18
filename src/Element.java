import java.util.List;

public interface Element {

    String getName();
    List<Element> getStrongAtk(); // "... Moves are super-efficient against: "
    List<Element> getWeakAtk(); // "... Moves are not very efficient against: "
    List<Element> getStrongDef(); // "These types are not very effective against ... Pokemon: "
    List<Element> getWeakDef(); // "These types are super-effective against ... Pokemon: "

}
