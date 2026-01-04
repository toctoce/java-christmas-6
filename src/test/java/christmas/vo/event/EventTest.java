package christmas.vo.event;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.vo.date.MyDate;
import christmas.vo.order.Order;
import org.junit.jupiter.api.Test;

class EventTest {

    @Test
    void 할인_가격_계산() {
        Order order = Order.from("양송이수프-1,타파스-2,바비큐립-3,크리스마스파스타-2,초코케이크-3,제로콜라-1");
        Event event7 = new Event(order, MyDate.from("7"));
        Event event8 = new Event(order, MyDate.from("8"));
        Event event25 = new Event(order, MyDate.from("25"));
        Event event26 = new Event(order, MyDate.from("26"));

        Order cheapOrder = Order.from("양송이수프-1,바비큐립-1");
        Event cheapEvent = new Event(cheapOrder, MyDate.from("7"));

        Order cheaperThan10000Order = Order.from("아이스크림-1");
        Event cheaperThan10000Event = new Event(cheaperThan10000Order, MyDate.from("7"));

        assertThat(event7.getDDayDiscount()).isEqualTo(1600);
        assertThat(event8.getDDayDiscount()).isEqualTo(1700);
        assertThat(event25.getDDayDiscount()).isEqualTo(3400);
        assertThat(event26.getDDayDiscount()).isEqualTo(0);

        assertThat(event7.getWeekdayDiscount()).isEqualTo(2023 * 3);
        assertThat(event8.getWeekdayDiscount()).isEqualTo(0);

        assertThat(event7.getWeekendDiscount()).isEqualTo(0);
        assertThat(event8.getWeekendDiscount()).isEqualTo(2023 * 5);

        assertThat(event25.getSpecialDiscount()).isEqualTo(1000);
        assertThat(event26.getSpecialDiscount()).isEqualTo(0);

        assertThat(event7.getGift()).isEqualTo(25000);
        assertThat(cheapEvent.getGift()).isEqualTo(0);

        assertThat(event7.getDiscount()).isEqualTo(1600 + 2023 * 3 + 0 + 0 + 25000);
        assertThat(cheaperThan10000Event.getWeekdayDiscount()).isEqualTo(0);
    }
}