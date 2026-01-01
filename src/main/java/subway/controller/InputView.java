package subway.controller;

import camp.nextstep.edu.missionutils.Console;
import subway.domain.LineRepository;
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

    public String readStationFunction() {
        System.out.println("""
                \n## 역 관리 화면
                1. 역 등록
                2. 역 삭제
                3. 역 조회
                B. 돌아가기
                """);
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String input = readInput(List.of(
                Validator::validateNotBlank,
                Validator::validateChoice
        ));
        return input;
    }

    public String readLineFunction() {
        System.out.println("""
                ## 노선 관리 화면
                1. 노선 등록
                2. 노선 삭제
                3. 노선 조회
                B. 돌아가기
                """);
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String input = readInput(List.of(
                Validator::validateNotBlank,
                Validator::validateChoice
        ));
        return input;
    }

    public String readAddStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
        String input = readInput(List.of(
                Validator::validateNotBlank
        ));
        return input;
    }

    public String readDeleteStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        String input = readInput(List.of(
                Validator::validateNotBlank
        ));
        return input;
    }

    public String readAddLine() {
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        String input = readInput(List.of(
                Validator::validateNotBlank
        ));
        return input;
    }

    public String readDeleteLine() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        String input = readInput(List.of(
                Validator::validateNotBlank
        ));
        return input;
    }

    public String readStartStation(){
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String start = readInput(List.of(
                Validator::validateNotBlank
        ));
        return start;

    }
    public String readEndStation(){
        System.out.println("## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        String end = readInput(List.of(
                Validator::validateNotBlank
        ));
        return end;
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
