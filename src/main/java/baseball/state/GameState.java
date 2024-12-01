package baseball.state;

import baseball.game.GameController;

public interface GameState {
    final Integer NUMBER_LENGTH = 3;
    final int THREE_STRIKE = 3;
    final String RETRY = "1";
    final String ENDING = "2";

    void handle(GameController game);
    boolean isState();
}
