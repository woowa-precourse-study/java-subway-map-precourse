package subway.command.section.impl;

import subway.command.Command;
import subway.constant.Constant;
import subway.domain.Line;
import subway.domain.Station;
import subway.service.SubwayService;
import subway.util.InputParser;
import subway.util.Retry;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionRegistrationCommand implements Command {

    private final SubwayService service;

    public SectionRegistrationCommand(SubwayService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Line line =  Retry.retryUntilSuccess(() -> {
            String readLine = InputView.readLineForSectionRegistration();
            String lineName = InputParser.parseLine(readLine);
            return service.registerSectionWithLine(lineName);
        });

        Station station = Retry.retryUntilSuccess(() -> {
            String readStation = InputView.readStationForSectionRegistration();
            String stationName = InputParser.parseStation(readStation);
            return service.validatePossibleAddStation(line, stationName);
        });

        Retry.retryUntilSuccess(() -> {
            String readIndex = InputView.readIndexForSectionRegistration();
            int index = InputParser.parseIndex(readIndex);
            service.registerRoute(line, station, index);
        });

        OutputView.printRegistration(Constant.SECTION.getMessage());
    }
}
