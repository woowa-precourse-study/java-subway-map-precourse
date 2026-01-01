package subway.command.main;

import subway.command.Command;
import subway.controller.SubwayController;

public class PrintRoute implements Command {
    private final SubwayController controller;

    public PrintRoute(SubwayController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.printRoute();
    }
}
