package v6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MultiFlowControl {
    private final UI ui;
    private final List<Saving> savers;

    public MultiFlowControl(UI ui, List<Saving> savers) {
        this.ui = Objects.requireNonNull(ui, "ui must not be null");
        this.savers = Collections.unmodifiableList(
                new ArrayList<>(Objects.requireNonNull(savers, "savers must not be null")));
    }

    public void control() {
        double number1 = ui.inputNumber("Enter the first number: ");
        double number2 = ui.inputNumber("Enter the second number: ");
        Multiplication multiplication = new Multiplication(number1, number2);
        double result = multiplication.multiply();

        ui.showResult(result);
        for (Saving saver : savers) {
            boolean isSuccess = saver.save(result);
            ui.showSaveStatus(saver.getClass().getSimpleName(), isSuccess);
        }
    }
}
