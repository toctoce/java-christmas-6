package christmas.vo.event;

import christmas.vo.date.MyDate;
import christmas.vo.order.Menu;
import christmas.vo.order.Order;
import java.util.List;

/*
    items : [dDayDiscount, weekdayDiscount, weekendDiscount, specialDiscount, gift]
 */
public record Event(List<Integer> items) {

    public static Event from(Order order, MyDate date) {

        if (order.getOriginalPrice() < 10000) {
            return new Event(List.of(0, 0, 0, 0, 0));
        }
        int dDayDiscount = calculateDDayDiscount(date);
        int weekdayDiscount = calculateWeekdayDiscount(order, date);
        int weekendDiscount = calculateWeekendDiscount(order, date);
        int specialDiscount = calculateSpecialDiscount(date);
        int gift = calculateGift(order);

        return new Event(List.of(dDayDiscount, weekdayDiscount, weekendDiscount, specialDiscount, gift));
    }

    private static int calculateWeekdayDiscount(Order order, MyDate date) {
        if (!date.isWeekday()) {
            return 0;
        }
        return order.getCategoryCount("디저트") * 2023;
    }

    private static int calculateWeekendDiscount(Order order, MyDate date) {
        if (!date.isWeekend()) {
            return 0;
        }
        return order.getCategoryCount("메인") * 2023;
    }

    private static int calculateSpecialDiscount(MyDate date) {
        if (!date.isSpecialDiscount()) {
            return 0;
        }
        return 1000;
    }

    private static int calculateDDayDiscount(MyDate date) {
        return 900 + date.date().getDayOfMonth() * 100;
    }

    private static int calculateGift(Order order) {
        if (order.getOriginalPrice() >= 120_000) {
            return Menu.from("샴페인").getPrice();
        }
        return 0;
    }
}
