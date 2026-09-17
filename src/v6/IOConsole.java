package v6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class IOConsole implements UI {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final Scanner keyboard;

    public IOConsole() {
        keyboard = new Scanner(System.in);
    }

    @Override
    public double inputNumber(String prompt) {
        System.out.print(prompt);
        return keyboard.nextDouble();
    }

    @Override
    public void showResult(double num1, double num2, double result, LocalDateTime timestamp) {
        String colorNote = isEven(result) ? "green" : "red";
        System.out.println("Date: " + timestamp.format(DATE_FORMATTER)
                + ", Result: " + result + " (text color: " + colorNote + ")");
    }

    @Override
    public void showSaveStatus(String storageName, boolean isSuccess) {
        String status = isSuccess ? "succeeded" : "failed";
        System.out.println("Saving to " + storageName + " " + status + ".");
    }

    private boolean isEven(double number) {
        return Math.abs((long) number) % 2 == 0;
    }
}
