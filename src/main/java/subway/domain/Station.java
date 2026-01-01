package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        validateMinLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    private void validateMinLength(String input) {
        if (input.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 지하철 역 이름은 2글자 이상이어야 합니다.");
        }
    }
}
