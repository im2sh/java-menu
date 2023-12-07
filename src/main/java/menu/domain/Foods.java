package menu.domain;

import java.util.List;

public class Foods {
    private final List<Food> foods;

    public Foods(List<Food> foods) {
        this.foods = foods;
    }

    public List<Food> getFoods() {
        return foods;
    }
}
