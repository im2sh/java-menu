package menu.controller;

import static menu.view.InputView.InputCoach;
import static menu.view.InputView.InputDislikeMenus;
import static menu.view.OutputView.printStartMessage;

import java.util.List;
import menu.domain.Coach;
import menu.domain.CoachUnbalancedFood;
import menu.domain.Coaches;
import menu.domain.Foods;
import menu.domain.SelectedCoachFood;
import menu.exception.GlobalRetryHandler;
import menu.service.RecommendService;
import menu.validator.InputCoachesValidator;
import menu.validator.InputFoodsValidator;
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
        CoachUnbalancedFood coachMenus = getCoachMenus(coaches);
        List<SelectedCoachFood> recommendMenus = recommendService.recommend(coachMenus);
        printResult(recommendMenus);
    }

    private Coaches getCoaches() {
        return globalRetryHandler.getOrRetry(this::inputCoaches);
    }

    private Coaches inputCoaches() {
        String inputCoaches = InputCoach();
        return InputCoachesValidator.validateCoaches(inputCoaches);
    }

    private CoachUnbalancedFood getCoachMenus(Coaches coaches) {
        CoachUnbalancedFood coachUnbalancedFood = new CoachUnbalancedFood();
        for (Coach coach : coaches.getCoaches()) {
            Foods foods = globalRetryHandler.getOrRetry(() -> inputFoods(coach));
            coachUnbalancedFood.addCoachFood(coach, foods);
        }
        return coachUnbalancedFood;
    }

    private Foods inputFoods(Coach coach) {
        String inputFoods = InputDislikeMenus(coach.getName());
        Foods foods = InputFoodsValidator.validateInputMenu(inputFoods);
        return foods;
    }

    private void printResult(List<SelectedCoachFood> recommendMenus) {
        OutputView.printRecommendMenus(recommendMenus);

    }

}
