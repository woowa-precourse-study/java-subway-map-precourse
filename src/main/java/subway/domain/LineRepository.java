package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        validateUniqueLine(line);
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static List<Line> getLinesInfo() {
        return lines;
    }

    private static void validateUniqueLine(Line line) {
        if (lines.contains(line)) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 노선은 등록할 수 없습니다.");
        }
    }

    private static void validateLine(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                return;
            }
        }
        throw new IllegalArgumentException("[ERROR] 존재하지 않는 노선은 삭제할 수 없습니다.");
    }
}
