package subway.controller;

import subway.command.Command;
import subway.command.Quit;
import subway.command.main.PrintRoute;
import subway.command.main.LineManagement;
import subway.command.main.SectionManagement;
import subway.command.main.StationManagement;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.service.SubwayService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwayController {
    private Map<String, Command> commands = new HashMap<>();
    private Map<String, List<String>> sections = new HashMap<>();
    private final InputView inputView;
    private final SubwayService service;

    public SubwayController(SubwayService service) {
        this.inputView = new InputView();
        this.service = service;
        initCommands();
        initSetting();
    }

    public void run() {
        while (true) {
            String function = inputView.readMessage();
            if (function.equals("Q")) {
                break;
            }
            Command command = commands.get(function);
            command.execute();
        }
    }

    private void initCommands() {
        commands.put("1", new StationManagement(this));
        commands.put("2", new LineManagement(this));
        commands.put("3", new SectionManagement(this));
        commands.put("4", new PrintRoute(this));
        commands.put("Q", new Quit(this));
    }

    private void initSetting() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
        StationRepository.addStation(new Station("매봉역"));

        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));


        sections.put("2호선",List.of("교대역","강남역","역삼역"));
        sections.put("3호선",List.of("교대역","남부터미널역","양재역","매봉역"));
        sections.put("신분당선",List.of("강남역","양재역","양재시민의숲역"));


    }


    public void stationManagement() {
        String choice = inputView.readStationFunction();
        if (choice.equals("B")) {
            return;
        }
        if (choice.equals("1")) {
            StationRepository.addStation(new Station(inputView.readAddStation()));

        }

        if (choice.equals("2")) {
            String name = inputView.readDeleteStation();
            for (List<String> stations:sections.values()){
                if (stations.contains(name)){
                    throw new IllegalArgumentException("[ERROR] 노선에 등록된 역은 삭제할 수 없습니다.");
                }
            }
            StationRepository.deleteStation(name);
        }

        if (choice.equals("3")) {
            OutputView.printStationInfo(StationRepository.getStationInfo());
        }

    }

    public void lineMangement() {
        String choice = inputView.readLineFunction();
        if (choice.equals("B")) {
            return;
        }
        if (choice.equals("1")) {
            String line = inputView.readAddLine();
            if (sections.containsKey(line)){
                throw new IllegalArgumentException("[ERROR] 이미 등록된 노선입니다.");
            }
            String start = inputView.readStartStation();
            StationRepository.validateStation(start);
            String end = inputView.readEndStation();
            StationRepository.validateStation(end);

            LineRepository.addLine(new Line(line));
            sections.put(line,List.of(start,end));
            OutputView.printAddLineResult();

        }

        if (choice.equals("2")) {
            LineRepository.deleteLineByName(inputView.readDeleteLine());
        }

        if (choice.equals("3")) {
            OutputView.printLineInfo(LineRepository.getLinesInfo());
        }
    }

    public void sectionManagement() {
        String choice = inputView.readSectionFunction();
        if (choice.equals("B")) {
            return;
        }
        if (choice.equals("1")) {
            String line = inputView.readAddLine();
            if (!sections.containsKey(line)){
                throw new IllegalArgumentException("[ERROR] 해당 노선이 존재하지 않습니다.");
            }
            String station = inputView.readSectionAddStation();
            if (!StationRepository.isExistStation(station)){
                StationRepository.addStation(new Station(station));
            }
            int order = inputView.readOrder();
            List<String> newSection = new ArrayList<>(); // TODO 이거 정리
            newSection.addAll(sections.get(line));
            newSection.add(order,station);
            OutputView.printSectionResult();

        }

        if (choice.equals("2")) {


        }

    }




    public void printRoute() {
        OutputView.printRoute(sections);
    }

    public void quit() {
        return;
    }
}
