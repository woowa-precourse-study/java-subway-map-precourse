package subway.command.line.impl;

import java.util.List;
import subway.command.Command;
import subway.service.SubwayService;
import subway.view.OutputView;

public class LineQueryCommand implements Command {

    private final SubwayService service;

    public LineQueryCommand(SubwayService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        List<String> lines = service.getLines();

        OutputView.printLines(lines);
    }
}
