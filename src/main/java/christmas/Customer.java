package christmas;

import christmas.EventCalculator.EventBadge;
import christmas.EventCalculator.EventType;
import christmas.FoodMenu.MenuList;
import java.util.Map;

public class Customer{
    private Integer visitDate;
    private Map<FoodMenu.MenuList, Integer> purchaseMenus;
    private static final EventCalculator eventCalculator = new EventCalculator();

    public Customer(Integer visitDate, Map<FoodMenu.MenuList, Integer> purchaseMenus){
        this.visitDate = visitDate;
        this.purchaseMenus = purchaseMenus;
    }

    public Integer calcPurchaseAmount(){
        Integer calcResult = 0;
        for (FoodMenu.MenuList menuName : purchaseMenus.keySet()){
            calcResult += purchaseMenus.get(menuName) * menuName.getAmount();
        }
        return calcResult;
    }
    public Map<EventType, Integer> calcAppliedEvent(){
        return eventCalculator.calcEventList(visitDate, calcPurchaseAmount(), purchaseMenus);
    }
    public Integer calcTotalDiscountedAmount(){
        return eventCalculator.calcTotalDiscount(visitDate, purchaseMenus, calcPurchaseAmount());
    }
    public EventBadge calcEventBadge(){
        return eventCalculator.calcEventBadge(calcTotalDiscountedAmount());
    }
    public Integer getVisitDate(){
        return visitDate;
    }
    public Map<MenuList, Integer> getPurchaseMenus(){
        return purchaseMenus;
    }
}
