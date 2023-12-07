package menu.exception;

import static menu.constants.Common.ERROR;

public enum GlobalException {
    COACH_SIZE("코치는 2명 이상 5명 이하로 입력해주세요."),
    COACH_LENGTH("코치 이름은 최소 2글자 이상 최대 4글자로 입력해주세요."),
    COACH_DUPLICATE("코치 이름은 중복되지 않게 입력해주세요."),
    COACH_KOREAN("코치 이름은 한글로만 입력해 주세요."),
    ;
    private final String errorMessage;

    GlobalException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR.getCommon() + errorMessage;
    }
}
