package menu;

import menu.controller.MenuRecommendController;
import menu.service.CoachService;
import menu.service.FoodService;
import menu.service.RecommendService;

public class Application {
    public static void main(String[] args) {
        RecommendService recommendService = new RecommendService();
        MenuRecommendController menuRecommendController = new MenuRecommendController(recommendService);
        menuRecommendController.run();
    }
}
