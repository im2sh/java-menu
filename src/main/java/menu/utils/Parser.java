package menu.utils;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Food;
import menu.domain.Foods;

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

    public static Foods parserFood(String[] inputFoods) {
        List<Food> parsedFoods = new ArrayList<>();
        for(String parsedFood : inputFoods){
            Food food = new Food(parsedFood);
            parsedFoods.add(food);
        }
        Foods foods = new Foods(parsedFoods);
        return foods;
    }
}
