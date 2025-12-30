package subway.command.station;

import java.util.Arrays;
import subway.constant.ErrorMessage;

public enum StationMenuOption {
    A("1"),
    B("2"),
    C("3"),
    BACK("B");

    private final String code;

    StationMenuOption(String code) {
        this.code = code;
    }

    public static StationMenuOption from(String command) {
        String normalized = command.trim();
        return Arrays.stream(values())
                .filter(opt -> opt.code.equals(normalized))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_OPTION.getErrorMessage()));
    }
}
