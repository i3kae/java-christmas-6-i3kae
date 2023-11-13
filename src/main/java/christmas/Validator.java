package christmas;

import christmas.FoodMenu.MenuList;
import christmas.Messages.ErrorMessage;

public class Validator {
    private static final String COMMA = ",";
    private static final String HYPHEN = "-";
    public boolean purchaseChecker(String userInput){
        try{
            regexSplitChecker(userInput, COMMA, 1);
            for (String splitedComma : userInput.split(COMMA)){
                regexSplitChecker(splitedComma, HYPHEN, 2);
                isMenu(splitedComma.split(HYPHEN)[0]);
                isNumeric(splitedComma.split(HYPHEN)[1]);
            }
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
}
