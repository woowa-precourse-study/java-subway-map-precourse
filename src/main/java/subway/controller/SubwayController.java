package subway.controller;

import subway.command.Command;
import subway.command.Quit;
import subway.command.main.PrintRoute;
import subway.command.main.LineManagement;
import subway.command.main.SectionManagement;
import subway.command.main.StationManagement;
import subway.domain.*;
import subway.service.SubwayService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubwayController {
    private Map<String, Command> commands = new HashMap<>();
    private Section section=new Section();
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

        section.addSection("2호선",new ArrayList<>(List.of("교대역","강남역","역삼역")));
        section.addSection("3호선",new ArrayList<>(List.of("교대역","남부터미널역","양재역","매봉역")));
        section.addSection("신분당선",new ArrayList<>(List.of("강남역","양재역","양재시민의숲역")));

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
            section.deleteSectionStation(name);

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
            section.validateSection(line);

            String start = inputView.readStartStation();
            StationRepository.validateStation(start);
            String end = inputView.readEndStation();
            StationRepository.validateStation(end);

            LineRepository.addLine(new Line(line));
            section.addSection(line,new ArrayList<>(List.of(start,end)));
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
            section.validateSectionExist(line);

            String station = inputView.readSectionAddStation();
            if (!StationRepository.isExistStation(station)){
                StationRepository.addStation(new Station(station));
            }
            int order = inputView.readOrder();
            section.addSectionStation(line, order, station);
            OutputView.printSectionResult();

        }

        if (choice.equals("2")) {

            String line=inputView.readSectionDeleteLine();
            section.validateSectionExist(line);

            String station=inputView.readSectionDeleteStation();
            StationRepository.validateStation(station);

            section.deleteSectionStation(station);
            StationRepository.deleteStation(station);
            OutputView.printSectionDelete();

        }

    }


    public void printRoute() {
        OutputView.printRoute(section.getSections());
    }

    public void quit() {
        return;
    }
}
