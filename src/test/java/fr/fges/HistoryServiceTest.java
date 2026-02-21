package fr.fges;

import fr.fges.game.GameCollection;
import fr.fges.history.History;
import fr.fges.history.HistoryService;
import fr.fges.history.actions.AddGameLog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoryServiceTest {
    @Test
    void actionTester() {
        History history = new History();
        GameCollection collection = new GameCollection();
        HistoryService historyService = new HistoryService();
        BoardGame jeuTest = new BoardGame("Azul", 2, 4, "Abstract");

        AddGameLog logging = new AddGameLog(collection, jeuTest);

        historyService.addLogAction(history, logging);
        assertEquals(logging, history.getLastAction());

        historyService.removeLogAction(history,logging);

        assertEquals(0, history.getActions().size());
    }

    @Test
     void revertLastAction(){
        GameCollection collection = new GameCollection();
        HistoryService historyService = new HistoryService();
        BoardGame jeuTest = new BoardGame("Azul", 2, 4, "Abstract");

        collection.addGame(jeuTest);
        historyService.addLogAction(collection.getHistory(), new AddGameLog(collection, jeuTest));

        historyService.revertLastAction(collection);

        assertEquals(0, collection.getGames().size());
    }
}
