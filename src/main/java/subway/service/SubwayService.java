package subway.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import subway.constant.ErrorMessage;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.RouteRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayService {

    public void setStations(List<String> stations) {
        for (String stationName : stations) {
            StationRepository.addStation(Station.from(stationName));
        }
    }

    public void setLines(Map<String, List<String>> lines) {
        for (String lineName : lines.keySet()) {
            Line line = Line.from(lineName);
            LineRepository.addLine(line);

            List<Station> stations = new ArrayList<>();
            for (String stationName : lines.get(lineName)) {
                stations.add(StationRepository.getStation(stationName));
            }
            RouteRepository.addStations(line, stations);
        }
    }

    public void registerStation(String stationName) {
        StationRepository.addStation(Station.from(stationName));
    }

    public void deleteStation(String stationName) {
        Station station = StationRepository.getStation(stationName);
        StationRepository.deleteStation(station);
    }

    public Line registerLine(String lineName) {
        Line line = Line.from(lineName);

        LineRepository.addLine(line);
        RouteRepository.addLine(line);

        return line;
    }

    public void registerLineWithStation(Line line, String stationName) {
        Station station = Station.from(stationName);
        RouteRepository.addStation(line, station);
    }

    public void deleteLine(String lineName) {
        Line line = Line.from(lineName);
        LineRepository.deleteLine(line);
        RouteRepository.deleteLine(line);
    }

    public List<String> getStations() {
        return StationRepository.stations().stream()
                .map(Station::name)
                .toList();
    }

    public List<String> getLines() {
        return LineRepository.lines().stream()
                .map(Line::name)
                .toList();
    }

    public Line registerSectionWithLine(String lineName) {
        Line line = Line.from(lineName);
        if (!RouteRepository.contains(line)) {
            throw new IllegalArgumentException(ErrorMessage.NO_EXIST_LINE.getErrorMessage());
        }
        return line;
    }

    public Station validatePossibleAddStation(Line line, String stationName) {
        Station station = StationRepository.getStation(stationName);
        if (RouteRepository.contains(line, station)) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_EXIST_STATION_IN_LINE.getErrorMessage());
        }
        return station;
    }

    public void registerRoute(Line line, Station station, int index) {
        RouteRepository.addStation(line, station, index);
    }

    public Line deleteSectionWithLine(String lineName) {
        Line line = LineRepository.getLine(Line.from(lineName));
        RouteRepository.validateDeleteLine(line);
        return line;
    }

    public void deleteSection(Line line, String stationName) {
        Station station = StationRepository.getStation(stationName);
        RouteRepository.deleteSection(line, station);
    }

    public Map<String, List<String>> getRoutes() {
        return RouteRepository.getRoutes();
    }
}
