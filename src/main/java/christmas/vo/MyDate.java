package christmas.vo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import java.util.regex.Pattern;
import christmas.common.ErrorMessage;
import christmas.common.MyException;

public record MyDate(LocalDate date) {

    static final Set<LocalDate> SPECIAL_DATE = Set.of(
            LocalDate.of(2023, 12, 3),
            LocalDate.of(2023, 12, 10),
            LocalDate.of(2023, 12, 17),
            LocalDate.of(2023, 12, 24),
            LocalDate.of(2023, 12, 25),
            LocalDate.of(2023, 12, 31)
    );

    public static MyDate from(String input) {
        validate(input);
        return new MyDate(LocalDate.of(2023, 12, Integer.parseInt(input)));
    }

    private static void validate(String input) {
        validateFormat(input);
        validateRange(input);
    }

    private static void validateRange(String input) {
        int dayOfMonth = Integer.parseInt(input);
        if (dayOfMonth <= 0 | dayOfMonth >= 32) {
            throw new MyException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateFormat(String input) {
        String REGEX = "[0-9]{1,2}";
        if (!Pattern.matches(REGEX, input)) {
            throw new MyException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public boolean isSpecialDiscount() {
        return SPECIAL_DATE.contains(date);
    }

    public boolean isWeekend() {
        System.out.println("date.getDayOfWeek() = " + date.getDayOfWeek());
        return date.getDayOfWeek() == DayOfWeek.FRIDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
    }

    public boolean isWeekday() {
        return !isWeekend();
    }

    public boolean isDDayDiscount() {
        return date.getDayOfMonth() >= 1 && date.getDayOfMonth() <= 25;
    }
}
