package christmas;

import christmas.FoodMenu.MenuList;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventCalculatorTest {
    private final Map<MenuList, Integer> testMenusList;
    private final EventCalculator eventCalculator;
    EventCalculatorTest(){
        testMenusList = new EnumMap<>(MenuList.class);
        eventCalculator = new EventCalculator();
        testMenusList.put(MenuList.BBQ_RIP, 3);
        testMenusList.put(MenuList.T_BONE_STKAE, 2);
        testMenusList.put(MenuList.CHRISTMAS_PASTA, 4);
        testMenusList.put(MenuList.CHOCORATE_CAKE, 1);
        testMenusList.put(MenuList.ICECREAM, 5);
        testMenusList.put(MenuList.TAPAS, 2);
        testMenusList.put(MenuList.RED_WINE, 1);

    }
    @Test
    @DisplayName("이벤트 적용 계산 테스트 | 평일 이벤트 결과")
    void weekdayEventResultTest(){
        assertThat(eventCalculator.calcWeekdayEvent(testMenusList)).isEqualTo(2023 * 6);
    }
    @Test
    @DisplayName("이벤트 적용 계산 테스트 | 주말 이벤트 결과")
    void weekendEventResultTest(){
        assertThat(eventCalculator.calcWeekendEvent(testMenusList)).isEqualTo(2023 * 10);
    }
}
