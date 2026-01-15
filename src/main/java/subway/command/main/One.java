package subway.command.main;

import subway.command.Command;
import subway.controller.InputView;
import subway.domain.Section;

public class One implements Command {
    private final InputView inputView;
    private Section section;

    public One(InputView inputView, Section section) {
        this.inputView=inputView;
        this.section = section;
    }

    @Override
    public void execute() {
        one();
    }

    public void one() {
        // TODO: 작동할거 작성
    }
}
