package baseball.validation;

import baseball.state.GameState;

import java.util.HashSet;
import java.util.Set;

public class GameValidator {

    private static final String USER_INPUT_LENGTH_ERROR_MESSAGE = "입력은 3자리 숫자여야 합니다.";
    private static final String USER_INPUT_NUMBER_ERROR_MESSAGE = "입력된 숫자가 조건 범위를 벗어났습니다.";
    private static final String USER_INPUT_FORMAT_ERROR_MESSAGE = "입력은 숫자만 포함해야 합니다.";
    private static final String USER_INPUT_DUPLICATE_ERROR_MESSAGE = "입력은 서로 다른 숫자로 이루어져야 합니다.";
    private static final String GAME_RESTART_INPUT_ERROR_MESSAGE = "재시작/종료 입력은 1 또는 2여야 합니다.";

    private static final Integer MAX_NUMBER = 9;
    private static final Integer MIN_NUMBER = 1;

    public static void validateUserInput(String input) {
        validateNumberLength(input);
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(USER_INPUT_FORMAT_ERROR_MESSAGE);
        }
        hasDuplicateDigits(input);
        validateNumberRange(input);
    }

    public static void validateGameRestartInput(String input) {
        if (!input.equals(GameState.RETRY) && !input.equals(GameState.ENDING)) {
            throw new IllegalArgumentException(GAME_RESTART_INPUT_ERROR_MESSAGE);
        }
    }

    private static void validateNumberLength(String input) {
        if(input.length() != GameState.NUMBER_LENGTH)
            throw new IllegalArgumentException(USER_INPUT_LENGTH_ERROR_MESSAGE);
    }
    private static void validateNumberRange(String input) {
        for(char c : input.toCharArray()) {
            int inputNumber = c-'0';
            if(inputNumber<MIN_NUMBER || inputNumber>MAX_NUMBER) {
                throw new IllegalArgumentException(USER_INPUT_NUMBER_ERROR_MESSAGE);
            }
        }
    }

    private static void hasDuplicateDigits(String input) {
        Set<Character> inputSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (!inputSet.add(input.charAt(i))) {
                throw new IllegalArgumentException(USER_INPUT_DUPLICATE_ERROR_MESSAGE);
            }
        }
    }


}
