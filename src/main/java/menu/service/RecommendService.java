package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Categories;
import menu.domain.Coach;
import menu.domain.Food;
import menu.domain.SelectedCoachFood;
import menu.domain.WeekCoachFood;
import menu.domain.CoachUnbalancedFood;
import menu.domain.Foods;
import menu.repository.SelectedCoachFoodRepository;

public class RecommendService {
    private Map<String, Integer> categoryCount;
    private List<String> weekCategory;
    private List<SelectedCoachFood> selectedCoachFoods;

    private SelectedCoachFoodRepository selectedCoachFoodRepository;

    public RecommendService() {
        categoryCount = new HashMap<>();
        weekCategory = new ArrayList<>();
        selectedCoachFoods = new ArrayList<>();
        selectedCoachFoodRepository = new SelectedCoachFoodRepository();
    }

    public List<SelectedCoachFood> recommend(CoachUnbalancedFood coachUnbalancedFood) {
        for(int day = 0; day < 5; day++){
            String category = getCategory();
            SelectedCoachFood selectedCoachFood = selectFood(day, coachUnbalancedFood, category);
            selectedCoachFoods.add(selectedCoachFood);
        }
        return selectedCoachFoods;
    }

    private SelectedCoachFood selectFood(int day, CoachUnbalancedFood coachUnbalancedFood, String category) {
        Map<Coach, Foods> unbalancedCoachesAndFoods = coachUnbalancedFood.getCoachFoods();
        SelectedCoachFood selectedCoachFood = new SelectedCoachFood(day, category);
        unbalancedCoachesAndFoods.forEach((coach, foods) -> {
            Food food = oneCoachRecommend(coach, foods, category);
            WeekCoachFood weekCoachFood = new WeekCoachFood(coach, food);
            selectedCoachFood.addWeekCoachFood(weekCoachFood);
            selectedCoachFoodRepository.addCoachFood(coach, food);
        });
        return selectedCoachFood;
    }

    private Food oneCoachRecommend(Coach coach, Foods foods, String category){
        String unbalancedFood;
        do{
            unbalancedFood = getUnbalancedFood(category);
        } while(isDuplicateFood(coach, unbalancedFood) || isUnbalancedFood(foods, unbalancedFood));
        return new Food(unbalancedFood);
    }


    private boolean isDuplicateFood(Coach coach, String unbalancedFood){
        Food food = new Food(unbalancedFood);
        if(selectedCoachFoodRepository.isFoodSelected(coach, food)){
            return true;
        }
        return false;
    }

    private boolean isUnbalancedFood(Foods foods, String unbalancedFood){
        if(foods.getFoods().contains(unbalancedFood)){
            return true;
        }
        return false;
    }

    private String getUnbalancedFood(String category){
        List<String> foods = Categories.valueOf(category).getFoods();
        String menu = Randoms.shuffle(foods).get(0);
        return menu;
    }

    public String getCategory(){
        String category = "";
        do{
            category = getRandomCategory();
        } while(categoryDuplicateCheck(categoryCount, category));
        categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
        return category;
    }

    private boolean categoryDuplicateCheck(Map<String, Integer> categoryCount, String category){
        if(categoryCount.get(category) == null){
            return false;
        }
        if(categoryCount.get(category) >= 2){
            return true;
        }
        return false;
    }
    private String getRandomCategory(){
        int randomCategoryIndex = Randoms.pickNumberInRange(1, 5) - 1;
        return Categories.values()[randomCategoryIndex].name();
    }
}
