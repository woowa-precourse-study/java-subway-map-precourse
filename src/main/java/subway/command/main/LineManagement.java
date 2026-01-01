package subway.command.main;

import subway.command.Command;
import subway.controller.SubwayController;

public class LineManagement implements Command {
    private final SubwayController controller;

    public LineManagement(SubwayController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.lineMangement();
    }
}
