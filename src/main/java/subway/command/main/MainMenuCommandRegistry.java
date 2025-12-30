package subway.command.main;

import java.util.EnumMap;
import subway.command.Command;
import subway.command.line.LineMenuCommandRegistry;
import subway.command.main.impl.LineCommand;
import subway.command.main.impl.RouteCommand;
import subway.command.main.impl.SectionCommand;
import subway.command.main.impl.StationCommand;
import subway.command.section.SectionMenuCommandRegistry;
import subway.command.station.StationMenuCommandRegistry;
import subway.service.SubwayService;

public class MainMenuCommandRegistry {

    private final EnumMap<MainMenuOption, Command> commands;

    private MainMenuCommandRegistry(EnumMap<MainMenuOption, Command> commands) {
        this.commands = commands;
    }

    public static MainMenuCommandRegistry from(SubwayService service, StationMenuCommandRegistry stationRegistry,
                                               LineMenuCommandRegistry lineRegistry,
                                               SectionMenuCommandRegistry sectionRegistry) {
        EnumMap<MainMenuOption, Command> map = new EnumMap<>(MainMenuOption.class);
        map.put(MainMenuOption.A, new StationCommand(stationRegistry));
        map.put(MainMenuOption.B, new LineCommand(lineRegistry));
        map.put(MainMenuOption.C, new SectionCommand(sectionRegistry));
        map.put(MainMenuOption.D, new RouteCommand(service));
        return new MainMenuCommandRegistry(map);
    }

    public void execute(MainMenuOption option) {
        commands.get(option).execute();
    }
}
