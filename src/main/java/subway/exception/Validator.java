package subway.exception;

import java.util.HashSet;
import java.util.Set;

public interface Validator {
    void validate(String input);


    static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }

    static void validateFunction(String input) {
        if (!Set.of("1", "2", "3", "4", "Q").contains(input)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.");
        }
    }

    static void validateChoice(String input) {
        if (!Set.of("1", "2", "3", "B").contains(input)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.");
        }
    }



}

