package fr.fges;

import java.util.List;

public interface Repository {

    boolean save(List<BoardGame> object, String file);
    List<BoardGame> load(String file);

}
