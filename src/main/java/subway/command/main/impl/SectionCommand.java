package subway.command.main.impl;

import subway.command.Command;
import subway.command.section.SectionMenuCommandRegistry;
import subway.command.section.SectionMenuOption;
import subway.util.Retry;
import subway.view.InputView;

public class SectionCommand implements Command {

    private final SectionMenuCommandRegistry sectionRegistry;

    public SectionCommand(SectionMenuCommandRegistry sectionRegistry) {
        this.sectionRegistry = sectionRegistry;
    }

    @Override
    public void execute() {
        SectionMenuOption option = getOption();

        if (option.equals(SectionMenuOption.BACK)) {
            return;
        }

        sectionRegistry.execute(option);
    }

    private static SectionMenuOption getOption() {
        return Retry.retryUntilSuccess(() -> {
            String selection = InputView.readSectionMenuSelection();
            return SectionMenuOption.from(selection);
        });
    }
}
