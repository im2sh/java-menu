package menu.repository;

import java.util.HashMap;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.Food;

public class SelectedCoachFoodRepository {
    Map<Coach, Food> coachFoods = new HashMap<>();

    public void addCoachFood(Coach coach, Food food) {
        coachFoods.put(coach, food);
    }

    public boolean isFoodSelected(Coach coach, Food food) {
        Food selectedFood = coachFoods.get(coach);
        if (selectedFood == null) {
            return false;
        }

        return selectedFood.equals(food);
    }
}
