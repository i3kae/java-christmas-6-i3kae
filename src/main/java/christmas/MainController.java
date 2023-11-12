package christmas;

public class MainController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void eventPlannerStart(){
        outputView.printWelcome();
    }
}
