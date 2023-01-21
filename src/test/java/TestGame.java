import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGame {
    Game game = new Game();

    @Test
    public void thePlayerIsStrongerThanTheSecond() {
        Player player1 = new Player(1, "Mick", 50);
        Player player2 = new Player(2, "Corey", 30);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Mick", "Corey");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void theSecondPlayerIsStrongerThanTheFirst() {
        Player player1 = new Player(1, "Mick", 30);
        Player player2 = new Player(2, "Corey", 50);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Mick", "Corey");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void tieBetweenPlayers() {
        Player player1 = new Player(1, "Mick", 50);
        Player player2 = new Player(2, "Corey", 50);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Mick", "Corey");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerDoesNotExist() {
        Player player1 = new Player(1, "Mick", 50);
        Player player2 = new Player(2, "Corey", 50);

        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotFoundException.class,
                () -> game.round("Mick", "Joey"));
    }

    @Test
    public void playerDoesNotExistTwo() {
        Player player1 = new Player(1, "Mick", 50);
        Player player2 = new Player(2, "Corey", 50);

        game.register(player1);
        game.register(player2);


        Assertions.assertThrows(NotFoundException.class,
                () -> game.round("Natan", "Corey"));
    }

}
