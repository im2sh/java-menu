package menu.domain;

import java.util.HashMap;
import java.util.Map;

public class CoachUnbalancedFood {
    private Map<Coach, Foods> coachFoods;

    public CoachUnbalancedFood() {
        coachFoods = new HashMap<>();
    }

    public void addCoachFood(Coach coach, Foods foods) {
        coachFoods.put(coach, foods);
    }

    public Map<Coach, Foods> getCoachFoods() {
        return coachFoods;
    }
}
