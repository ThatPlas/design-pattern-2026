package fr.fges;

import java.util.List;

public interface Repository {

    /**
     * Saves a list of board games to the specified file.
     *
     * @param object the list of games to save
     * @param file the file path to save to
     * @return true if save was successful, false otherwise
     */
    boolean save(List<BoardGame> object, String file);
    /**
     * Loads board games from the specified file.
     *
     * @param file the file path to load from
     * @return list of loaded games
     */
    List<BoardGame> load(String file);

}
