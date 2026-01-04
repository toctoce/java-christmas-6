package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.vo.date.MyDate;

public class InputView {

    public String read() {
        return Console.readLine();
    }

    public MyDate readDate() {
        return MyDate.from(read());
    }

}
