package baseball.game;

import java.util.List;

import java.util.ArrayList;

import baseball.state.GameState;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private List<Integer> computerNumbers;
    private int totalStrike;
    private int totalBall;
    static final Integer INITIAL_NUMBER = 0;

    public Game() {
        resetGame();
    }

    public void resetGame() {
        this.computerNumbers = generateComputerNumbers();
    }

    private List<Integer> generateComputerNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < GameState.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private void initializeTotalCount() {
        totalStrike = 0;
        totalBall = 0;
    }
    public void calculateTotalScore(String input) {
        initializeTotalCount();
        for (int i = 0; i < GameState.NUMBER_LENGTH ; i++) {
            int digit = input.charAt(i) - '0';
            if (computerNumbers.get(i) == digit) {
                totalStrike++;
            }
            if (computerNumbers.get(i) != digit && computerNumbers.contains(digit)) {
                totalBall++;
            }
        }
    }

    public Integer getTotalStrike() {
        return totalStrike;
    }

    public int getTotalBall() {
        return totalBall;
    }

}
