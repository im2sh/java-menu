package menu.exception;

import java.util.function.Supplier;
import menu.view.OutputView;

public class GlobalRetryHandler {
    private final OutputView outputView = new OutputView();

    public <T> T getOrRetry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            } finally {
                outputView.printNewLine();
            }
        }
    }

    public void runOrRetry(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            } finally {
                outputView.printNewLine();
            }
        }
    }

}
