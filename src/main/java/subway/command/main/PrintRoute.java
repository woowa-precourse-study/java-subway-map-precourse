package subway.command.main;

import subway.command.Command;
import subway.controller.InputView;
import subway.controller.OutputView;
import subway.controller.SubwayController;
import subway.domain.Section;

public class PrintRoute implements Command {
    private final InputView inputView;
    private Section section;


    public PrintRoute(InputView inputView, Section section) {
        this.inputView=inputView;
        this.section = section;
    }

    @Override
    public void execute() {
        printRoute();
    }
    public void printRoute() {
        OutputView.printRoute(section.getSections());
    }
}
