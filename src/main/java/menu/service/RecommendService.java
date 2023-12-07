package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;
import menu.domain.Categories;
import menu.domain.CoachFood;

public class RecommendService {
    public void recommend(CoachFood coachMenus) {
        Map<String, Integer> categoryCount = new HashMap<>();
        for(int i = 0; i < 5; i++){
            String category = getCategory(categoryCount);
        }

    }

    public String getCategory(Map<String, Integer> categoryCount){
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
