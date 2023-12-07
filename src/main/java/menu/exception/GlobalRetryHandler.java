package menu.exception;

import java.util.function.Supplier;
import menu.view.OutputView;

public class GlobalRetryHandler {

    public <T> T getOrRetry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            } finally {
                OutputView.printNewLine();
            }
        }
    }

    public void runOrRetry(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            } finally {
                OutputView.printNewLine();
            }
        }
    }

}
