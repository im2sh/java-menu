package menu.view;

import static menu.view.constants.ViewMessage.*;

import camp.nextstep.edu.missionutils.Console;
import menu.view.constants.ViewMessage;

public class InputView {

    public static String InputCoach(){
        Printer.print(INPUT_COACH_MESSAGE.getMessage());
        return Console.readLine();
    }
}
