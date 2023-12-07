package menu.controller;

import static menu.view.InputView.*;
import static menu.view.OutputView.*;

import java.util.List;
import menu.domain.Coach;
import menu.domain.CoachFood;
import menu.domain.Coaches;
import menu.domain.Foods;
import menu.exception.GlobalRetryHandler;
import menu.service.CoachService;
import menu.service.FoodService;
import menu.service.RecommendService;
import menu.validator.InputCoachesValidator;
import menu.validator.InputFoodsValidator;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendController {

    private final RecommendService recommendService;

    private final GlobalRetryHandler globalRetryHandler = new GlobalRetryHandler();

    public MenuRecommendController(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    public void run() {
        printStartMessage();
        Coaches coaches = getCoaches();
        CoachFood coachMenus = getCoachMenus(coaches);
    }

    private Coaches getCoaches(){
        return globalRetryHandler.getOrRetry(this::inputCoaches);
    }

    private Coaches inputCoaches() {
        String inputCoaches = InputCoach();
        return InputCoachesValidator.validateCoaches(inputCoaches);
    }

    private CoachFood getCoachMenus(Coaches coaches) {
        CoachFood coachFood = new CoachFood();
        for(Coach coach : coaches.getCoaches()) {
            Foods foods = globalRetryHandler.getOrRetry(() -> inputFoods(coach));
            coachFood.addCoachFood(coach, foods);
        }
        return coachFood;
    }

    private Foods inputFoods(Coach coach){
        String inputFoods = InputDislikeMenus(coach.getName());
        Foods foods = InputFoodsValidator.validateInputMenu(inputFoods);
        return foods;
    }

}
