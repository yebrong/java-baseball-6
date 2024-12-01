package baseball;

import baseball.game.Game;
import baseball.game.GameController;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        GameController gameController = new GameController(game);
        gameController.run();
    }
}
