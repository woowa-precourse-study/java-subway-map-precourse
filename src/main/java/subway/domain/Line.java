package subway.domain;

import java.util.Objects;
import subway.constant.ErrorMessage;

public record Line(String name) {

    public static Line from(String name) {
        validate(name);
        return new Line(name);
    }

    private static void validate(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(ErrorMessage.LINE_NAME_SIZE_ERROR.getErrorMessage());
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Line line = (Line) object;
        return Objects.equals(name, line.name);
    }

}
