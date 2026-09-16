package v5;

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
        //cấp cao
        MultiFlowControl multiFlowControl = new MultiFlowControl();
        //cấp thấp
        IOFile ioFile = new IOFile();
        //tiêm phụ thuộc
        multiFlowControl.setSaving(ioFile);
        multiFlowControl.control(firstNumber, secondNumber);
      
    }

    public void showResult(double result){
        System.out.println("Kết quả: " + result);
    }

}
