package subway.command.line.impl;

import subway.command.Command;
import subway.constant.Constant;
import subway.service.SubwayService;
import subway.util.InputParser;
import subway.util.Retry;
import subway.view.InputView;
import subway.view.OutputView;

public class LineDeleteCommand implements Command {

    private final SubwayService service;

    public LineDeleteCommand(SubwayService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Retry.retryUntilSuccess(() -> {
            String readLine = InputView.readLineForDelete();
            String lineName = InputParser.parseLine(readLine);
            service.deleteLine(lineName);
        });

        OutputView.printDelete(Constant.LINE.getMessage());
    }
}
