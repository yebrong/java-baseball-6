package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INPUT_MESSAGE = "숫자를 입력해 주세요: ";
    private final static String INPUT_GAME_STATE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static String inputNumbers() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine().strip();
    }

    public static String inputGameState() {
        System.out.println(INPUT_GAME_STATE);
        return Console.readLine().strip();
    }
}
