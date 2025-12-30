package subway.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readMainMenuSelection() {
        System.out.println("\n## 메인 화면\n"
                + "1. 역 관리\n"
                + "2. 노선 관리\n"
                + "3. 구간 관리\n"
                + "4. 지하철 노선도 출력\n"
                + "Q. 종료");
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public static String readStationMenuSelection() {
        System.out.println("\n## 역 관리 화면\n"
                + "1. 역 등록\n"
                + "2. 역 삭제\n"
                + "3. 역 조회\n"
                + "B. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public static String readLineMenuSelection() {
        System.out.println("\n## 노선 관리 화면\n"
                + "1. 노선 등록\n"
                + "2. 노선 삭제\n"
                + "3. 노선 조회\n"
                + "B. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public static String readSectionMenuSelection() {
        System.out.println("\n## 구간 관리 화면\n"
                + "1. 구간 등록\n"
                + "2. 구간 삭제\n"
                + "B. 돌아가기");
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public static String readStationForRegistration() {
        System.out.println("\n## 등록할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String readStationForDelete() {
        System.out.println("\n## 삭제할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String readLineForRegistration() {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String readFirstStationForRegistration() {
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String readLastStationForRegistration() {
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String readLineForDelete() {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String readLineForSectionRegistration() {
        System.out.println("\n## 노선을 입력하세요.");
        return scanner.nextLine();
    }

    public static String readStationForSectionRegistration() {
        System.out.println("\n## 역이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String readIndexForSectionRegistration() {
        System.out.println("\n## 순서를 입력하세요.");
        return scanner.nextLine();
    }
}
