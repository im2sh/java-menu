package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectedCoachFood {
    private final int week;
    private final String Category;
    private List<WeekCoachFood> weekCoachesFoods;

    public SelectedCoachFood(int week, String category) {
        this.week = week;
        Category = category;
        weekCoachesFoods = new ArrayList<>();
    }

    public void addWeekCoachFood(WeekCoachFood weekCoachFood) {
        weekCoachesFoods.add(weekCoachFood);
    }

    public int getWeek() {
        return week;
    }

    public String getCategory() {
        return Category;
    }

    public List<WeekCoachFood> getWeekCoachesFoods() {
        return weekCoachesFoods;
    }
}
