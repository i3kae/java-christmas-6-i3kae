package christmas;

import christmas.FoodMenu.MenuList;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EventCalculatorTest {
    private static final String DISPLAY_PARAMETERIZED_TEST = "{displayName} - [\"{0}\"]";
    private final Customer customer;
    private final EventCalculator eventCalculator;
    EventCalculatorTest(){
        Map<MenuList, Integer> menus = new EnumMap<>(MenuList.class);
        eventCalculator = new EventCalculator();
        menus.put(MenuList.BBQ_RIP, 3);
        menus.put(MenuList.T_BONE_STKAE, 2);
        menus.put(MenuList.CHRISTMAS_PASTA, 4);
        menus.put(MenuList.CHOCORATE_CAKE, 1);
        menus.put(MenuList.ICECREAM, 5);
        menus.put(MenuList.TAPAS, 2);
        menus.put(MenuList.RED_WINE, 1);
        customer = new Customer(25, menus);
    }
    @Test
    @DisplayName("이벤트 적용 계산 테스트 | 평일 이벤트 결과")
    void weekdayEventResultTest(){
        assertThat(eventCalculator.calcWeekdayEvent(customer.getPurchaseMenus())).isEqualTo(2023 * 6);
    }
    @Test
    @DisplayName("이벤트 적용 계산 테스트 | 주말 이벤트 결과")
    void weekendEventResultTest(){
        assertThat(eventCalculator.calcWeekendEvent(customer.getPurchaseMenus())).isEqualTo(2023 * 9);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("이벤트 적용 계산 테스트 | 증정 이벤트 결과")
    @CsvSource(value = {"0:0", "10000:0", "120000:25000", "3000000:25000"}, delimiter = ':')
    void presentEventResultTest(Integer input, Integer result){
        assertThat(eventCalculator.calcPresentEvent(input)).isEqualTo(result);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("이벤트 적용 계산 테스트 | 크리스마스 이벤트 결과")
    @CsvSource(value = {"1:1000", "10:1900", "25:3400", "26:0", "31:0"}, delimiter = ':')
    void christmasEventResultTest(Integer input, Integer result){
        assertThat(eventCalculator.calcChristmasEvent(input)).isEqualTo(result);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("이벤트 적용 계산 테스트 | 특별 이벤트 결과")
    @CsvSource(value = {"1:0", "8:0", "3:1000", "10:1000", "25:1000"}, delimiter = ':')
    void specialEventResultTest(Integer input, Integer result){
        assertThat(eventCalculator.calcSpecialEvent(input)).isEqualTo(result);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("이벤트 적용 계산 테스트 | 이벤트 배지 결과")
    @CsvSource(value = {"4000:없음", "6000:별", "10000:트리", "21000:산타"}, delimiter = ':')
    void eventBadgeResultTest(Integer input, String result){
        assertThat(eventCalculator.calcEventBadge(input).getEventBadge()).isEqualTo(result);
    }
    @Test
    @DisplayName("이벤트 적용 계산 테스트 | 총할인 금액 결과")
    void calcTotalDiscountTest(){
        assertThat(eventCalculator.calcTotalDiscount(customer.getVisitDate(),
                customer.getPurchaseMenus(),
                customer.calcPurchaseAmount())).isEqualTo(41538);
    }

}
