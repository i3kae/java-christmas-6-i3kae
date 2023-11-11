package christmas;

public class FoodMenu {
    public enum Appetizer{
        MUSHROOM_SOUP("양송이수프", 6000),
        TAPAS("타파스", 5500),
        CAESAR_SALAD("시저샐러드", 8000);
        private final String menuName;
        private final Integer menuAmount;

        Appetizer(String menuName, Integer menuAmount) {
            this.menuName = menuName;
            this.menuAmount = menuAmount;
        }

        public String getName() {
            return menuName;
        }
        public Integer getAmount() {
            return menuAmount;
        }
    }

    public enum Main{
        T_BONE_STKAE("티본스테이크", 55000),
        BBQ_RIP("바비큐립", 54000),
        SEAFOOD_PASTA("해산물파스타", 35000),
        CHRISTMAS_PASTA("크리스마스파스타", 35000);
        private final String menuName;
        private final Integer menuAmount;

        Main(String menuName, Integer menuAmount) {
            this.menuName = menuName;
            this.menuAmount = menuAmount;
        }

        public String getName() {
            return menuName;
        }
        public Integer getAmount() {
            return menuAmount;
        }
    }

    public enum Dessert{
        CHOCORATE_CAKE("초코케이크", 15000),
        ICECREAM("아이스크림", 5000);
        private final String menuName;
        private final Integer menuAmount;

        Dessert(String menuName, Integer menuAmount) {
            this.menuName = menuName;
            this.menuAmount = menuAmount;
        }

        public String getName() {
            return menuName;
        }
        public Integer getAmount() {
            return menuAmount;
        }
    }

    public enum Drink{
        ZERO_COKE("제로콜라", 3000),
        RED_WINE("레드와인", 60000),
        CHAMPAGNE("샴페인", 25000);
        private final String menuName;
        private final Integer menuAmount;

        Drink(String menuName, Integer menuAmount) {
            this.menuName = menuName;
            this.menuAmount = menuAmount;
        }

        public String getName() {
            return menuName;
        }
        public Integer getAmount() {
            return menuAmount;
        }
    }
}
