package v6;

import javax.swing.JOptionPane;

public class IOGUI implements UI {
    @Override
    public double inputNumber(String prompt) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, prompt);
            if (input == null) {
                throw new UserCancelledException();
            }

            try {
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(
                        null,
                        "Please enter a valid number.",
                        "Invalid input",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void showResult(double result) {
        JOptionPane.showMessageDialog(null, "Result: " + result);
    }

    @Override
    public void showSaveStatus(String storageName, boolean isSuccess) {
        int messageType = isSuccess ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        String message = isSuccess ? "Save succeeded: " : "Save failed: ";
        JOptionPane.showMessageDialog(null, message + storageName, "Save status", messageType);
    }

    private static class UserCancelledException extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
}