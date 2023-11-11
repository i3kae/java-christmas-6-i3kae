package christmas;

import java.util.EnumMap;
import java.util.Map;

public class Customer{
    private Integer visitDate;
    private Map<FoodMenu, Integer> purchaseMenu = new EnumMap<>(FoodMenu.class);

    public Customer(Integer visitDate, Map<FoodMenu, Integer> purchaseMenu){
        this.visitDate = visitDate;
        this.purchaseMenu = purchaseMenu;
    }
}
