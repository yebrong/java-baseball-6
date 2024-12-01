package baseball.state;

import baseball.game.GameContext;
import baseball.validation.GameValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameStartState implements GameState {
    private static final GameStartState INSTANCE = new GameStartState();

    private GameStartState() {}

    public static GameStartState getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(GameContext game) {
        OutputView.printStartMessage();
        do {
            String input = game.initialize();
            game.calculateTotalScore(input);
        } while (game.getTotalStrike() != 3);

        OutputView.printWinningMessage();

        String gameResult = InputView.inputGameState();
        GameValidator.validateGameRestartInput(gameResult);

        if (gameResult.equals("1")) {
            game.resetGame();
            game.setState(GameStartState.getInstance());
            game.run();
        }
        if (gameResult.equals("2")) {
            game.setState(GameOverState.getInstance());
        }
    }

    @Override
    public boolean isState() {
        return true;
    }
}
