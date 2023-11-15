package christmas;

import christmas.EventCalculator.EventBadge;
import christmas.EventCalculator.EventType;
import christmas.FoodMenu.MenuList;
import java.util.Map;

public class Customer{
    private static final Integer MINIMUN_PRESENT_AMOUNT = 120000;
    private final Integer visitDate;
    private final Map<FoodMenu.MenuList, Integer> purchaseMenus;
    private static final EventCalculator eventCalculator = new EventCalculator();

    public Customer(Integer visitDate, Map<FoodMenu.MenuList, Integer> purchaseMenus){
        this.visitDate = visitDate;
        this.purchaseMenus = purchaseMenus;
    }

    public Integer calcPurchaseAmount(){
        int calcResult = 0;
        for (FoodMenu.MenuList menuName : purchaseMenus.keySet()){
            calcResult += purchaseMenus.get(menuName) * menuName.getAmount();
        }
        return calcResult;
    }
    public Map<EventType, Integer> calcAppliedEvent(){
        return eventCalculator.calcEventList(visitDate, calcPurchaseAmount(), purchaseMenus);
    }
    public Integer calcTotalBenefitAmount(){
        return eventCalculator.calcTotalDiscount(visitDate, purchaseMenus, calcPurchaseAmount());
    }
    public EventBadge calcEventBadge(){
        return eventCalculator.calcEventBadge(calcTotalBenefitAmount());
    }
    public Integer getVisitDate(){
        return visitDate;
    }
    public Map<MenuList, Integer> getPurchaseMenus(){
        return purchaseMenus;
    }
    public Integer calcTotalDiscountAmount(){
        if (calcPurchaseAmount() >= MINIMUN_PRESENT_AMOUNT){
            return calcTotalBenefitAmount() - MenuList.CHAMPAGNE.getAmount();
        }
        return calcTotalBenefitAmount();
    }
}
