package christmas;

import christmas.FoodMenu.MenuList;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EventCalculatorCheckTest {
    private static final String DISPLAY_PARAMETERIZED_TEST = "{displayName} - [\"{0}\"]";
    private final EventCalculator eventCalculator = new EventCalculator();
    private final Map<MenuList, Integer> testMenuList;

    EventCalculatorCheckTest(){
        testMenuList = new EnumMap<>(MenuList.class);
        testMenuList.put(MenuList.BBQ_RIP, 1);
        testMenuList.put(MenuList.CHOCORATE_CAKE, 1);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("이벤트 적용 여부 테스트 | 평일 혜택 여부 확인")
    @CsvSource(value = {"1:true", "2:false", "3:false", "4:true"}, delimiter = ':')
    void weekdayEventCheckTest(Integer input, boolean result){
        assertThat(eventCalculator.isWeekday(input, testMenuList)).isEqualTo(result);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("이벤트 적용 여부 테스트 | 주말 혜택 여부 확인")
    @CsvSource(value = {"1:false", "2:true", "3:true", "4:false"}, delimiter = ':')
    void weekendEventCheckTest(Integer input, boolean result){
        assertThat(eventCalculator.isWeekend(input, testMenuList)).isEqualTo(result);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("이벤트 적용 여부 테스트 | 특별 혜택 여부 확인")
    @CsvSource(value = {"1:false", "15:false", "3:true", "25:true"}, delimiter = ':')
    void specialEventCheckTest(Integer input, boolean result){
        assertThat(eventCalculator.isSpecialDay(input)).isEqualTo(result);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("이벤트 적용 여부 테스트 | 크리스마스 디데이 혜택 여부 확인")
    @CsvSource(value = {"1:true", "25:true", "26:false", "31:false"}, delimiter = ':')
    void christmasDDayEventCheckTest(Integer input, boolean result){
        assertThat(eventCalculator.isChristmasDDay(input)).isEqualTo(result);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("이벤트 적용 여부 테스트 | 증정 혜택 여부 확인")
    @CsvSource(value = {"0:false", "119999:false", "120000:true", "3000000:true"}, delimiter = ':')
    void presentEventCheckTest(Integer input, boolean result){
        assertThat(eventCalculator.isPresentEvent(input)).isEqualTo(result);
    }


}
