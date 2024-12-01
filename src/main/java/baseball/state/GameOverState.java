package baseball.state;

import baseball.game.GameContext;
import baseball.view.OutputView;

public class GameOverState implements GameState {
    private static final GameOverState INSTANCE = new GameOverState();

    private GameOverState() {}
    public static GameOverState getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(GameContext gameContext) {
        OutputView.printEndMessage();
    }

    @Override
    public boolean isState() {
        return false;
    }
}
