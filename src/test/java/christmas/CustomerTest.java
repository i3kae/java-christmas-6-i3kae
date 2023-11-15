package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.FoodMenu.MenuList;
import java.util.EnumMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    Customer customer;
    CustomerTest(){
        EnumMap<FoodMenu.MenuList, Integer> purchaseMenus = new EnumMap<>(FoodMenu.MenuList.class);
        purchaseMenus.put(MenuList.TAPAS, 10);
        purchaseMenus.put(MenuList.BBQ_RIP, 2);
        purchaseMenus.put(MenuList.CHOCORATE_CAKE, 3);
        purchaseMenus.put(MenuList.RED_WINE, 1);
        customer = new Customer(25, purchaseMenus);
    }
    @Test
    @DisplayName("총구매 금액 계산 테스트 | 총구매 금액 테스트")
    void totalPurchaseAmountTest(){
        assertThat(customer.calcPurchaseAmount()).isEqualTo(268000);
    }
}
