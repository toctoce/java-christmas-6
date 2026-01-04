package christmas.view;

import christmas.dto.ResultDto;
import christmas.vo.date.MyDate;

public class OutputView {

    public void write(String message) {
        System.out.println(message);
    }

    public void writeDefaultMessage() {
        write("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void writeDateMessage() {
        write("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public void writeOrderMessage() {
        write("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public void writeTitle(MyDate date) {
        write(String.format("%s에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", date.toString()));
    }

    public void writeResult(ResultDto dto) {
        write(dto.content());
    }
}
