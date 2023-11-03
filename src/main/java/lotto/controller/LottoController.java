package lotto.controller;

import lotto.model.LottoTicketMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printPurchaseAmountMessage();
        int purchasePrice = getPurchasePrice();
    }

    public int getPurchasePrice() {
        while (true) {
            try {
                return inputView.getOneNumberInRange(LottoTicketMachine.LOTTO_PRICE, LottoTicketMachine.MAX_PURCHASE_AMOUNT);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
