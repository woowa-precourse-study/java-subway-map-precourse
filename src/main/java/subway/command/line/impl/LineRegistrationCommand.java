package subway.command.line.impl;

import subway.command.Command;
import subway.constant.Constant;
import subway.domain.Line;
import subway.service.SubwayService;
import subway.util.InputParser;
import subway.util.Retry;
import subway.view.InputView;
import subway.view.OutputView;

public class LineRegistrationCommand implements Command {

    private final SubwayService service;

    public LineRegistrationCommand(SubwayService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Line line = getLine();

        registerFirstStationName(line);
        registerLastStationName(line);

        OutputView.printRegistration(Constant.LINE.getMessage());
    }

    private Line getLine() {
        return Retry.retryUntilSuccess(() -> {
            String readLine = InputView.readLineForRegistration();
            String lineName = InputParser.parseLine(readLine);
            return service.registerLine(lineName);
        });
    }

    private void registerFirstStationName(Line line) {
        Retry.retryUntilSuccess(() -> {
            String readStation = InputView.readFirstStationForRegistration();
            String firstStationName = InputParser.parseStation(readStation);
            service.registerLineWithStation(line, firstStationName);
        });
    }

    private void registerLastStationName(Line line) {
         Retry.retryUntilSuccess(() -> {
            String readStation = InputView.readLastStationForRegistration();
            String lastStationName =  InputParser.parseStation(readStation);
            service.registerLineWithStation(line, lastStationName);
        });
    }
}
