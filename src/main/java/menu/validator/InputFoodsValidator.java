package menu.validator;

import static menu.constants.Common.*;
import static menu.exception.GlobalException.*;

import java.util.Arrays;
import menu.domain.Categories;
import menu.domain.Foods;
import menu.exception.GlobalException;
import menu.utils.Parser;

public class InputFoodsValidator {
    public static Foods validateInputMenu(String inputFoods) {
        String[] parsedFoods = inputFoods.split(COMMA.getCommon());
        validateMenuKorean(parsedFoods);
        validateDuplicateMenu(parsedFoods);
        validateMenuSize(parsedFoods);
        validateFoodExists(parsedFoods);
        return Parser.parserFood(parsedFoods);
    }

    private static void validateMenuKorean(String[] parsedFoods) {
        for (String food : parsedFoods) {
            if (!food.matches(regex.getCommon())) {
                throw new IllegalArgumentException(INPUT_KOREAN.getErrorMessage());
            }
        }
    }

    private static void validateDuplicateMenu(String[] parsedFoods) {
        if (Arrays.stream(parsedFoods)
                .distinct()
                .count() != parsedFoods.length) {
            throw new IllegalArgumentException(DUPLICATE.getErrorMessage());
        }
    }

    private static void validateMenuSize(String[] parsedFoods) {
        if(parsedFoods.length > 2) {
            throw new IllegalArgumentException(MENU_SIZE.getErrorMessage());
        }
    }

    private static void validateFoodExists(String[] parsedFoods){
        for(String food : parsedFoods){
            if(food.equals("")){
                continue;
            }
            boolean isCategoryValid = Categories.stream()
                    .anyMatch(category -> category.getFoods().contains(food));

            if (!isCategoryValid) {
                throw new IllegalArgumentException(GlobalException.INVALID_FOOD.getErrorMessage());
            }
        }
    }
}
