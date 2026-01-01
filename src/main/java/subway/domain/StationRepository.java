package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        validateUniqueStation(station);
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        validateStation(name);
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static List<Station> getStationInfo() {
        return stations;
    }

    private static void validateUniqueStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 역은 등록할 수 없습니다.");
        }
    }

    public static void validateStation(String name) {
        for (Station station : stations) {
            if (station.getName().equals(name)) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
    }
}
