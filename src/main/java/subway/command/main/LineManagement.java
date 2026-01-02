package subway.command.main;

import subway.command.Command;
import subway.controller.InputView;
import subway.controller.OutputView;
import subway.controller.SubwayController;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Section;
import subway.domain.StationRepository;

import java.util.ArrayList;
import java.util.List;

public class LineManagement implements Command {
    private final InputView inputView;
    private Section section;

    public LineManagement(InputView inputView, Section section) {
        this.inputView=inputView;
        this.section = section;
    }

    @Override
    public void execute() {
        lineMangement();
    }

    public void lineMangement() {
        String choice = inputView.readLineFunction();
        if (choice.equals("B")) {
            return;
        }
        if (choice.equals("1")) {
            String line = inputView.readAddLine();
            section.validateSection(line);

            String start = inputView.readStartStation();
            StationRepository.validateStation(start);
            String end = inputView.readEndStation();
            StationRepository.validateStation(end);

            LineRepository.addLine(new Line(line));
            section.addSection(line,new ArrayList<>(List.of(start,end)));
            OutputView.printAddLineResult();

        }

        if (choice.equals("2")) {
            LineRepository.deleteLineByName(inputView.readDeleteLine());
        }

        if (choice.equals("3")) {
            OutputView.printLineInfo(LineRepository.getLinesInfo());
        }
    }
}
