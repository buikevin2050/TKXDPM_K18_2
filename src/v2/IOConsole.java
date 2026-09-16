package v2;

import java.util.Scanner;

public class IOConsole {
    private Scanner keyboard;

    public IOConsole() {
        keyboard = new Scanner(System.in);
    }

    public void readNumbers(){
        System.out.print("Nhập số thứ nhất: ");
        double firstNumber = keyboard.nextDouble();
        System.out.print("Nhập số thứ hai: ");
        double secondNumber = keyboard.nextDouble();
        Multiplication multiplication = new 
        Multiplication(firstNumber, secondNumber);
        double result = multiplication.multiply();
        showResult(result);
    }

    public void showResult(double result){
        System.out.println("Kết quả: " + result);
    }

}
