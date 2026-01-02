package subway.command.main;

import subway.command.Command;
import subway.controller.InputView;
import subway.controller.OutputView;
import subway.controller.SubwayController;
import subway.domain.Section;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SectionManagement implements Command {
    private final InputView inputView;
    private Section section;


    public SectionManagement(InputView inputView, Section section) {
        this.inputView=inputView;
        this.section = section;
    }

    @Override
    public void execute() {
        sectionManagement();
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

            section.validateNotStationInLine(station);
            StationRepository.deleteStation(station);
            OutputView.printSectionDelete();

        }

    }

}
