package christmas.dto;

import christmas.vo.event.Event;
import christmas.vo.order.Order;

public record ResultDto(String content) {
    public static ResultDto from(Event event) {
        StringBuilder sb = new StringBuilder();

        sb.append(getOrderedMenus(event.order())).append("\n");
        sb.append(getOriginalPrice(event.order())).append("\n");
        sb.append(getGift(event)).append("\n");
        sb.append(getBenefitDetail(event)).append("\n");
        sb.append(getTotalBenefit(event)).append("\n");
        sb.append(getTotalPrice(event)).append("\n");
        sb.append(getBadge(event));

        return new ResultDto(sb.toString());
    }

    private static String getOrderedMenus(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("<주문 메뉴>\n");
        order.menus().keySet().forEach(
                menu -> sb.append(String.format("%s %d개\n", menu.getKor(), order.menus().get(menu)))
        );

        return sb.toString();
    }

    private static String getOriginalPrice(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("<할인 전 총주문 금액>\n");
        sb.append(getPriceFormat(order.getOriginalPrice()) + "\n");

        return sb.toString();
    }

    private static String getGift(Event event) {
        StringBuilder sb = new StringBuilder();
        sb.append("<증정 메뉴>\n");
//        todo: 수정
        sb.append("샴페인 1개\n");

        return sb.toString();
    }

    private static String getBenefitDetail(Event event) {
        StringBuilder sb = new StringBuilder();
        sb.append("<혜택 내역>\n");

        int dDayDiscount = event.getDDayDiscount();
        int weekdayDiscount = event.getWeekdayDiscount();
        int weekendDiscount = event.getWeekendDiscount();
        int specialDiscount = event.getSpecialDiscount();
        int gift = event.getGift();

        if (dDayDiscount == 0 && weekdayDiscount == 0 && weekendDiscount == 0 && specialDiscount == 0 && gift == 0) {
            sb.append("없음\n");
            return sb.toString();
        }

        if (dDayDiscount != 0) {
            sb.append(String.format("크리스마스 디데이 할인: -%s\n", getPriceFormat(dDayDiscount)));
        }
        if (weekdayDiscount != 0) {
            sb.append(String.format("평일 할인: -%s\n", getPriceFormat(weekdayDiscount)));
        }
        if (weekendDiscount != 0) {
            sb.append(String.format("주말 할인: -%s\n", getPriceFormat(weekendDiscount)));
        }
        if (specialDiscount != 0) {
            sb.append(String.format("특별 할인: -%s\n", getPriceFormat(specialDiscount)));
        }
        if (gift != 0) {
            sb.append(String.format("증정 이벤트: -%s\n", getPriceFormat(gift)));
        }

        return sb.toString();
    }

    private static String getTotalBenefit(Event event) {
        StringBuilder sb = new StringBuilder();
        sb.append("<총혜택 금액>\n");
        sb.append(String.format("-%s\n", getPriceFormat(event.getTotalBenefit())));

        return sb.toString();
    }

    private static String getTotalPrice(Event event) {
        StringBuilder sb = new StringBuilder();
        sb.append("<할인 후 예상 결제 금액>\n");
        sb.append(String.format("%s\n", getPriceFormat(event.getTotalPrice())));

        return sb.toString();
    }

    private static String getBadge(Event event) {
        StringBuilder sb = new StringBuilder();
        sb.append("<12월 이벤트 배지>\n");
        String badge = event.getBadge();

        if (badge == null) {
            sb.append("없음\n");
            return sb.toString();
        }
        sb.append(badge + "\n");

        return sb.toString();
    }

    private static String getPriceFormat(int price) {
        return String.format("%,d원", price);
    }
}
