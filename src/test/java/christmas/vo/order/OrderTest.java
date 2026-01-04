package christmas.vo.order;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import christmas.common.ChristmasException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderTest {

    @Test
    void from() {
        Order order = Order.from("크리스마스파스타-2,제로콜라-1");
        assertThat(order.menus().get(Menu.from("크리스마스파스타"))).isEqualTo(2);
        assertThat(order.menus().get(Menu.from("제로콜라"))).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "크리스마스파스타-1,크리스마스파스타-2",
            "크리스마스파스토-2",
            "크리스마스파스타-0",
            "크리스마스파스타-10,제로콜라-15",
            "크리스마스파스타-10, 제로콜라-15",
            "크리스마스파스타 - 10,제로콜라 - 15"
    })
    void from_예외(String input) {
        assertThatThrownBy(() -> Order.from(input))
                .isInstanceOf(ChristmasException.class);
    }

    @Test
    void getOriginalPrice() {
        Order order = Order.from("크리스마스파스타-2,제로콜라-1");
        assertThat(order.getOriginalPrice()).isEqualTo(53000);
    }

    @Test
    void getCategoryCount() {
        Order order = Order.from("양송이수프-1,타파스-2,바비큐립-3,크리스마스파스타-2,초코케이크-3,제로콜라-1");
        assertThat(order.getCategoryCount("에피타이저")).isEqualTo(3);
        assertThat(order.getCategoryCount("메인")).isEqualTo(5);
        assertThat(order.getCategoryCount("디저트")).isEqualTo(3);
        assertThat(order.getCategoryCount("음료")).isEqualTo(1);
    }
}