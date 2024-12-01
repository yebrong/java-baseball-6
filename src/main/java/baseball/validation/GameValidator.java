package baseball.validation;

import java.util.HashSet;
import java.util.Set;

public class GameValidator {

    private static final String USER_INPUT_LENGTH_ERROR_MESSAGE = "입력은 3자리 숫자여야 합니다.";
    private static final String USER_INPUT_FORMAT_ERROR_MESSAGE = "입력은 숫자만 포함해야 합니다.";
    private static final String USER_INPUT_DUPLICATE_ERROR_MESSAGE = "입력은 서로 다른 숫자로 이루어져야 합니다.";
    private static final String GAME_RESTART_INPUT_ERROR_MESSAGE = "재시작/종료 입력은 1 또는 2여야 합니다.";

    public static void validateUserInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException(USER_INPUT_LENGTH_ERROR_MESSAGE);
        }
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(USER_INPUT_FORMAT_ERROR_MESSAGE);
        }
        if (hasDuplicateDigits(input)) {
            throw new IllegalArgumentException(USER_INPUT_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validateGameRestartInput(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException(GAME_RESTART_INPUT_ERROR_MESSAGE);
        }
    }

    private static boolean hasDuplicateDigits(String input) {
        Set<Character> inputSet = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (!inputSet.add(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
