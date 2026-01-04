package christmas.vo.date;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class MyDateTest {

    @Test
    void from() {
        MyDate date = MyDate.from("1");
        assertThat(date.date()).isEqualTo(LocalDate.of(2023, 12, 1));
    }

    @Test
    void isSpecialDiscount() {
        assertThat(MyDate.from("2").isSpecialDiscount()).isFalse();
        assertThat(MyDate.from("3").isSpecialDiscount()).isTrue();
        assertThat(MyDate.from("25").isSpecialDiscount()).isTrue();
        assertThat(MyDate.from("31").isSpecialDiscount()).isTrue();
    }

    @Test
    void isWeekend() {
        assertThat(MyDate.from("7").isWeekend()).isFalse();
        assertThat(MyDate.from("8").isWeekend()).isTrue();
        assertThat(MyDate.from("9").isWeekend()).isTrue();
    }

    @Test
    void isWeekday() {
        assertThat(MyDate.from("7").isWeekday()).isTrue();
        assertThat(MyDate.from("8").isWeekday()).isFalse();
        assertThat(MyDate.from("9").isWeekday()).isFalse();
    }

    @Test
    void isDDayDiscount() {
        assertThat(MyDate.from("1").isDDayDiscount()).isTrue();
        assertThat(MyDate.from("25").isDDayDiscount()).isTrue();
        assertThat(MyDate.from("26").isDDayDiscount()).isFalse();
    }
}