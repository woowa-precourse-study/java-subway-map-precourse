package subway.command.line;

import java.util.EnumMap;
import subway.command.Command;
import subway.command.line.impl.LineDeleteCommand;
import subway.command.line.impl.LineQueryCommand;
import subway.command.line.impl.LineRegistrationCommand;
import subway.service.SubwayService;

public class LineMenuCommandRegistry {

    private final EnumMap<LineMenuOption, Command> commands;

    private LineMenuCommandRegistry(EnumMap<LineMenuOption, Command> commands) {
        this.commands = commands;
    }

    public static LineMenuCommandRegistry from(SubwayService service) {
        EnumMap<LineMenuOption, Command> map = new EnumMap<>(LineMenuOption.class);
        map.put(LineMenuOption.A, new LineRegistrationCommand(service));
        map.put(LineMenuOption.B, new LineDeleteCommand(service));
        map.put(LineMenuOption.C, new LineQueryCommand(service));
        return new LineMenuCommandRegistry(map);
    }

    public void execute(LineMenuOption option) {
        commands.get(option).execute();
    }
}
