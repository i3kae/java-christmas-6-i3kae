package christmas;

import christmas.FoodMenu.MenuList;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FoodMenuTest {
    private static final String DISPLAY_PARAMETERIZED_TEST = "{displayName} - [\"{0}\"]";
    @Test
    @DisplayName("음식 메뉴 클래스 테스트 | 정상적인 입력의 경우")
    void normalFoodMenuTest(){
        Map<MenuList, Integer> foodMenus = new EnumMap<>(MenuList.class);
        foodMenus.put(MenuList.TAPAS, 10);
        foodMenus.put(MenuList.CHAMPAGNE, 1);
        assertThat(FoodMenu.makePurchaseMenus("타파스-10,샴페인-1")).isEqualTo(foodMenus);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("음식 메뉴 클래스 테스트 | 메뉴 리스트에 없는 메뉴를 주문한 경우")
    @ValueSource(strings = {"함박스테이크-4", "양송이수프-3,콜라-6"})
    void notInMenuFoodMenuTest(String input){
        assertThatThrownBy(() -> FoodMenu.makePurchaseMenus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest(name = DISPLAY_PARAMETERIZED_TEST)
    @DisplayName("음식 메뉴 클래스 테스트 | 정상적이지 않은 숫자를 입력한 경우")
    @ValueSource(strings = {"티본스테이크-!", "제로콜라-6,타파스-4,해산물파스타-@"})
    void nonNumericFoodMenuTest(String input){
        assertThatThrownBy(() -> FoodMenu.makePurchaseMenus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
