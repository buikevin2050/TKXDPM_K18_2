package v6;

import java.util.Scanner;

public class IOConsole implements UI {
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
    public void showResult(double result) {
        System.out.println("Result: " + result);
    }

    @Override
    public void showSaveStatus(String storageName, boolean isSuccess) {
        String status = isSuccess ? "succeeded" : "failed";
        System.out.println("Saving to " + storageName + " " + status + ".");
    }
}
