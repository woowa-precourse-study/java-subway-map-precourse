package subway.command.main;

import subway.command.Command;
import subway.controller.SubwayController;

public class SectionManagement implements Command {
    private final SubwayController controller;

    public SectionManagement(SubwayController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.sectionManagement();
    }
}
