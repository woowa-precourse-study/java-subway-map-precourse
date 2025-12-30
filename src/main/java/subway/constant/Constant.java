package subway.constant;

public enum Constant {

    STATION("지하철 역"),
    LINE("지하철 노선"),
    SECTION("구간"),
    ;

    private final String message;

    Constant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
