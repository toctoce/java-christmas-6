package christmas.service;

import christmas.dto.ResultDto;
import christmas.vo.date.MyDate;
import christmas.vo.event.Event;
import christmas.vo.order.Order;

public class ChristmasService {

    public ResultDto createEvent(MyDate date, Order order) {
        Event event = new Event(order, date);
        return ResultDto.from(event);
    }
}
