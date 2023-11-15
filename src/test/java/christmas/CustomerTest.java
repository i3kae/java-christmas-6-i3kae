package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.EventCalculator.EventBadge;
import christmas.EventCalculator.EventType;
import christmas.FoodMenu.MenuList;
import java.util.EnumMap;
import java.util.Map;
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
    @Test
    @DisplayName("총구매 금액 계산 테스트 | 총혜택 금액 테스트")
    void totalDiscountAmountTest(){
        assertThat(customer.calcTotalBenefitAmount()).isEqualTo(35469);
    }
    @Test
    @DisplayName("총구매 금액 계산 테스트 | 적용 이벤트 테스트")
    void appliedEventTest(){
        Map<EventType, Integer> appliedEvents = new EnumMap<>(EventType.class);
        appliedEvents.put(EventType.WEEKDAY, 6069);
        appliedEvents.put(EventType.CHRISTMAS, 3400);
        appliedEvents.put(EventType.SPECIAL, 1000);
        appliedEvents.put(EventType.PRESENT, 25000);
        assertThat(customer.calcAppliedEvent()).isEqualTo(appliedEvents);
    }
    @Test
    @DisplayName("총구매 금액 계산 테스트 | 이벤트 배지 테스트")
    void eventBadgeTest(){
        assertThat(customer.calcEventBadge()).isEqualTo(EventBadge.SANTA);
    }
}
