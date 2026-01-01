package subway.controller;

import subway.domain.Station;

import java.util.List;

public class OutputView {
    public static void printStation(List<Station> stations) {
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
        System.out.println();
    }
}
