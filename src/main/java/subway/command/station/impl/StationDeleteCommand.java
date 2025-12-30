package subway.command.station.impl;

import subway.command.Command;
import subway.constant.Constant;
import subway.service.SubwayService;
import subway.util.InputParser;
import subway.util.Retry;
import subway.view.InputView;
import subway.view.OutputView;

public class StationDeleteCommand implements Command {

    private final SubwayService service;

    public StationDeleteCommand(SubwayService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Retry.retryUntilSuccess(() -> {
            String readStation = InputView.readStationForDelete();
            String stationName =  InputParser.parseStation(readStation);
            service.deleteStation(stationName);
        });

        OutputView.printDelete(Constant.STATION.getMessage());
    }
}
