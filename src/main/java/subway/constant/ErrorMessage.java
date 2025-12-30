package subway.constant;

public enum ErrorMessage {

    NUMBER_FORMAT_ERROR("숫자를 입려해야 합니다."),

    INVALID_OPTION("선택할 수 없는 기능입니다."),

    STATION_NAME_SIZE_ERROR("역 이름은 2글자 이상이어야 합니다."),
    ALREADY_EXIST_STATION("이미 등록된 역 이름입니다."),
    NO_EXIST_STATION("존재하지 않는 역입니다."),
    STATION_FORMAT_ERROR("역 이름은 \"역\"으로 끝나야 합니다."),
    IMPOSSIBLE_DELETE_STATION("노선에 등록된 역은 삭제할 수 없습니다."),

    LINE_NAME_SIZE_ERROR("노선 이름은 2글자 이상이어야 합니다."),
    ALREADY_EXIST_LINE("이미 등록된 노선 이름입니다"),
    NO_EXIST_LINE("존재하지 않는 노선입니다."),
    LINE_FORMAT_ERROR("노선 이름은 \"선\"으로 끝나야 합니다."),
    ALREADY_EXIST_STATION_IN_LINE("해당 노선에 이미 존재하는 역입니다."), 
    
    INDEX_FORMAT_ERROR("1 이상의 숫자를 입력해야합니다."),
    MAX_INDEX_ERROR("%d 이하의 순서를 입력해야합니다."),
    IMPOSSIBLE_DELETE_SECTION("해당 노선의 역은 더이상 삭제할 수 없습니다."),
    NO_EXIST_STATION_IN_LINE("해당 노선에 존재하지 않는 역입니다.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return ERROR_MESSAGE_PREFIX + String.format(errorMessage, args);
    }
}
