package christmas.config;

import christmas.controller.ChristmasController;
import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {
    public OutputView outputView() {
        return new OutputView();
    }

    public InputView inputView() {
        return new InputView();
    }

    public ChristmasController controller() {
        return new ChristmasController(inputView(), outputView(), service());
    }

    public ChristmasService service() {
        return new ChristmasService();
    }
}
