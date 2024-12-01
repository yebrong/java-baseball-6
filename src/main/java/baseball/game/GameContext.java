package baseball.game;

import baseball.state.GameStartState;
import baseball.state.GameState;
import baseball.validation.GameValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameContext {
    private Integer totalStrike;
    private Integer totalBall;
    private GameState currentState;
    private List<Integer> computerNumbers;

    public GameContext() {
        this.currentState = GameStartState.getInstance();
        this.computerNumbers = generateComputerNumbers();
    }

    private List<Integer> generateComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public void setState(GameState state) {
        this.currentState = state;
    }

    public void run() {
        while (currentState.isState()) {
            currentState.handle(this);
        }
    }


    public void resetGame() {
        this.computerNumbers = generateComputerNumbers();
    }


    public String initialize() {
        String input = InputView.inputNumbers();
        GameValidator.validateUserInput(input);
        return input;
    }

    public Integer getTotalStrike() {
        return totalStrike;
    }

    public void calculateTotalScore(String input) {
        totalStrike = 0;
        totalBall = 0;

        for (int i = 0; i < 3; i++) {
            int digit = input.charAt(i) - '0';
            if (computerNumbers.get(i) == digit) {
                totalStrike++;
            }
        }

        for (int i = 0; i < 3; i++) {
            int digit = input.charAt(i) - '0';
            if (computerNumbers.get(i) != digit && computerNumbers.contains(digit)) {
                totalBall++;
            }
        }

        printResult(totalStrike, totalBall);
    }

    public void printResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            OutputView.printNothing();
        }
        if (strikes == 0 && balls > 0) {
            OutputView.printBall(balls);
        }
        if (strikes > 0 && balls > 0) {
            OutputView.printStrikeAndBall(strikes, balls);
        }
        if (strikes > 0 && balls == 0) {
            OutputView.printStrike(strikes);
        }
    }



}
