package christmas.controller;


import christmas.common.ChristmasException;
import christmas.dto.ResultDto;
import christmas.service.ChristmasService;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.vo.date.MyDate;
import christmas.vo.order.Order;

public class ChristmasController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    ChristmasService christmasService = new ChristmasService();

    public ChristmasController(InputView inputView, OutputView outputView, ChristmasService christmasService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.christmasService = christmasService;
    }

    public void run() {
        outputView.writeDefaultMessage();
        outputView.writeDateMessage();
        MyDate date = createDate();

        outputView.writeOrderMessage();
        Order order = createOrder();

        outputView.writeTitle(date);
        ResultDto dto = christmasService.createEvent(date, order);
        outputView.writeResult(dto);
    }

    private MyDate createDate() {
        while (true) {
            try {
                return inputView.readDate();
            } catch (ChristmasException e) {
                outputView.write(e.getMessage());
            }
        }
    }

    private Order createOrder() {
        while (true) {
            try {
                return inputView.readOrder();
            } catch (ChristmasException e) {
                outputView.write(e.getMessage());
            }
        }
    }
}
