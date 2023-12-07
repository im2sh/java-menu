package menu.constants;

public enum Common {
    ERROR("[ERROR]"),
    COMMA(","),
    regex("^[가-힣]*$");
    private final String common;

    Common(String common) {
        this.common = common;
    }

    public String getCommon() {
        return common;
    }
}
