package subway.command.main.impl;

import subway.command.Command;
import subway.command.station.StationMenuCommandRegistry;
import subway.command.station.StationMenuOption;
import subway.util.Retry;
import subway.view.InputView;

public class StationCommand implements Command {

    private final StationMenuCommandRegistry stationRegistry;

    public StationCommand(StationMenuCommandRegistry stationRegistry) {
        this.stationRegistry = stationRegistry;
    }

    @Override
    public void execute() {
        StationMenuOption option = getOption();

        if (option.equals(StationMenuOption.BACK)) {
            return;
        }

        stationRegistry.execute(option);
    }

    private static StationMenuOption getOption() {
        return Retry.retryUntilSuccess(() -> {
            String selection = InputView.readStationMenuSelection();
            return StationMenuOption.from(selection);
        });
    }
}
