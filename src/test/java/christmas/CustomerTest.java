package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.FoodMenu.Appetizer;
import christmas.FoodMenu.Dessert;
import christmas.FoodMenu.Drink;
import christmas.FoodMenu.Main;
import java.util.EnumMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    @Test
    @DisplayName("총구매 금액 계산 테스트 - 정상적인 경우")
    void totalPurchaseAmountTest(){
        EnumMap<FoodMenu.Appetizer, Integer> appetizerList = new EnumMap<>(FoodMenu.Appetizer.class);
        EnumMap<FoodMenu.Main, Integer> mainList = new EnumMap<>(FoodMenu.Main.class);
        EnumMap<FoodMenu.Dessert, Integer> dessertList = new EnumMap<>(FoodMenu.Dessert.class);
        EnumMap<FoodMenu.Drink, Integer> drinkList = new EnumMap<>(FoodMenu.Drink.class);
        Customer customer;
        appetizerList.put(Appetizer.TAPAS, 10);
        mainList.put(Main.BBQ_RIP, 2);
        dessertList.put(Dessert.CHOCORATE_CAKE, 3);
        drinkList.put(Drink.RED_WINE, 1);
        customer = new Customer(1, appetizerList, mainList, dessertList, drinkList);
        assertThat(customer.calcPurchaseAmount()).isEqualTo(268000);
    }
}
