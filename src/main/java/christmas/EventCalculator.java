package christmas;

import christmas.FoodMenu.MenuList;
import christmas.FoodMenu.MenuType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventCalculator {
    private static final int WEEK = 7;
    private static final int CHRISTMAS = 25;
    private static final int CHRISTMAS_DEFAULT_DISCOUNT = 1000;
    private static final int CHRISTMAS_ADDITIONAL_DISCOUNT = 100;
    private static final int FIRST_DAY = 1;
    private static final int PRESENT_EVENT_AMOUNT = 120000;

    public enum WeekList{
        FRIDAY, SATURDAY, SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY;
    }
    public enum EventType{
        WEEKDAY, WEEKEND, CHRISTMAS, SPECIAL, PRESENT;
    }
    public enum EventBadge{
        STAR, TREE, SANTA;
    }
    private static final int DISCOUNT_WEEK = 2023;
    public List<EventType> calcEventList(Integer visitDate, Integer purchaseAmount){
        List<EventType> appliedEvent = calcSaleEvent(visitDate);
        if (isPresentEvent(purchaseAmount)){
            appliedEvent.add(EventType.PRESENT);
        }
        return appliedEvent;
    }
    public List<EventType> calcSaleEvent(Integer visitDate){
        List<EventType> appliedEvent = new ArrayList<>();
        if (isChristmasDDay(visitDate)){
            appliedEvent.add(EventType.CHRISTMAS);
        }
        if (isWeekend(visitDate)){
            appliedEvent.add(EventType.WEEKEND);
        }
        if (!isWeekend(visitDate)){
            appliedEvent.add(EventType.WEEKDAY);
        }
        if (isSpecialDay(visitDate)){
            appliedEvent.add(EventType.SPECIAL);
        }
        return appliedEvent;
    }
    public Integer weekdayEvent(Map<MenuList, Integer> purchaseMenus){
        int discountedAmount = 0;
        for (MenuList menu : purchaseMenus.keySet()){
            if (menu.getMenuType() == MenuType.DESSERT){
                discountedAmount += purchaseMenus.get(menu) * DISCOUNT_WEEK;
            }
        }
        return discountedAmount;
    }
    public Integer weekendEvent(Map<MenuList, Integer> purchaseMenus){
        int discountedAmount = 0;
        for (MenuList menu : purchaseMenus.keySet()){
            if (menu.getMenuType() == MenuType.MAIN){
                discountedAmount += purchaseMenus.get(menu) * DISCOUNT_WEEK;
            }
        }
        return discountedAmount;
    }
    public Integer christmasEvent(Integer visitDate){
        if (isChristmasDDay(visitDate)) {
            return CHRISTMAS_DEFAULT_DISCOUNT + CHRISTMAS_ADDITIONAL_DISCOUNT * (visitDate - 1);
        }
        return 0;
    }
    public Integer specialEvent(Integer visitDate){
        if (isSpecialDay(visitDate)){
            return 1000;
        }
        return 0;
    }
    public boolean isWeekend(Integer date){
        if ((date - 1) % WEEK == WeekList.SATURDAY.ordinal() || (date - 1) % WEEK == WeekList.SUNDAY.ordinal()){
            return true;
        }
        return false;
    }
    public boolean isSpecialDay(Integer date){
        if ((date - 1) % WEEK == WeekList.SUNDAY.ordinal() || date == CHRISTMAS){
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
