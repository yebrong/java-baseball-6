package baseball.game;

import baseball.state.GameStartState;
import baseball.state.GameState;
import baseball.validation.GameValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private GameState currentState;
    private Game game;



    private GameController() {}

    public GameController(Game game) {
        this.currentState = GameStartState.getInstance();
        this.game = game;
    }

    public void setState(GameState state) {
        this.currentState = state;
    }

    public void run() {
        while (currentState.isState()) {
            currentState.handle(this);
        }
    }

    public String initialize() {
        String input = InputView.inputNumbers();
        GameValidator.validateUserInput(input);
        System.out.println(input);
        return input;
    }


    public void printResult(String input) {
        game.calculateTotalScore(input);
        int strikes = game.getTotalStrike();
        int balls = game.getTotalBall();
        if (strikes == Game.INITIAL_NUMBER && balls == Game.INITIAL_NUMBER) {
            OutputView.printNothing();
        }
        if (strikes == Game.INITIAL_NUMBER && balls > Game.INITIAL_NUMBER) {
            OutputView.printBall(balls);
        }
        if (strikes > Game.INITIAL_NUMBER && balls > Game.INITIAL_NUMBER) {
            OutputView.printStrikeAndBall(strikes, balls);
        }
        if (strikes > Game.INITIAL_NUMBER && balls == Game.INITIAL_NUMBER) {
            OutputView.printStrike(strikes);
        }
    }

    public Game getGame() {
        return game;
    }


}
