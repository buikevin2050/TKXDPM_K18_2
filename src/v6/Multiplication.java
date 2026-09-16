package v6;

public class Multiplication {
    private final double number1;
    private final double number2;

    public Multiplication(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public double multiply() {
        return number1 * number2;
    }
}
