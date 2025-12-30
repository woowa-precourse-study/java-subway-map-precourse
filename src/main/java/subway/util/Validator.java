package subway.util;

import subway.constant.ErrorMessage;

public final class Validator {

    private static final String NUMBER_FORMAT = "\\d+";
    private static final String STATION_FORMAT = ".*역$";
    private static final String LINE_FORMAT = ".*선$";

    private Validator() {
    }

    public static void validateStationFormat(String station) {
        if (!station.matches(STATION_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.STATION_FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void validateLineFormat(String line) {
        if (!line.matches(LINE_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.LINE_FORMAT_ERROR.getErrorMessage());
        }
    }

    public static void validateIndexFormat(String readIndex) {
        if (readIndex.matches("0") || !readIndex.matches(NUMBER_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.INDEX_FORMAT_ERROR.getErrorMessage());
        }
    }
}
