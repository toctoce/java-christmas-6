package christmas.dto;

import christmas.vo.date.MyDate;

public record Dto(String content) {
    public static Dto from(MyDate myDate) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            sb.append("내용1")
                    .append("내용2")
                    .append("\n");
        }

        return new Dto(sb.toString());
    }
}
