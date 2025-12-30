package subway.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import subway.command.main.MainMenuCommandRegistry;
import subway.command.main.MainMenuOption;
import subway.service.SubwayService;
import subway.util.Retry;
import subway.view.InputView;

public class SubwayController {

    private final MainMenuCommandRegistry mainRegistry;
    private final SubwayService service;

    public SubwayController(MainMenuCommandRegistry mainRegistry, SubwayService service) {
        this.mainRegistry = mainRegistry;
        this.service = service;
    }

    public void run() {
        setInit();

        while (true) {
            MainMenuOption option = readMainOption();

            if (option.equals(MainMenuOption.QUIT)) {
                return;
            }

            mainRegistry.execute(option);
        }
    }

    private MainMenuOption readMainOption() {
        return Retry.retryUntilSuccess(() -> {
            String selection = InputView.readMainMenuSelection();
            return MainMenuOption.from(selection);
        });
    }

    private void setInit() {
        List<String> stations = List.of("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        Map<String, List<String>> lines = new LinkedHashMap<>();
        lines.put("2호선", List.of("교대역", "강남역", "역삼역"));
        lines.put("3호선", List.of("교대역", "남부터미널역", "양재역", "매봉역"));
        lines.put("신분당선", List.of("강남역", "양재역", "양재시민의숲역"));

        service.setStations(stations);
        service.setLines(lines);
    }
}
