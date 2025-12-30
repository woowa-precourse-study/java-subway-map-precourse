package subway.domain;

import java.util.Objects;
import subway.constant.ErrorMessage;

public record Station(String name) {

    public static Station from(String name) {
        validate(name);
        return new Station(name);
    }

    private static void validate(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(ErrorMessage.STATION_NAME_SIZE_ERROR.getErrorMessage());
        }
    }

    // 추가 기능 구현

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Station station = (Station) object;
        return Objects.equals(name, station.name);
    }

}
