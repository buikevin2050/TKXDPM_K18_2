package v6;

import java.time.LocalDateTime;

public interface UI {
    double inputNumber(String prompt);

    void showResult(double num1, double num2, double result, LocalDateTime timestamp);

    void showSaveStatus(String storageName, boolean isSuccess);
}
