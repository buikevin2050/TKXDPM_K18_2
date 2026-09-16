import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: ");
        double firstNumber = scanner.nextDouble();
        System.out.print("Nhập số thứ hai: ");
        double secondNumber = scanner.nextDouble();

        double result = firstNumber * secondNumber;
        System.out.println("Kết quả: " + result);

        scanner.close();
    }
}
