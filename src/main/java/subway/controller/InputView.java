package subway.controller;

import camp.nextstep.edu.missionutils.Console;
import subway.exception.Validator;

import java.util.List;
import java.util.NoSuchElementException;

public class InputView {

    public String readMessage() {
        System.out.println("""
                ## 메인 화면
                1. 역 관리
                2. 노선 관리
                3. 구간 관리
                4. 지하철 노선도 출력
                Q. 종료
                """);
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String input = readInput(List.of(
                Validator::validateNotBlank,
                Validator::validateFunction
        ));
        return input;
    }

    private String readInput(List<Validator> validators) {
        try{
            String input = Console.readLine().trim();
            for (Validator v : validators) {
                v.validate(input);
            }
            return input;
        } catch(NoSuchElementException e){
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }

    }
}
