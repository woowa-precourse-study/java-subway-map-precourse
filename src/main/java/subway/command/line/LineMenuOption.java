package subway.command.line;

import java.util.Arrays;
import subway.constant.ErrorMessage;

public enum LineMenuOption {
    A("1"),
    B("2"),
    C("3"),
    BACK("B");

    private final String code;

    LineMenuOption(String code) {
        this.code = code;
    }

    public static LineMenuOption from(String command) {
        String normalized = command.trim();
        return Arrays.stream(values())
                .filter(opt -> opt.code.equals(normalized))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_OPTION.getErrorMessage()));
    }
}
