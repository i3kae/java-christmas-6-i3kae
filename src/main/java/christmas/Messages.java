package christmas;

public class Messages {
    public enum Main{
        WELCOME_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
        VISIT_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
        ORDER_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
        EVENT_BENEFIT_PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        private final String message;
        Main(String message){
            this.message = message;
        }

        public String getMessage(){
            return message;
        }
    }

    public enum ErrorMessage{
        SPLIT_ERROR("[ERROR] 문자열의 구분이 비정상적입니다."),
        EMPTY_STR_ERROR("[ERROR] 비어있는 문자열이 들어왔습니다."),
        EMPTY_REGEX_ERROR("[ERROR] 비어있는 구분자가 들어왔습니다."),
        NON_NUMERIC("[ERROR] 숫자가 아닌 값이 들어왔습니다."),
        NOT_IN_MENULIST("[ERROR] 메뉴 목록에 포함되어 있지 않은 메뉴입니다."),
        OVER_SIZE_ERROR("[ERROR] 주문 메뉴가 20개를 초과하였습니다."),
        ONLY_ORDER_DRINK_MENU("[ERROR] 음료 메뉴만 주문할 수 없습니다."),
        ZERO_MENU_COUNT("[ERROR] 주문된 메뉴의 갯수가 없습니다."),
        DUPLICATED_PURCHASE_MENU("[ERROR] 중복된 메뉴가 주문되었습니다."),
        NON_DATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
        INVALID_ORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        private final String message;
        ErrorMessage(String message){
            this.message = message;
        }
        public String getMessage(){
            return message;
        }
    }

    public enum EventTitleMessage{
        TOTAL_PURCHASE_AMOUNT("<할인 전 총주문 금액>"),
        ORDER_MENU("<주문 메뉴>"),
        PRESENT_MENU("<증정 메뉴>"),
        APPLIED_EVENTS("<혜택 내역>"),
        TOTAL_DISCOUNT_AMOUNT("<총혜택 금액>"),
        ESTIMATED_AMOUNT("<할인 후 예상 결제 금액>"),
        EVENT_BADGE_MENU("<12월 이벤트 배지>");
        private final String titleMessage;
        EventTitleMessage(String titleMessage){
            this.titleMessage = titleMessage;
        }
        public String getTitleMessage(){
            return titleMessage;
        }
    }
    public enum AdditionalMessage{
        APPLIED_EVNET_AMOUNT("총주문 금액이 10,000원 이상일 경우 12월 이벤트 혜택을 받아보실 수 있습니다!"),
        NOT_ORDER_ONLY_DRINK("음료만 주문하실 경우 주문이 어려운점 양해 부탁드립니다 (__)"),
        MAX_ORDER_COUNT("총주문 갯수는 최대 20개까지 주문가능합니다!"),
        VISIT_DATE_RANGE("방문 날짜는 1 ~ 31 사이의 숫자로 입력해주세요!"),
        CHRISTMAS_RANGE_ANNOUNCEMENT("크리스마스 디데이 할인은 1 ~ 25일 사이에 진행됩니다!"),
        EVENT_LIST_ANNOUNCEMENT("이번 12월에 진행되는 이벤트에 대해 먼저 설명해드릴게요!"),
        CHRISTMAS_EVENT_ANNOUNCEMENT("크리스마스 디데이 할인 - 1일에 1,000원으로 시작해 25일까지 하루가 지날 때 마다 100원을 추가로 할인해 드립니다!"),
        WEEKDAY_EVENT_ANNOUNCEMENT("평일 할인 - 평일에 방문하셨을 때 디저트 메뉴당 2,023원을 할인해 드립니다!"),
        WEEKEND_EVENT_ANNOUNCEMENT("주말 할인 - 주말에 방문하셨을 때 메인 메뉴당 2,023원을 할인해 드립니다!"),
        SPECIAL_EVENT_ANNOUNCEMENT("특별 할인 - 일요일과 크리스마스에 방문하셨을 때 전체 금액에서 1,000원을 할인해 드립니다!"),
        PRESENT_EVENT_ANNOUNCEMENT("증정 이벤트 - 메뉴를 120,000원 이상 구매해 주셨을 때 25,000원 상당의 샴페인을 증정해 드립니다!"),
        EVENT_BADGE_ANNOUNCEMENT("뱃지 이벤트 - 총혜택 금액이 5,000원 이상일 때 별, 10,000원 이상일 때 트리, 20,000원 이상일 때 산타 뱃지를 드립니다!"),
        NEW_YEAR_EVENT_ANNOUNCEMENT("이건 고객님한테만 알려드리는 정보인데 이번 이벤트에서 받으신 뱃지에 따라 내년 새해 이벤트에서 다양항 혜택을 계획하고 있다고 하네요!");
        private final String message;
        AdditionalMessage(String message){
            this.message = message;
        }
        public String getMessage(){
            return message;
        }
    }
}
