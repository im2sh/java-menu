package menu.domain;

import java.util.HashMap;
import java.util.Map;

public class CoachFood {
    private Map<Coach, Foods> coachFoods;

    public CoachFood() {
        coachFoods = new HashMap<>();
    }

    public void addCoachFood(Coach coach, Foods foods) {
        coachFoods.put(coach, foods);
    }
}
