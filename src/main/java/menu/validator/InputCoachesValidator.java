package menu.validator;

import static menu.constants.Common.COMMA;
import static menu.constants.Common.regex;
import static menu.exception.GlobalException.COACH_LENGTH;
import static menu.exception.GlobalException.COACH_SIZE;
import static menu.exception.GlobalException.DUPLICATE;
import static menu.exception.GlobalException.INPUT_KOREAN;

import java.util.Arrays;
import menu.domain.Coaches;
import menu.utils.Parser;

public class InputCoachesValidator {
    public static Coaches validateCoaches(String inputCoaches) {
        String[] parsedCoaches = inputCoaches.split(COMMA.getCommon());
        validateCoachKorean(parsedCoaches);
        validateCoachSize(parsedCoaches);
        validateCoachLength(parsedCoaches);
        validateCoachDuplicate(parsedCoaches);
        return Parser.parserCoach(parsedCoaches);
    }

    private static void validateCoachKorean(String[] parsedCoaches) {
        for (String coach : parsedCoaches) {
            if (!coach.matches(regex.getCommon())) {
                throw new IllegalArgumentException(INPUT_KOREAN.getErrorMessage());
            }
        }
    }

    private static void validateCoachSize(String[] parsedCoaches) {
        if (parsedCoaches.length < 2 || parsedCoaches.length > 5) {
            throw new IllegalArgumentException(COACH_SIZE.getErrorMessage());
        }
    }

    private static void validateCoachLength(String[] parsedCoaches) {
        for (String coach : parsedCoaches) {
            if (coach.length() > 4 || coach.length() < 2) {
                throw new IllegalArgumentException(COACH_LENGTH.getErrorMessage());
            }
        }
    }

    private static void validateCoachDuplicate(String[] parsedCoaches) {
        if (Arrays.stream(parsedCoaches)
                .distinct()
                .count() != parsedCoaches.length) {
            throw new IllegalArgumentException(DUPLICATE.getErrorMessage());
        }
    }

}
