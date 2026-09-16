package v6;

public interface UI {
    double inputNumber(String prompt);

    void showResult(double result);

    void showSaveStatus(String storageName, boolean isSuccess);
}
