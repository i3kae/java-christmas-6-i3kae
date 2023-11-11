package christmas;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Customer{
    private Integer visitDate;
    private Map<FoodMenu.Appetizer, Integer> appetizerMenu;

    private Map<FoodMenu.Main, Integer> mainMenu;

    private Map<FoodMenu.Dessert, Integer> dessertMenu;

    private Map<FoodMenu.Drink, Integer> drinkMenu;

    public Customer(Integer visitDate,
                    Map<FoodMenu.Appetizer, Integer> appetizerMenu,
                    Map<FoodMenu.Main, Integer> mainMenu,
                    Map<FoodMenu.Dessert, Integer> dessertMenu,
                    Map<FoodMenu.Drink, Integer> drinkMenu){
        this.visitDate = visitDate;
        this.appetizerMenu = appetizerMenu;
        this.mainMenu = mainMenu;
        this.dessertMenu = dessertMenu;
        this.drinkMenu = drinkMenu;
    }

    public Integer calcPurchaseAmount(){
        Integer calcResult = 0;
        calcResult += calcAppetizerAmount();
        calcResult += calcMainAmount();
        calcResult += calcDesserAmount();
        calcResult += calcDrinkAmount();
        return calcResult;
    }

    private Integer calcAppetizerAmount(){
        Integer calcResult = 0;
        for (FoodMenu.Appetizer menuName : appetizerMenu.keySet()){
            calcResult += appetizerMenu.get(menuName) * menuName.getAmount();
        }
        return calcResult;
    }
    private Integer calcMainAmount(){
        Integer calcResult = 0;
        for (FoodMenu.Main menuName : mainMenu.keySet()){
            calcResult += mainMenu.get(menuName) * menuName.getAmount();
        }
        return calcResult;
    }
    private Integer calcDesserAmount(){
        Integer calcResult = 0;
        for (FoodMenu.Dessert menuName : dessertMenu.keySet()){
            calcResult += dessertMenu.get(menuName) * menuName.getAmount();
        }
        return calcResult;
    }
    private Integer calcDrinkAmount(){
        Integer calcResult = 0;
        for (FoodMenu.Drink menuName : drinkMenu.keySet()){
            calcResult += drinkMenu.get(menuName) * menuName.getAmount();
        }
        return calcResult;
    }
}
