package christmas;

import christmas.EventCalculator.EventBadge;
import christmas.EventCalculator.EventType;
import christmas.FoodMenu.MenuList;
import christmas.Messages.Main;
import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private static final String TOTAL_PURCHASE_AMOUNT="<할인 전 총주문 금액>";
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String PRESENT_MENU = "<증정 메뉴>";
    private static final String APPLIED_EVENTS = "<혜택 내역>";
    private static final String MENU_AND_COUNT = "%s %d개";
    private static final String EVENT_AND_DISCOUNT = "%s: -";
    private static final String AMOUNT_MESSAGE="원";
    private static final String THREE_NUMBER_FORMAT="###,###";
    private static final String NON_APPLIED = "없음";
    private static final DecimalFormat decFormat = new DecimalFormat(THREE_NUMBER_FORMAT);
    public void printWelcome(){
        System.out.println(Main.WELCOME_MESSAGE.getMessage());
    }
    public void printTotalPurchaseAmount(Integer amount){
        System.out.println(TOTAL_PURCHASE_AMOUNT);
        System.out.println(decFormat.format(amount) + AMOUNT_MESSAGE);
    }
    public void printEventPreview(Integer visitDate){
        System.out.printf(Main.EVENT_BENEFIT_PREVIEW.getMessage() + "%n", visitDate);
    }
    public void printOrderMenus(Map<MenuList, Integer> purchaseMenus){
        System.out.println(ORDER_MENU);
        for (MenuList ordered : purchaseMenus.keySet()){
            System.out.printf(MENU_AND_COUNT + "%n", ordered.getName(), purchaseMenus.get(ordered));
        }
    }
    public void printPresentEvent(Map<EventType, Integer> appliedEvents){
        System.out.println(PRESENT_MENU);
        if (appliedEvents.containsKey(EventType.PRESENT)){
            System.out.printf(MENU_AND_COUNT + "%n", MenuList.CHAMPAGNE.getName(), 1);
            return;
        }
        System.out.println(NON_APPLIED);

    }
    public void printAppliedEvent(Customer customer){

    }
    public void printTotalDiscount(Integer totalDiscount){

    }
    public void printEstimatedAmount(Integer estimatedAmount){

    }
    public void printEventBadge(EventBadge eventBadge){

    }
}
