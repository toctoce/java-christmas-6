package christmas.common;

public enum ErrorMessage {
    INVALID_NICKNAME("닉네임은 1~5글자이어야 합니다. (%s)", true),
    INVALID_INPUT("입력이 잘못되었습니다.");

    private final String message;
    private final boolean isFormatted;

    private ErrorMessage(String message) {
        this.message = message;
        this.isFormatted = false;
    }

    private ErrorMessage(String message, boolean isFormatted) {
        this.message = message;
        this.isFormatted = isFormatted;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessage(String... arguments) {
        return this.isFormatted ? String.format(this.message, arguments) : this.message;
    }
}
