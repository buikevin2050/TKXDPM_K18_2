package v6;

import java.util.Scanner;

public class IOConsole {
    private final Scanner keyboard;

    public IOConsole() {
        keyboard = new Scanner(System.in);
    }

    public double[] readNumbers() {
        System.out.print("Enter the first number: ");
        double firstNumber = keyboard.nextDouble();
        System.out.print("Enter the second number: ");
        double secondNumber = keyboard.nextDouble();
        return new double[] { firstNumber, secondNumber };
    }

    public void showResult(double result) {
        System.out.println("Result: " + result);
    }
}
