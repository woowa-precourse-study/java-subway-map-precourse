package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.constant.ErrorMessage;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_STATION.getErrorMessage());
        }
        stations.add(station);
    }

    public static void deleteStation(Station deleteStation) {
        if (RouteRepository.contains(deleteStation)) {
            throw new IllegalArgumentException(ErrorMessage.IMPOSSIBLE_DELETE_STATION.getErrorMessage());
        }

        stations.removeIf(station -> station.equals(deleteStation));
    }

    public static Station getStation(String stationName) {
        return stations.stream()
                .filter(station -> station.name().equals(stationName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NO_EXIST_STATION.getErrorMessage()));
    }
}
