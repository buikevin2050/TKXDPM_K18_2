package v4;

public class Multiplication {
    private double number1;
    private double number2;

    public Multiplication(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    Multiplication() {
        this.number1 = 0;
        this.number2 = 0;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public double multiply() {
        return number1 * number2;
    }

}
