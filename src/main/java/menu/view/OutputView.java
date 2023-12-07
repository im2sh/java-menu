package menu.view;

import static menu.view.Printer.*;
import static menu.view.constants.ViewMessage.START_MESSAGE;

public class OutputView {
    public static void printErrorMessage(IllegalArgumentException e) {
        print(e.getMessage());
    }

    public static void printNewLine() {
        print("");
    }

    public static void printStartMessage() {
        print(START_MESSAGE.getMessage());
    }
}
