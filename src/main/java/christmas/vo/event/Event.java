package christmas.vo.event;

import christmas.vo.date.MyDate;
import christmas.vo.order.Menu;
import christmas.vo.order.Order;

public record Event(Order order, MyDate date) {

    private boolean isLowerThan10000() {
        return order.getOriginalPrice() < 10000;
    }

    public int getWeekdayDiscount() {
        if (isLowerThan10000() || !date.isWeekday()) {
            return 0;
        }
        return order.getCategoryCount("디저트") * 2023;
    }

    public int getWeekendDiscount() {
        if (isLowerThan10000() || !date.isWeekend()) {
            return 0;
        }
        return order.getCategoryCount("메인") * 2023;
    }

    public int getSpecialDiscount() {
        if (isLowerThan10000() || !date.isSpecialDiscount()) {
            return 0;
        }
        return 1000;
    }

    public int getDDayDiscount() {
        if (isLowerThan10000() || !date.isDDayDiscount()) {
            return 0;
        }
        return 900 + date.date().getDayOfMonth() * 100;
    }

    public Menu getGift() {
        if (isLowerThan10000() || order.getOriginalPrice() < 120_000) {
            return null;
        }
        return Menu.from("샴페인");
    }

    public int getGiftPrice() {
        if (getGift() == null) {
            return 0;
        }
        return getGift().getPrice();
    }

    public int getDiscount() {
        return getDDayDiscount() + getWeekdayDiscount() + getWeekendDiscount() + getSpecialDiscount();
    }

    public int getTotalBenefit() {
        return getDiscount() + getGiftPrice();
    }

    public int getTotalPrice() {
        return order.getOriginalPrice() - getDiscount();
    }

    public String getBadge() {
        if (getTotalBenefit() >= 20000) {
            return "산타";
        }
        if (getTotalBenefit() >= 10000) {
            return "트리";
        }
        if (getTotalBenefit() >= 5000) {
            return "별";
        }
        return null;
    }
}
