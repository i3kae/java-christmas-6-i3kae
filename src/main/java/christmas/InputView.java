package christmas;

import camp.nextstep.edu.missionutils.Console;
import christmas.Messages.Main;
import java.util.Map;

public class InputView {
    private final Validator validator = new Validator();

    public Integer readDate() {
        System.out.println(Main.VISIT_MESSAGE.getMessage());
        String inputDate;
        do {
            inputDate = Console.readLine();
        } while(validator.visitDateChecker(inputDate));
        return Integer.parseInt(inputDate);
    }

    public Map<FoodMenu.MenuList, Integer> readPurchaseMenu(){
        String inputMenus;
        System.out.println(Main.ORDER_MESSAGE.getMessage());
        do {
            inputMenus = Console.readLine();
        } while(validator.purchaseChecker(inputMenus));
        return FoodMenu.makePurchaseMenus(inputMenus);
    }
}