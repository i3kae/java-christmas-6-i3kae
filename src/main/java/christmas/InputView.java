package christmas;

import camp.nextstep.edu.missionutils.Console;
import christmas.Messages.Main;
import java.util.Map;

public class InputView {
    private final Validator validator = new Validator();

    public Integer readDate() {
        String inputDate;
        do {
            inputDate = Console.readLine();
        } while(validator.visitDateChecker(inputDate));
        return Integer.parseInt(inputDate);
    }

    public Map<FoodMenu.MenuList, Integer> readPurchaseMenu(){
        String inputMenus;
        do {
            inputMenus = Console.readLine();
        } while(validator.purchaseChecker(inputMenus));
        return FoodMenu.makePurchaseMenus(inputMenus);
    }
}