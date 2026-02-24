package fr.fges;

import java.util.List;

public interface GameRepository {

    /**
     * Saves a list of board games to the specified file.
     *
     * @param object the list of games to save
     * @return true if save was successful, false otherwise
     */
    boolean save(List<BoardGame> object);
    /**
     * Loads board games from the specified file.
     *
     * @return list of loaded games
     */
    List<BoardGame> load();

}
