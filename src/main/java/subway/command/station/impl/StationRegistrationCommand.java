package subway.command.station.impl;

import subway.command.Command;
import subway.constant.Constant;
import subway.service.SubwayService;
import subway.util.InputParser;
import subway.util.Retry;
import subway.view.InputView;
import subway.view.OutputView;

public class StationRegistrationCommand implements Command {

    private final SubwayService service;

    public StationRegistrationCommand(SubwayService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Retry.retryUntilSuccess(() -> {
            String readStation = InputView.readStationForRegistration();
            String stationName =  InputParser.parseStation(readStation);
            service.registerStation(stationName);
        });

        OutputView.printRegistration(Constant.STATION.getMessage());
    }
}
