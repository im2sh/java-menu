package menu.view.constants;

public enum ViewMessage {
    START_MESSAGE("점심 메뉴 추천을 시작합니다."),
    INPUT_COACH_MESSAGE("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_DISLIKE_MENUS_MESSAGE("%s(이)가 못 먹는 메뉴를 입력해 주세요.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}