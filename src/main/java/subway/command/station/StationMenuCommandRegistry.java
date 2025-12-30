package subway.command.station;

import java.util.EnumMap;
import subway.command.Command;
import subway.command.main.impl.StationCommand;
import subway.command.station.impl.StationDeleteCommand;
import subway.command.station.impl.StationQueryCommand;
import subway.command.station.impl.StationRegistrationCommand;
import subway.service.SubwayService;

public class StationMenuCommandRegistry {

    private final EnumMap<StationMenuOption, Command> commands;

    private StationMenuCommandRegistry(EnumMap<StationMenuOption, Command> commands) {
        this.commands = commands;
    }

    public static StationMenuCommandRegistry from(SubwayService service) {
        EnumMap<StationMenuOption, Command> map = new EnumMap<>(StationMenuOption.class);
        map.put(StationMenuOption.A, new StationRegistrationCommand(service));
        map.put(StationMenuOption.B, new StationDeleteCommand(service));
        map.put(StationMenuOption.C, new StationQueryCommand(service));
        return new StationMenuCommandRegistry(map);
    }

    public void execute(StationMenuOption option) {
        commands.get(option).execute();
    }
}
