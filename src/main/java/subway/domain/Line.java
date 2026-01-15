package subway.domain;

public class Line {
    private String name;

    public Line(String name) {
        validateMinLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    private void validateMinLength(String input) {
        if (input.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 노선 이름은 2글자 이상이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Line)) return false;
        Line line = (Line) o;
        return name.equals(line.name);
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }
}
