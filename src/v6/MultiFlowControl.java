package v6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MultiFlowControl {
    private final IOConsole console;
    private final List<Saving> savers;

    public MultiFlowControl(IOConsole console, List<Saving> savers) {
        this.console = Objects.requireNonNull(console, "console must not be null");
        this.savers = Collections.unmodifiableList(
                new ArrayList<>(Objects.requireNonNull(savers, "savers must not be null")));
    }

    public void control() {
        double[] numbers = console.readNumbers();
        Multiplication multiplication = new Multiplication(numbers[0], numbers[1]);
        double result = multiplication.multiply();

        console.showResult(result);
        for (Saving saver : savers) {
            saver.save(result);
        }
    }
}
