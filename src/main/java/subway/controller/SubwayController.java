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

import java.util.HashMap;
import java.util.Map;

public class SubwayController {
    private Map<String, Command> commands = new HashMap<>();
    private final InputView inputView;
    private final SubwayService service;

    public SubwayController(SubwayService service) {
        this.inputView = new InputView();
        this.service = service;
        initCommands();
    }

    public void run() {

        while(true) {
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


    }


    public void stationManagement() {
        String choice=inputView.readStationFunction();
        if (choice.equals("B")) {
            return;
        }

    }

    public void sectionManagement() {
    }

    public void lineMangement() {
    }

    public void printRoute() {
    }

    public void quit() {
        return;
    }
}
