package menu.view;

import static menu.view.Printer.*;

public class OutputView {
    public void printErrorMessage(IllegalArgumentException e) {
        print(e.getMessage());
    }

    public void printNewLine() {
        print("");
    }
}
