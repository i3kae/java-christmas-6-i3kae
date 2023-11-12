package christmas;

import java.util.Map;

public class Customer{
    private Integer visitDate;
    private Map<FoodMenu.MenuList, Integer> purchaseMenus;

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

}
