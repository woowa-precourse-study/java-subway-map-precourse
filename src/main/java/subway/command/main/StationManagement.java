package subway.command.main;

import subway.command.Command;
import subway.controller.SubwayController;

public class StationManagement implements Command {
    private final SubwayController controller;

    public StationManagement(SubwayController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.stationManagement();
    }
}
