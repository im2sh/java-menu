package menu.utils;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;

public class Parser {

    public static Coaches parserCoach(String[] inputCoaches) {
        List<Coach> parsedCoaches = new ArrayList<>();
        for(String parsedCoach : inputCoaches){
            Coach coach = new Coach(parsedCoach);
            parsedCoaches.add(coach);
        }
        Coaches coaches = new Coaches(parsedCoaches);
        return coaches;
    }
}
