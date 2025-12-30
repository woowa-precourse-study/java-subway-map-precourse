package subway.command.section.impl;

import subway.command.Command;
import subway.constant.Constant;
import subway.domain.Line;
import subway.service.SubwayService;
import subway.util.InputParser;
import subway.util.Retry;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionDeleteCommand implements Command {

    private final SubwayService service;

    public SectionDeleteCommand(SubwayService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Line line =  Retry.retryUntilSuccess(() -> {
            String readLine = InputView.readLineForSectionRegistration();
            String lineName = InputParser.parseLine(readLine);
            return service.deleteSectionWithLine(lineName);
        });

        Retry.retryUntilSuccess(() -> {
            String readStation = InputView.readStationForSectionRegistration();
            String stationName = InputParser.parseStation(readStation);
            service.deleteSection(line, stationName);
        });

        OutputView.printDelete(Constant.SECTION.getMessage());
    }
}
