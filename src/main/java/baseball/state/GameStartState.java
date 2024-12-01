package baseball.state;

import baseball.game.Game;
import baseball.game.GameController;
import baseball.validation.GameValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameStartState implements GameState {
    private static final GameStartState INSTANCE = new GameStartState();


    private GameStartState() {}

    public static GameStartState getInstance() {
        return INSTANCE;
    }

    @Override
    public void handle(GameController gameContext) {
        OutputView.printStartMessage();
        Game game = gameContext.getGame();
        do {
            String input = gameContext.initialize();
            game.calculateTotalScore(input);
            gameContext.printResult(input);
        } while (game.getTotalStrike() != THREE_STRIKE);

        OutputView.printWinningMessage();

        String gameResult = InputView.inputGameState();
        GameValidator.validateGameRestartInput(gameResult);

        if (gameResult.equals(RETRY)) {
            game.resetGame();
            gameContext.setState(GameStartState.getInstance());
            gameContext.run();
        }
        if (gameResult.equals(ENDING)) {
            gameContext.setState(GameOverState.getInstance());
        }
    }

    @Override
    public boolean isState() {
        return true;
    }
}
