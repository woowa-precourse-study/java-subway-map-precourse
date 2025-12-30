package subway.command.section;

import java.util.EnumMap;
import subway.command.Command;
import subway.command.section.impl.SectionDeleteCommand;
import subway.command.section.impl.SectionRegistrationCommand;
import subway.service.SubwayService;

public class SectionMenuCommandRegistry {

    private final EnumMap<SectionMenuOption, Command> commands;

    private SectionMenuCommandRegistry(EnumMap<SectionMenuOption, Command> commands) {
        this.commands = commands;
    }

    public static SectionMenuCommandRegistry from(SubwayService service) {
        EnumMap<SectionMenuOption, Command> map = new EnumMap<>(SectionMenuOption.class);
        map.put(SectionMenuOption.A, new SectionRegistrationCommand(service));
        map.put(SectionMenuOption.B, new SectionDeleteCommand(service));
        return new SectionMenuCommandRegistry(map);
    }

    public void execute(SectionMenuOption option) {
        commands.get(option).execute();
    }
}
