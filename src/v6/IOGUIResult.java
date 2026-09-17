package v6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class IOGUIResult implements UI {
    private static final Color EVEN_RESULT_COLOR = new Color(34, 139, 34);
    private static final Color ODD_RESULT_COLOR = new Color(220, 20, 60);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
    public void showResult(double num1, double num2, double result, LocalDateTime timestamp) {
        JDialog dialog = new JDialog((Dialog) null, "Calculation result", true);
        JPanel panel = new JPanel(new BorderLayout(16, 16));
        panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(24, 28, 20, 28));
        panel.setBackground(backgroundColor(num1, num2));

        JPanel details = new JPanel(new GridLayout(0, 1, 8, 8));
        details.setOpaque(false);
        details.add(label("Calculation result", 20, Color.DARK_GRAY));
        details.add(label("Numbers: " + num1 + " x " + num2, 15, Color.DARK_GRAY));
        details.add(label("Date: " + timestamp.format(DATE_FORMATTER), 15, Color.DARK_GRAY));
        details.add(label("Result: " + result, 18, resultColor(result)));

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        confirmButton.addActionListener(event -> dialog.dispose());

        panel.add(details, BorderLayout.CENTER);
        panel.add(confirmButton, BorderLayout.SOUTH);
        dialog.setContentPane(panel);
        dialog.setMinimumSize(new Dimension(390, 240));
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    @Override
    public void showSaveStatus(String storageName, boolean isSuccess) {
        int messageType = isSuccess ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;
        String message = isSuccess ? "Save succeeded: " : "Save failed: ";
        JOptionPane.showMessageDialog(null, message + storageName, "Save status", messageType);
    }

    private JLabel label(String text, int size, Color color) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.PLAIN, size));
        label.setForeground(color);
        return label;
    }

    private Color backgroundColor(double num1, double num2) {
        boolean firstEven = isEven(num1);
        boolean secondEven = isEven(num2);
        if (firstEven && secondEven) {
            return new Color(255, 209, 220);
        }
        if (firstEven) {
            return new Color(186, 225, 255);
        }
        if (!secondEven) {
            return new Color(255, 179, 186);
        }
        return new Color(255, 255, 186);
    }

    private Color resultColor(double result) {
        return isEven(result) ? EVEN_RESULT_COLOR : ODD_RESULT_COLOR;
    }

    private boolean isEven(double number) {
        return Math.abs((long) number) % 2 == 0;
    }

    private static class UserCancelledException extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
}