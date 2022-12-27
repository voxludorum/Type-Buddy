import java.util.List;

public interface Element {

    String getName();
    List<Element> getStrongAtk(); // "... Moves are super-efficient against: "
    List<Element> getWeakAtk(); // "... Moves are not very efficient against: "
    List<Element> getStrongDef(); // "These types are not very effective against ... Pokémon: "
    List<Element> getWeakDef(); // "These types are super-effective against ... Pokémon: "
    List<Element> getNoDamage(); // "... Moves have no effect on: "
    List<Element> getImmune(); // "These types have no effect on ... Pokémon: "

    // TODO: 12/18/2022
    // Add two new method calls:
    // Moves that have no effect (i.e Electric moves on Ground type)
    // Immunity to moves (i.e Ground types vs Electric moves)
}
