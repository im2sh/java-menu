package menu.view;

import static menu.view.Printer.print;
import static menu.view.constants.ViewMessage.LAST_MESSAGE;
import static menu.view.constants.ViewMessage.RESULT_MESSAGE;
import static menu.view.constants.ViewMessage.START_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.SelectedCoachFood;
import menu.domain.WeekCoachFood;

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

    public static void printRecommendMenus(List<SelectedCoachFood> recommendMenus) {
        print(RESULT_MESSAGE.getMessage());
        printWeek();
        printCategory(recommendMenus);
        printCoachAndFood(recommendMenus);
        print(LAST_MESSAGE.getMessage());
    }

    private static void printWeek() {
        System.out.print("[ 구분 | ");
        for (int i = 0; i < 5; i++) {
            System.out.print(getDayOfWeek(i));
            if (i < 4) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }

    private static void printCategory(List<SelectedCoachFood> recommendMenus) {
        System.out.print("[ 카테고리 | ");
        for (SelectedCoachFood selectedCoachFood : recommendMenus) {
            System.out.print(selectedCoachFood.getCategory());
            if (recommendMenus.indexOf(selectedCoachFood) < recommendMenus.size() - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println(" ]");
    }

    private static void printCoachAndFood(List<SelectedCoachFood> recommendMenus) {
        List<Coach> distinctCoaches = getDistinctCoaches(recommendMenus);

        for (int i = 0; i < distinctCoaches.size(); i++) {
            Coach coach = distinctCoaches.get(i);
            System.out.print("[ " + coach.getName() + " | ");
            for (int j = 0; j < recommendMenus.size(); j++) {
                System.out.print(getFoodForCoach(recommendMenus.get(j), coach));
                if (j < recommendMenus.size() - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println(" ]");
        }
    }

    private static String getDayOfWeek(int day) {
        String[] daysOfWeek = {"월요일", "화요일", "수요일", "목요일", "금요일"};
        return daysOfWeek[day];
    }

    private static List<Coach> getDistinctCoaches(List<SelectedCoachFood> selectedCoachFoods) {
        return selectedCoachFoods.stream()
                .flatMap(selectedCoachFood -> selectedCoachFood.getWeekCoachesFoods().stream())
                .map(WeekCoachFood::getCoach)
                .distinct()
                .collect(Collectors.toList());
    }

    private static String getFoodForCoach(SelectedCoachFood selectedCoachFood, Coach coach) {
        return selectedCoachFood.getWeekCoachesFoods().stream()
                .filter(weekCoachFood -> weekCoachFood.getCoach().equals(coach))
                .findFirst()
                .map(weekCoachFood -> weekCoachFood.getFood().getName())
                .orElse("");
    }

}
