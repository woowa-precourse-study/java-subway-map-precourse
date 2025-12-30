package subway.command.main.impl;

import java.util.List;
import java.util.Map;
import subway.command.Command;
import subway.service.SubwayService;
import subway.view.OutputView;

public class RouteCommand implements Command {

    private final SubwayService service;

    public RouteCommand(SubwayService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Map<String, List<String>> routes = service.getRoutes();

        OutputView.printRoutes(routes);
    }
}
