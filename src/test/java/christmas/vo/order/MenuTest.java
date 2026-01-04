package christmas.vo.order;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    void from() {
        assertThat(Menu.from("타파스")).isEqualTo(Menu.TAPA);
        assertThat(Menu.from("크리스마스파스타")).isEqualTo(Menu.CHRI);
    }
}