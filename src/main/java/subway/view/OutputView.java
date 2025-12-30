package subway.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {
    }

    public static void printRegistration(String name) {
        System.out.printf("\n[INFO] %s이 등록되었습니다.\n", name);
    }

    public static void printDelete(String name) {
        System.out.printf("\n[INFO] %s이 삭제되었습니다.\n", name);
    }

    public static void printStations(List<String> stations) {
        System.out.println("\n## 역 목록");
        for (String station : stations) {
            System.out.println("[INFO] " + station);
        }
    }

    public static void printLines(List<String> lines) {
        System.out.println("\n## 노선 목록");
        for (String line : lines) {
            System.out.println("[INFO] " + line);
        }
    }

    public static void printRoutes(Map<String, List<String>> routes) {
        System.out.println("\n## 지하철 노선도");
        for (String line : routes.keySet()) {
            System.out.println("[INFO] " + line);
            System.out.println("[INFO] ---");
            for (String station : routes.get(line)) {
                System.out.println("[INFO] " + station);
            }
            System.out.println();
        }
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
