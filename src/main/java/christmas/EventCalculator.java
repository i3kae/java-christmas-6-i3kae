package christmas;

import christmas.FoodMenu.MenuList;
import christmas.FoodMenu.MenuType;
import java.util.EnumMap;
import java.util.Map;

public class EventCalculator {
    private static final int WEEK = 7;
    private static final int CHRISTMAS = 25;
    private static final int CHRISTMAS_DEFAULT_DISCOUNT = 1000;
    private static final int CHRISTMAS_ADDITIONAL_DISCOUNT = 100;
    private static final int FIRST_DAY = 1;
    private static final int PRESENT_EVENT_AMOUNT = 120000;
    private static final int SPECIAL_DISCOUNT = 1000;
    private static final int SATURDAY = 1;
    private static final int SUNDAY = 2;
    private static final int DISCOUNT_WEEK = 2023;
    public enum EventType{
        WEEKDAY("평일 할인"),
        WEEKEND("주말 할인"),
        CHRISTMAS("크리스마스 디데이 할인"),
        SPECIAL("특별 할인"),
        PRESENT("증정 이벤트");

        private final String event;
        EventType(String event){
            this.event = event;
        }
        public String getEvent(){
            return event;
        }
    }
    public enum EventBadge{
        NON("없음"),
        STAR("별"),
        TREE("트리"),
        SANTA("산타");
        private final String eventBadge;
        EventBadge(String eventBadge){
            this.eventBadge = eventBadge;
        }
        public String getEventBadge(){
            return eventBadge;
        }
    }
    public Map<EventType, Integer> calcEventList(Integer visitDate, Integer purchaseAmount,
                                                 Map<MenuList, Integer> purchaseMenus){
        Map<EventType, Integer> appliedEvent = calcSaleEvent(visitDate, purchaseMenus);
        if (isPresentEvent(purchaseAmount)){
            appliedEvent.put(EventType.PRESENT, calcPresentEvent(purchaseAmount));
        }
        return appliedEvent;
    }
    public Map<EventType, Integer> calcSaleEvent(Integer visitDate, Map<MenuList, Integer> purchaseMenus){
        Map<EventType, Integer> appliedEvent = new EnumMap<>(EventType.class);
        if (isChristmasDDay(visitDate)){
            appliedEvent.put(EventType.CHRISTMAS, calcChristmasEvent(visitDate));
        }
        if (isWeekend(visitDate, purchaseMenus)){
            appliedEvent.put(EventType.WEEKEND, calcWeekendEvent(purchaseMenus));
        }
        if (isWeekday(visitDate, purchaseMenus)){
            appliedEvent.put(EventType.WEEKDAY, calcWeekdayEvent(purchaseMenus));
        }
        if (isSpecialDay(visitDate)){
            appliedEvent.put(EventType.SPECIAL, calcSpecialEvent(visitDate));
        }
        return appliedEvent;
    }
    public Integer calcWeekdayEvent(Map<MenuList, Integer> purchaseMenus){
        int discountedAmount = 0;
        for (MenuList menu : purchaseMenus.keySet()){
            if (menu.getMenuType() == MenuType.DESSERT){
                discountedAmount += purchaseMenus.get(menu) * DISCOUNT_WEEK;
            }
        }
        return discountedAmount;
    }
    public Integer calcWeekendEvent(Map<MenuList, Integer> purchaseMenus){
        int discountedAmount = 0;
        for (MenuList menu : purchaseMenus.keySet()){
            if (menu.getMenuType() == MenuType.MAIN){
                discountedAmount += purchaseMenus.get(menu) * DISCOUNT_WEEK;
            }
        }
        return discountedAmount;
    }
    public Integer calcChristmasEvent(Integer visitDate){
        if (isChristmasDDay(visitDate)) {
            return CHRISTMAS_DEFAULT_DISCOUNT + CHRISTMAS_ADDITIONAL_DISCOUNT * (visitDate - 1);
        }
        return 0;
    }
    public Integer calcSpecialEvent(Integer visitDate){
        if (isSpecialDay(visitDate)){
            return SPECIAL_DISCOUNT;
        }
        return 0;
    }
    public Integer calcPresentEvent(Integer purchaseAmount){
        if (isPresentEvent(purchaseAmount)){
            return MenuList.CHAMPAGNE.getAmount();
        }
        return 0;
    }
    public Integer calcTotalDiscount(Integer visitDate, Map<MenuList, Integer> purchaseMenus, Integer purchaseAmount){
        int discountAmount = 0;
        discountAmount += calcChristmasEvent(visitDate);
        if (isWeekend(visitDate, purchaseMenus)){
            discountAmount += calcWeekendEvent(purchaseMenus);
        }
        if (isWeekday(visitDate, purchaseMenus)){
            discountAmount += calcWeekdayEvent(purchaseMenus);
        }
        discountAmount += calcSpecialEvent(visitDate);
        discountAmount += calcPresentEvent(purchaseAmount);
        return discountAmount;
    }
    public EventBadge calcEventBadge(Integer totalDiscount){
        if (totalDiscount >= 20000){
            return EventBadge.SANTA;
        }
        if (totalDiscount >= 10000){
            return EventBadge.TREE;
        }
        if (totalDiscount >= 5000){
            return EventBadge.STAR;
        }
        return EventBadge.NON;
    }
    public boolean isWeekend(Integer date, Map<MenuList, Integer> purchaseMenus){
        if (!((date - 1) % WEEK == SATURDAY || (date - 1) % WEEK == SUNDAY)){
            return false;
        }
        for (MenuList menu : purchaseMenus.keySet()){
            if (menu.getMenuType() == MenuType.MAIN){
                return true;
            }
        }
        return false;
    }
    public boolean isWeekday(Integer date, Map<MenuList, Integer> purchaseMenus){
        if ((date - 1) % WEEK == SATURDAY || (date - 1) % WEEK == SUNDAY){
            return false;
        }
        for (MenuList menu : purchaseMenus.keySet()){
            if (menu.getMenuType() == MenuType.DESSERT){
                return true;
            }
        }
        return false;
    }
    public boolean isSpecialDay(Integer date){
        if ((date - 1) % WEEK == SUNDAY || date == CHRISTMAS){
            return true;
        }
        return false;
    }
    public boolean isChristmasDDay(Integer date){
        if (FIRST_DAY <= date && date <= CHRISTMAS){
            return true;
        }
        return false;
    }
    public boolean isPresentEvent(Integer purchaseAmount){
        if (PRESENT_EVENT_AMOUNT <= purchaseAmount){
            return true;
        }
        return false;
    }
}
