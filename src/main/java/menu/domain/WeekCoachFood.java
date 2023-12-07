package menu.domain;

public class WeekCoachFood {
    private Coach coach;
    private Food food;

    public WeekCoachFood(Coach coach, Food food) {
        this.coach = coach;
        this.food = food;
    }

    public Coach getCoach() {
        return coach;
    }

    public Food getFood() {
        return food;
    }

}
