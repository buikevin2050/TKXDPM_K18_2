package v4;

public class MultiFlowControl {

    public void control(double number1, double number2) {
        Multiplication multiplication = new 
        Multiplication(number1, number2);
        double result = multiplication.multiply();
        IOFile ioFile = new IOFile();
        ioFile.saveToFile(result);
    }

}
