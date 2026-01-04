package christmas.vo.order;

import christmas.common.ChristmasException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public record Order(Map<Menu, Integer> menus) {

    public static Order from(String input) {
        validateInput(input);

        Map<Menu, Integer> menus = getMenus(input);
        validateMenus(menus);

        return new Order(menus);
    }

    private static void validateMenus(Map<Menu, Integer> menus) {
        long zeroCount = menus.values().stream()
                .filter(count -> count < 1)
                .count();
        if (zeroCount != 0) {
            throw new ChristmasException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        int sum = menus.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        if (sum > 20) {
            throw new ChristmasException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        long foodCount = menus.keySet().stream()
                .filter(menu -> !menu.getCategory().equals("음료"))
                .count();
        if (foodCount == 0) {
            throw new ChristmasException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static Map<Menu, Integer> getMenus(String input) {
        Map<Menu, Integer> menus = new HashMap<>();

        String[] items = input.split(",");
        for (String item : items) {
            String[] nameAndCount = item.split("-");
            Menu menu = Menu.from(nameAndCount[0]);
            int count = Integer.parseInt(nameAndCount[1]);

            if (menus.containsKey(menu)) {
                throw new ChristmasException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            menus.put(menu, count);
        }
        return Map.copyOf(menus);
    }

    private static void validateInput(String input) {
        String REGEX = "^[가-힣]{3,8}-[0-9]{1,2}(,[가-힣]{3,8}-[0-9]{1,2})*$";
        if (!Pattern.matches(REGEX, input)) {
            throw new ChristmasException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
