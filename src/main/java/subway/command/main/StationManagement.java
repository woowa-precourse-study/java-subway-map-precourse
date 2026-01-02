package subway.command.main;

import subway.command.Command;
import subway.controller.InputView;
import subway.controller.OutputView;
import subway.domain.Section;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManagement implements Command {
    private final InputView inputView;
    private Section section;

    public StationManagement(InputView inputView, Section section) {
        this.inputView=inputView;
        this.section = section;
    }

    @Override
    public void execute() {
        stationManagement();
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
            section.validateNotStationInLine(name);

            StationRepository.deleteStation(name);
        }

        if (choice.equals("3")) {
            OutputView.printStationInfo(StationRepository.getStationInfo());
        }

    }
}
