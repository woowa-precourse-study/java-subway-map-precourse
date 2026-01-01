package subway.command.main;

import subway.command.Command;
import subway.command.Quit;
import subway.controller.SubwayController;

public class RouteManagement implements Command {
    private final SubwayController controller;

    public RouteManagement(SubwayController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.routeMangement();
    }
}
