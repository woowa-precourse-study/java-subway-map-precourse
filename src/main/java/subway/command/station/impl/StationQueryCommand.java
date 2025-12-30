package subway.command.station.impl;

import java.util.List;
import subway.command.Command;
import subway.service.SubwayService;
import subway.view.OutputView;

public class StationQueryCommand implements Command {

    private final SubwayService service;

    public StationQueryCommand(SubwayService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        List<String> stations = service.getStations();

        OutputView.printStations(stations);
    }
}
