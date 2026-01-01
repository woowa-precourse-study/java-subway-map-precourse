package subway.controller;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printStationInfo(List<Station> stations) {
        System.out.println("## 역 목록");
        for (Station station : stations) {
            System.out.println("[INFO] " + station.getName());
        }
        System.out.println();
    }

    public static void printLineInfo(List<Line> lines) {
        System.out.println("## 노선 목록");
        for (Line line : lines) {
            System.out.println("[INFO] " + line.getName());
        }
        System.out.println();
    }

    public static void printAddLineResult() {
        System.out.println("[INFO] 지하철 노선이 등록되었습니다.");
    }

    public static void printSectionResult() {
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    public static void printSectionDelete() {
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }


    public static void printRoute(Map<String, List<String>> sections) {
        System.out.println("## 지하철 노선도");

        for (String line : sections.keySet()) {
            System.out.println("[INFO] " + line);
            System.out.println("[INFO] ---");
            for (String station:sections.get(line)){
                System.out.println("[INFO] " + station);
            }
            System.out.println();
        }
    }


}
