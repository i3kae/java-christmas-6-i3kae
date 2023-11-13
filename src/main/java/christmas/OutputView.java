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
    private static final String TOTAL_DISCOUNT_AMOUNT = "<총혜택 금액>";
    private static final String ESTIMATED_AMOUNT = "<할인 후 예상 결제 금액>";
    private static final String EVENT_BADGE_MENU = "<12월 이벤트 배지>";
    private static final String MENU_AND_COUNT = "%s %d개";
    private static final String EVENT_AND_DISCOUNT = "%s: -";
    private static final String AMOUNT_MESSAGE="원";
    private static final String THREE_NUMBER_FORMAT="###,###";
    private static final String NON_APPLIED = "없음";
    private static final String MINUS = "-";
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
    public void printAppliedEvent(Map<EventType, Integer> appliedEvents){
        System.out.println(APPLIED_EVENTS);
        if (appliedEvents.isEmpty()){
            System.out.println(NON_APPLIED);
            return;
        }
        for (EventType event : appliedEvents.keySet()){
            System.out.printf(EVENT_AND_DISCOUNT + decFormat.format(appliedEvents.get(event) + AMOUNT_MESSAGE),
                    event.getEvent());
        }
    }
    public void printTotalDiscount(Integer totalDiscount){
        System.out.println(TOTAL_DISCOUNT_AMOUNT);
        if (totalDiscount != 0){
            System.out.print(MINUS);
        }
        System.out.println(decFormat.format(totalDiscount) + AMOUNT_MESSAGE);
    }
    public void printEstimatedAmount(Integer estimatedAmount){
        System.out.println(ESTIMATED_AMOUNT);
        System.out.println(decFormat.format(estimatedAmount) + AMOUNT_MESSAGE);
    }
    public void printEventBadge(EventBadge eventBadge){
        System.out.println(EVENT_BADGE_MENU);
        System.out.println(eventBadge.getEventBadge());
    }
}
