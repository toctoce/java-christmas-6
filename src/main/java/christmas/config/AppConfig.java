package christmas.config;

import christmas.controller.Controller;
import christmas.service.Service;
import christmas.view.InputView;
import christmas.view.OutputView;

public class AppConfig {
    public OutputView outputView() {
        return new OutputView();
    }

    public InputView inputView() {
        return new InputView();
    }

    public Controller controller() {
        // 주의: Controller에 생성자가 정의되어 있어야 합니다.
        return new Controller(inputView(), outputView(), service());
    }

    public Service service() {
        return new Service();
    }
}
