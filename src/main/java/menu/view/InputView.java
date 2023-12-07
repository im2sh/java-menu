package menu.view;

import static java.lang.String.format;
import static menu.view.constants.ViewMessage.INPUT_COACH_MESSAGE;
import static menu.view.constants.ViewMessage.INPUT_DISLIKE_MENUS_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String InputCoach() {
        Printer.print(INPUT_COACH_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String InputDislikeMenus(String coachName) {
        Printer.print(format(INPUT_DISLIKE_MENUS_MESSAGE.getMessage(), coachName));
        return Console.readLine();
    }
}
