package christmas.dto;

import christmas.vo.date.MyDate;

public record ResultDto(String content) {
    public static ResultDto from(MyDate myDate) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            sb.append("내용1")
                    .append("내용2")
                    .append("\n");
        }

        return new ResultDto(sb.toString());
    }
}
