package christmas;

import christmas.Messages.ErrorMessage;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class FoodMenu {
    private static final String COMMA = ",";
    private static final String HYPEN = "-";
    public enum MenuType{
        APPETIZER, MAIN, DESSERT, DRINK
    }
    public enum MenuList{
        MUSHROOM_SOUP("양송이수프", 6000, MenuType.APPETIZER),
        TAPAS("타파스", 5500, MenuType.APPETIZER),
        CAESAR_SALAD("시저샐러드", 8000, MenuType.APPETIZER),
        T_BONE_STKAE("티본스테이크", 55000, MenuType.MAIN),
        BBQ_RIP("바비큐립", 54000, MenuType.MAIN),
        SEAFOOD_PASTA("해산물파스타", 35000, MenuType.MAIN),
        CHRISTMAS_PASTA("크리스마스파스타", 35000, MenuType.MAIN),
        CHOCORATE_CAKE("초코케이크", 15000, MenuType.DESSERT),
        ICECREAM("아이스크림", 5000, MenuType.DESSERT),
        ZERO_COKE("제로콜라", 3000, MenuType.DRINK),
        RED_WINE("레드와인", 60000, MenuType.DRINK),
        CHAMPAGNE("샴페인", 25000, MenuType.DRINK);

        private final String menuName;
        private final Integer menuAmount;
        private final MenuType menuType;

        MenuList(String menuName, Integer menuAmount, MenuType menuType) {
            this.menuName = menuName;
            this.menuAmount = menuAmount;
            this.menuType = menuType;
        }

        public String getName() {
            return menuName;
        }
        public Integer getAmount() {
            return menuAmount;
        }
        public MenuType getMenuType(){
            return menuType;
        }

        public static MenuList findMenu(String menu) {
            return Arrays.stream(MenuList.values())
                    .filter(operator -> operator.menuName.equals(menu))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_IN_MENULIST.getMessage()));
        }
    }

    public static Map<MenuList, Integer> makePurchaseMenus(String userInput){
        Map<MenuList, Integer> purchaseMenus = new EnumMap<>(MenuList.class);
        for (String splitedComma : userInput.split(COMMA)){
            purchaseMenus.put(MenuList.findMenu(splitedComma.split(HYPEN)[0]),
                    Integer.parseInt(splitedComma.split(HYPEN)[1]));
        }
        return purchaseMenus;
    }
}
