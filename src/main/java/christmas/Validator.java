package christmas;

import christmas.FoodMenu.MenuList;
import christmas.FoodMenu.MenuType;
import christmas.Messages.ErrorMessage;

public class Validator {
    private static final String COMMA = ",";
    private static final String HYPHEN = "-";
    private static final int MENU = 0;
    private static final int CNT = 1;
    private static final int MAX_SIZE = 20;
    public boolean purchaseChecker(String userInput){
        try {
            regexSplitChecker(userInput, COMMA, 1);
            menuCountChecker(userInput);
        } catch (IllegalArgumentException e){
            System.out.println(ErrorMessage.INVALID_ORDER.getMessage());
            return true;
        }
        return false;
    }
    public void regexSplitChecker(String userInput, String regex, Integer minSepCnt){
        isEmpty(userInput, ErrorMessage.EMPTY_STR_ERROR);
        isEmpty(regex, ErrorMessage.EMPTY_REGEX_ERROR);
        if (userInput.startsWith(regex) || userInput.endsWith(regex) || userInput.split(regex).length < minSepCnt){
            System.out.println(ErrorMessage.SPLIT_ERROR.getMessage());
            throw new IllegalArgumentException(ErrorMessage.SPLIT_ERROR.getMessage());
        }
    }
    public void menuCountChecker(String menuCount){
        int menuCnt = 0;
        boolean onlyDrinkMenuFlag = true;
        for (String splitedComma : menuCount.split(COMMA)){
            regexSplitChecker(splitedComma, HYPHEN, 2);
            isMenu(splitedComma.split(HYPHEN)[MENU]);
            isNumeric(splitedComma.split(HYPHEN)[CNT]);
            isZeroMenuCount(Integer.parseInt(splitedComma.split(HYPHEN)[CNT]));
            menuCnt += Integer.parseInt(splitedComma.split(HYPHEN)[CNT]);
            isOverSize(menuCnt, MAX_SIZE);
            if (MenuList.findMenu(splitedComma.split(HYPHEN)[MENU]).getMenuType() != MenuType.DRINK){
                onlyDrinkMenuFlag = false;
            }
        }
        isOnlyDrinkMenu(onlyDrinkMenuFlag);
    }
    public void isMenu(String menuName){
        isEmpty(menuName, ErrorMessage.EMPTY_STR_ERROR);
        try {
            MenuList.findMenu(menuName);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.NOT_IN_MENULIST.getMessage());
            throw e;
        }
    }
    public void isNumeric(String textNumber){
        isEmpty(textNumber, ErrorMessage.EMPTY_STR_ERROR);
        for (int i = 0; i < textNumber.length(); i++){
            if (textNumber.charAt(i) < '0' || '9' < textNumber.charAt(i)){
                System.out.println(ErrorMessage.NON_NUMERIC.getMessage());
                throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC.getMessage());
            }
        }
    }
    public void isEmpty(String input, ErrorMessage errorType){
        if (input.isEmpty()){
            System.out.println(errorType.getMessage());
            throw new IllegalArgumentException(errorType.getMessage());
        }
    }
    public boolean visitDateChecker(String input){
        try {
            isNumeric(input);
            isDate(Integer.parseInt(input));
        } catch (IllegalArgumentException e){
            System.out.println(ErrorMessage.NON_DATE.getMessage());
            return true;
        }
        return false;
    }
    public void isDate(Integer inputDate){
        if (inputDate < 1 || 31 < inputDate){
            System.out.println(ErrorMessage.NON_DATE.getMessage());
            throw new IllegalArgumentException(ErrorMessage.NON_DATE.getMessage());
        }
    }
    public void isOverSize(Integer cnt, Integer maxSize){
        if (cnt > maxSize){
            System.out.println(ErrorMessage.OVER_SIZE_ERROR.getMessage());
            throw new IllegalArgumentException(ErrorMessage.OVER_SIZE_ERROR.getMessage());
        }
    }
    public void isOnlyDrinkMenu(boolean onlyDrinkMenuFlag){
        if (onlyDrinkMenuFlag){
            System.out.println(ErrorMessage.ONLY_ORDER_DRINK_MENU);
            throw new IllegalArgumentException(ErrorMessage.ONLY_ORDER_DRINK_MENU.getMessage());
        }
    }
    public void isZeroMenuCount(Integer menuCount){
        if (menuCount == 0){
            System.out.println(ErrorMessage.ZERO_MENU_COUNT);
            throw new IllegalArgumentException(ErrorMessage.ZERO_MENU_COUNT.getMessage());
        }
    }
}
