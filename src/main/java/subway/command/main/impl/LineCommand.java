package subway.command.main.impl;

import subway.command.Command;
import subway.command.line.LineMenuCommandRegistry;
import subway.command.line.LineMenuOption;
import subway.util.Retry;
import subway.view.InputView;

public class LineCommand implements Command {

    private final LineMenuCommandRegistry lineRegistry;

    public LineCommand(LineMenuCommandRegistry lineRegistry) {
        this.lineRegistry = lineRegistry;
    }

    @Override
    public void execute() {
        LineMenuOption option = getOption();

        if (option.equals(LineMenuOption.BACK)) {
            return;
        }

        lineRegistry.execute(option);
    }

    private static LineMenuOption getOption() {
        return Retry.retryUntilSuccess(() -> {
            String selection = InputView.readLineMenuSelection();
            return LineMenuOption.from(selection);
        });
    }
}
