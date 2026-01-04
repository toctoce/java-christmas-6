package christmas.vo.order;

import christmas.common.ChristmasException;
import java.util.stream.Stream;

public enum Menu {

    YANGSONG("양송이수프", 6000, "에피타이저"),
    TAPA("타파스", 5500, "에피타이저"),
    SIGER("시저샐러드", 8000, "에피타이저"),

    TIBON("티본스테이크", 55000, "메인"),
    BABI("바비큐립", 54000, "메인"),
    HAESAN("해산물파스타", 35000, "메인"),
    CHRI("크리스마스파스타", 25000, "메인"),

    CHOCO("초코케이크", 15000, "디저트"),
    I("아이스크림", 5000, "디저트"),

    ZERO("제로콜라", 3000, "음료"),
    RED("레드와인", 60000, "음료"),
    SHAMPE("샴페인", 25000, "음료");

    private final String kor;
    private final int price;
    private final String category;

    public String getKor() {
        return kor;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    Menu(String kor, int price, String category) {
        this.kor = kor;
        this.price = price;
        this.category = category;
    }

    public static Menu from(String kor) {
        return Stream.of(Menu.values())
                .filter(menu -> menu.getKor().equals((kor)))
                .findFirst()
                .orElseThrow(() -> new ChristmasException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."));
    }
}
