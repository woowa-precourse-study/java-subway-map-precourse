package subway.command.main;

import java.util.Arrays;
import subway.constant.ErrorMessage;

public enum MainMenuOption {
    A("1"),
    B("2"),
    C("3"),
    D("4"),
    QUIT("Q");

    private final String code;

    MainMenuOption(String code) {
        this.code = code;
    }

    public static MainMenuOption from(String command) {
        String normalized = command.trim();
        return Arrays.stream(values())
                .filter(opt -> opt.code.equals(normalized))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_OPTION.getErrorMessage()));
    }
}
