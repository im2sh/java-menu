package menu.controller;

import static menu.view.InputView.*;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.exception.GlobalRetryHandler;
import menu.service.CoachService;
import menu.service.FoodService;
import menu.service.RecommendService;
import menu.validator.InputCoachesValidator;
import menu.view.InputView;

public class MenuRecommendController {

    private final RecommendService recommendService;

    private final GlobalRetryHandler globalRetryHandler = new GlobalRetryHandler();

    public MenuRecommendController(RecommendService recommendService) {
        this.recommendService = recommendService;
    }

    public void run() {
        Coaches coaches = getCoaches();
    }

    private Coaches getCoaches(){
        return globalRetryHandler.getOrRetry(this::inputCoaches);
    }

    private Coaches inputCoaches() {
        String inputCoaches = InputCoach();
        return InputCoachesValidator.validateCoaches(inputCoaches);
    }

}
