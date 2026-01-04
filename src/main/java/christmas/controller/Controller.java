package christmas.controller;


import christmas.dto.Dto;
import christmas.service.Service;
import christmas.view.InputView;
import christmas.view.OutputView;
import christmas.vo.date.MyDate;

public class Controller {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    Service service = new Service();

    public Controller(InputView inputView, OutputView outputView, Service service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run() {
        MyDate myDate = createDate();

        Dto dto = service.createSchedule(myDate);
//        outputView.write(dto.content());
    }

    private MyDate createDate() {
        return null;
    }
}
