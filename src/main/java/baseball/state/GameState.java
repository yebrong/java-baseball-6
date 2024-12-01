package baseball.state;

import baseball.game.GameContext;

public interface GameState {
    void handle(GameContext game);
    boolean isState();
}
