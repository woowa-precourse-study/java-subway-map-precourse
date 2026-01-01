package subway;

import subway.controller.SubwayController;
import subway.service.SubwayService;

public class Application {
    public static void main(String[] args) {
        SubwayService service = new SubwayService();
        SubwayController controller = new SubwayController(service);
        controller.run();
    }
}
