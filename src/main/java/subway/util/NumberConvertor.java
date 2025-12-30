package subway.util;

import subway.constant.ErrorMessage;

public final class NumberConvertor {

    public static Integer convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR.getErrorMessage());
        }
    }
}
