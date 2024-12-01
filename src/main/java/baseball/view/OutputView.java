package baseball.view;

public class OutputView {
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "%d스트라이크\n";
    private static final String BALL = "%d볼\n";
    private static final String BALL_AND_STRIKE = "%d볼 %d스트라이크\n";
    private static final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String START_MESSAGE ="숫자 야구를 시작합니다.";
    private static final String END_MESSAGE = "게임을 종료합니다.";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }
    public static void printEndMessage() {
        System.out.println(END_MESSAGE);
    }
    public static void printWinningMessage() {
        System.out.println(WINNING_MESSAGE);
    }
    public static void printNothing() {
        System.out.println(NOTHING);
    }
    public static void printStrike(int count) {
        System.out.printf(STRIKE, count);
    }
    public static void printBall(int count) {
        System.out.printf(BALL, count);
    }
    public static void printStrikeAndBall(int strikes, int balls){
        System.out.printf(BALL_AND_STRIKE, balls, strikes);
    }
}
