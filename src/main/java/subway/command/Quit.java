package subway.command;

import subway.controller.SubwayController;

public class Quit implements Command {
    private final SubwayController controller;

    public Quit(SubwayController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        controller.quit();
    }
}
