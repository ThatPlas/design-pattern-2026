package fr.fges;

/**
 * Immutable board game description.
 *
 * @param title game title
 * @param minPlayers minimum number of players
 * @param maxPlayers maximum number of players
 * @param category game category label
 */
public record BoardGame(
        String title,
        int minPlayers,
        int maxPlayers,
        String category
) {
}
