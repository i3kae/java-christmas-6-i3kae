package christmas;

import christmas.EventCalculator.EventBadge;
import christmas.EventCalculator.EventType;
import christmas.FoodMenu.MenuList;
import christmas.Messages.AdditionalMessage;
import christmas.Messages.EventTitleMessage;
import christmas.Messages.Main;
import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    private static final String MENU_AND_COUNT = "%s %d개";
    private static final String EVENT_AND_DISCOUNT = "%s: -";
    private static final String AMOUNT_MESSAGE="원";
    private static final String THREE_NUMBER_FORMAT="###,###";
    private static final String NON_APPLIED = "없음";
    private static final String MINUS = "-";
    private static final String SEPERATOR_LINE = "-------------------------------------------------";
    private static final DecimalFormat decFormat = new DecimalFormat(THREE_NUMBER_FORMAT);
    public void printWelcome(){
        System.out.println(Main.WELCOME_MESSAGE.getMessage());
        System.out.println(AdditionalMessage.APPLIED_EVNET_AMOUNT);
    }
    public void printTotalPurchaseAmount(Integer amount){
        System.out.println(EventTitleMessage.TOTAL_PURCHASE_AMOUNT.getTitleMessage());
        System.out.println(decFormat.format(amount) + AMOUNT_MESSAGE);
    }
    public void printEventPreview(Customer customer){
        System.out.printf(Main.EVENT_BENEFIT_PREVIEW.getMessage() + "%n", customer.getVisitDate());
        printOrderMenus(customer.getPurchaseMenus());
        printTotalPurchaseAmount(customer.calcPurchaseAmount());
        printPresentEvent(customer.calcAppliedEvent());
        printAppliedEvent(customer.calcAppliedEvent());
        printTotalDiscount(customer.calcTotalDiscountedAmount());
        printEstimatedAmount(customer.calcPurchaseAmount() - customer.calcTotalDiscountedAmount());
        printEventBadge(customer.calcEventBadge());
    }
    private void printOrderMenus(Map<MenuList, Integer> purchaseMenus){
        System.out.println(EventTitleMessage.ORDER_MENU.getTitleMessage());
        for (MenuList ordered : purchaseMenus.keySet()){
            System.out.printf(MENU_AND_COUNT + "%n", ordered.getName(), purchaseMenus.get(ordered));
        }
    }
    private void printPresentEvent(Map<EventType, Integer> appliedEvents){
        System.out.println(EventTitleMessage.PRESENT_MENU.getTitleMessage());
        if (appliedEvents.containsKey(EventType.PRESENT)){
            System.out.printf(MENU_AND_COUNT + "%n", MenuList.CHAMPAGNE.getName(), 1);
            return;
        }
        System.out.println(NON_APPLIED);

    }
    private void printAppliedEvent(Map<EventType, Integer> appliedEvents){
        System.out.println(EventTitleMessage.APPLIED_EVENTS.getTitleMessage());
        if (appliedEvents.isEmpty()){
            System.out.println(NON_APPLIED);
            return;
        }
        for (EventType event : appliedEvents.keySet()){
            System.out.printf(EVENT_AND_DISCOUNT + decFormat.format(appliedEvents.get(event)) + AMOUNT_MESSAGE + "%n",
                    event.getEvent());
        }
    }
    private void printTotalDiscount(Integer totalDiscount){
        System.out.println(EventTitleMessage.TOTAL_DISCOUNT_AMOUNT.getTitleMessage());
        if (totalDiscount != 0){
            System.out.print(MINUS);
        }
        System.out.println(decFormat.format(totalDiscount) + AMOUNT_MESSAGE);
    }
    private void printEstimatedAmount(Integer estimatedAmount){
        System.out.println(EventTitleMessage.ESTIMATED_AMOUNT.getTitleMessage());
        System.out.println(decFormat.format(estimatedAmount) + AMOUNT_MESSAGE);
    }
    private void printEventBadge(EventBadge eventBadge){
        System.out.println(EventTitleMessage.EVENT_BADGE_MENU.getTitleMessage());
        System.out.println(eventBadge.getEventBadge());
    }
    public void printVisitDateAnnouncement(){
        System.out.println(Main.VISIT_MESSAGE.getMessage());
        System.out.println(AdditionalMessage.VISIT_DATE_RANGE.getMessage());
        System.out.println(AdditionalMessage.CHRISTMAS_RANGE_ANNOUNCEMENT.getMessage());
    }
    public void printPurchaseMenuAnnouncement(){
        System.out.println(Main.ORDER_MESSAGE.getMessage());
        System.out.println(AdditionalMessage.MAX_ORDER_COUNT.getMessage());
        System.out.println(AdditionalMessage.NOT_ORDER_ONLY_DRINK.getMessage());
    }
    public void printEventDetails(){
        printSeperator();
        System.out.println(AdditionalMessage.EVENT_LIST_ANNOUNCEMENT.getMessage());
        System.out.println(AdditionalMessage.CHRISTMAS_EVENT_ANNOUNCEMENT.getMessage());
        System.out.println(AdditionalMessage.WEEKDAY_EVENT_ANNOUNCEMENT.getMessage());
        System.out.println(AdditionalMessage.WEEKEND_EVENT_ANNOUNCEMENT.getMessage());
        System.out.println(AdditionalMessage.SPECIAL_EVENT_ANNOUNCEMENT.getMessage());
        System.out.println(AdditionalMessage.PRESENT_EVENT_ANNOUNCEMENT.getMessage());
        System.out.println(AdditionalMessage.EVENT_BADGE_ANNOUNCEMENT.getMessage());
        System.out.println(AdditionalMessage.NEW_YEAR_EVENT_ANNOUNCEMENT.getMessage());
        printSeperator();
    }
    public void printSeperator(){
        System.out.println(SEPERATOR_LINE);
    }
}
