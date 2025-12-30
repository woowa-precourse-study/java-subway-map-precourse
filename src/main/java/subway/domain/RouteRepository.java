package subway.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import subway.constant.ErrorMessage;

public class RouteRepository {

    private static final Map<Line, List<Station>> routes = new LinkedHashMap<>();

    public static void addStations(Line line, List<Station> stations) {
        if (routes.containsKey(line)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_LINE.getErrorMessage());
        }
        routes.put(line, stations);
    }

    public static void addLine(Line line) {
        if (routes.containsKey(line)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_LINE.getErrorMessage());
        }
        routes.put(line, new ArrayList<>());
    }

    public static boolean contains(Station station) {
        for (List<Station> value : routes.values()) {
            if (value.contains(station)) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(Line line) {
        return routes.containsKey(line);
    }

    public static boolean contains(Line line, Station station) {
        return routes.get(line).contains(station);
    }

    public static void addStation(Line line, Station station) {
        List<Station> stations = routes.get(line);
        if (stations.contains(station)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_STATION_IN_LINE.getErrorMessage());
        }
        stations.add(station);
    }

    public static void addStation(Line line, Station station, int index) {
        List<Station> stations = routes.get(line);

        if (index > stations.size() + 1) {
            throw new IllegalArgumentException(ErrorMessage.MAX_INDEX_ERROR.getErrorMessage(stations.size() + 1));
        }

        if (stations.contains(station)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_STATION_IN_LINE.getErrorMessage());
        }

        stations.add(index - 1, station);
    }

    public static void deleteLine(Line line) {
        Set<Line> lines = routes.keySet();
        if (!lines.contains(line)) {
            throw new IllegalArgumentException(ErrorMessage.NO_EXIST_LINE.getErrorMessage());
        }
        routes.remove(line);
    }

    public static void validateDeleteLine(Line line) {
        List<Station> stations = routes.get(line);
        if (stations.size()<=2) {
            throw new IllegalArgumentException(ErrorMessage.IMPOSSIBLE_DELETE_SECTION.getErrorMessage());
        }
    }

    public static void deleteSection(Line line, Station station) {
        List<Station> stations = routes.get(line);
        if (!stations.contains(station)) {
            throw new IllegalArgumentException(ErrorMessage.NO_EXIST_STATION_IN_LINE.getErrorMessage());
        }
        stations.remove(station);
    }

    public static Map<String, List<String>> getRoutes() {
        Map<String, List<String>> resultRoutes = new LinkedHashMap<>();
        for (Line line : routes.keySet()) {
            List<String> stations = routes.get(line).stream()
                    .map(Station::name)
                    .toList();
            resultRoutes.put(line.name(), stations);
        }
        return resultRoutes;
    }
}
