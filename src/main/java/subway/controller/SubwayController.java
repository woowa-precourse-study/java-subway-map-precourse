package subway.controller;

import subway.command.Command;
import subway.command.Quit;
import subway.command.main.PrintRoute;
import subway.command.main.RouteManagement;
import subway.command.main.SectionManagement;
import subway.command.main.StationManagement;
import subway.service.SubwayService;

import java.util.HashMap;
import java.util.Map;

public class SubwayController {
    private Map<String, Command> commands = new HashMap<>();
    private final InputView inputView;
    private final SubwayService service;

    public SubwayController(SubwayService service) {
        this.inputView = new InputView();
        this.service = service;
        initCommands();
    }

    public void run() {

        while(true) {
            String function = inputView.readMessage();
            if (function.equals("Q")) {
                break;
            }
            Command command = commands.get(function);
            command.execute();
        }
    }

    private void initCommands() {
        commands.put("1", new StationManagement(this));
        commands.put("2", new RouteManagement(this));
        commands.put("3", new SectionManagement(this));
        commands.put("4", new PrintRoute(this));
        commands.put("Q", new Quit(this));
    }


    public void stationManagement() {

    }

    public void sectionManagement() {
    }

    public void routeMangement() {
    }

    public void printRoute() {
    }

    public void quit() {
        return;
    }
}
