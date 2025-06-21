import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter {

         public static void converter() {
        JFrame f = new JFrame("Currency Converter");
        f.getContentPane().setBackground(new Color(240, 248, 255));  // Light Blue background

        // Create labels with custom font and icons
        JLabel l1 = new JLabel("Amount:");
        l1.setFont(new Font("SansSerif", Font.BOLD, 16));
        l1.setForeground(new Color(0, 102, 204));

        JLabel l2 = new JLabel("Converted Amount:");
        l2.setFont(new Font("SansSerif", Font.BOLD, 16));
        l2.setForeground(new Color(0, 102, 204));

        // Text field for entering the amount
        JTextField t1 = new JTextField("Enter amount");
        t1.setForeground(Color.GRAY);
        t1.setPreferredSize(new Dimension(150, 30));
        t1.setHorizontalAlignment(JTextField.CENTER);  // Center-align text
        t1.setToolTipText("Enter the amount to convert");

        // Text field for displaying the converted amount
        JTextField t2 = new JTextField("Converted Amount");
        t2.setForeground(Color.GRAY);
        t2.setPreferredSize(new Dimension(150, 30));
        t2.setHorizontalAlignment(JTextField.CENTER);
        t2.setEditable(false);
        t2.setToolTipText("The converted amount will appear here");

        // Drop-down lists for selecting currencies
        String[] currencies = {"INR", "USD", "EUR", "GBP"};
        JComboBox<String> fromCurrency = new JComboBox<>(currencies);
        JComboBox<String> toCurrency = new JComboBox<>(currencies);

        // Buttons for conversion and reset
        JButton b1 = new JButton("Convert");
        JButton resetButton = new JButton("Reset");

        // Styling buttons
        styleButton(b1, new Color(50, 205, 50), Color.WHITE);
        styleButton(resetButton, Color.RED, Color.WHITE);

        // Add hover effect for buttons
        addHoverEffect(b1, Color.GREEN, new Color(50, 205, 50));
        addHoverEffect(resetButton, Color.PINK, Color.RED);

        // Action listener for the convert button
             b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(t1.getText());
                    String from = fromCurrency.getSelectedItem().toString();
                    String to = toCurrency.getSelectedItem().toString();
                    double convertedAmount = convertCurrency(amount, from, to);

                    if (from.equals(to)) {
                        t2.setText(String.format("%.2f", amount));
                    } else if (convertedAmount != -1) {
                        t2.setText(String.format("%.2f", convertedAmount));
                        t2.setForeground(Color.BLACK);
                    } else {
                        JOptionPane.showMessageDialog(f, "Conversion rate not available.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(f, "Please enter a valid amount!");
                }
               }
           });

        // Reset button clears input fields and resets drop-downs
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                t1.setText("Enter amount");
                t1.setForeground(Color.GRAY);
                t2.setText("Converted Amount");
                t2.setForeground(Color.GRAY);
                fromCurrency.setSelectedIndex(0);
                toCurrency.setSelectedIndex(0);
            }
          });

        // Layout setup using GridBagLayout for flexibility
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(240, 248, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(l1, gbc);
        gbc.gridx = 1;
        mainPanel.add(t1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(new JLabel("From:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(fromCurrency, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(new JLabel("To:"), gbc);
        gbc.gridx = 1;
        mainPanel.add(toCurrency, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(l2, gbc);
        gbc.gridx = 1;
        mainPanel.add(t2, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        mainPanel.add(b1, gbc);
        gbc.gridx = 1;
        mainPanel.add(resetButton, gbc);

        // Add animated panel with moving circles and dynamic heading
        MyPanel drawingPanel = new MyPanel();
        drawingPanel.setPreferredSize(new Dimension(400, 200));

        // Add components to the frame
        f.add(mainPanel, BorderLayout.CENTER);
        f.add(drawingPanel, BorderLayout.SOUTH);

        f.setSize(600, 600);
        f.setVisible(true);

        // Start animation thread
        Thread t = new Thread(drawingPanel);
        t.start();
    }

    // Method to convert currency based on selected currencies
    private static double convertCurrency(double amount, String from, String to) {
        double conversionRate = -1;

        switch (from + "to" + to) {
            case "INRtoUSD":
                conversionRate = 0.012;
                break;
            case "USDtoINR":
                conversionRate = 83.23;
                break;
            case "INRtoEUR":
                conversionRate = 0.011;
                break;
            case "EURtoINR":
                conversionRate = 88.92;
                break;
            case "INRtoGBP":
                conversionRate = 0.0097;
                break;
            case "GBPtoINR":
                conversionRate = 102.91;
                break;
            case "USDtoEUR":
                conversionRate = 0.94;
                break;
            case "EURtoUSD":
                conversionRate = 1.06;
                break;
            case "USDtoGBP":
                conversionRate = 0.81;
                break;
            case "GBPtoUSD":
                conversionRate = 1.23;
                break;
            case "EURtoGBP":
                conversionRate = 0.86;
                break;
            case "GBPtoEUR":
                conversionRate = 1.17;
                break;
            default:
                break;
        }

        return conversionRate == -1 ? -1 : amount * conversionRate;
    }

    // Method to style buttons
    private static void styleButton(JButton button, Color bgColor, Color fgColor) {
        button.setFocusPainted(false);
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

    // Method to add hover effect to buttons
    private static void addHoverEffect(JButton button, Color hoverColor, Color originalColor) {
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(originalColor);
            }
        });
    }

    // Panel for animation
    static class MyPanel extends JPanel implements Runnable {
        int xPos = 20;
        int direction = 1;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(new Color(70, 130, 180));  // Steel blue background

            // Smooth animation with anti-aliasing
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(Color.RED);
            g2.fillOval(xPos, 50, 30, 30);
            g2.setColor(Color.GREEN);
            g2.fillOval(xPos + 40, 50, 30, 30);
            g2.setColor(Color.YELLOW);
            g2.fillOval(xPos + 80, 50, 30, 30);

            // Smoother font for moving text
            g2.setFont(new Font("Serif", Font.BOLD, 24));
            g2.setColor(Color.WHITE);
            g2.drawString("Currency Converter", xPos, 120);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    xPos += direction * 5;
                    if (xPos > getWidth() - 160 || xPos < 0) {
                        direction *= -1;
                    }
                    repaint();
                    Thread.sleep(50);  // Smooth animation speed
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        converter();
    }
}
