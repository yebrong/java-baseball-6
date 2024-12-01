package baseball;

import baseball.game.GameContext;

public class Application {
    public static void main(String[] args) {
        GameContext gameContext = new GameContext();
        gameContext.run();
    }
}
