package subway.command.section;

import java.util.Arrays;
import subway.constant.ErrorMessage;

public enum SectionMenuOption {
    A("1"),
    B("2"),
    BACK("B");

    private final String code;

    SectionMenuOption(String code) {
        this.code = code;
    }

    public static SectionMenuOption from(String command) {
        String normalized = command.trim();
        return Arrays.stream(values())
                .filter(opt -> opt.code.equals(normalized))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_OPTION.getErrorMessage()));
    }
}
