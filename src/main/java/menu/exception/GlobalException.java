package menu.exception;

public enum GlobalException {
    ;
    private final String errorMessage;

    GlobalException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
