package mortgagecalculator.example.mortgagecalculator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList; 

public class MortgageCalculatorGUI extends JFrame {

    private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(); 

    public MortgageCalculatorGUI() {
        setTitle("Mortgage Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel 
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        // Add input fields
        inputPanel.add(new JLabel("Loan Amount:"));
        JTextField loanAmountField = new JTextField();
        inputPanel.add(loanAmountField);

        inputPanel.add(new JLabel("Down Payment:"));
        JTextField downPaymentField = new JTextField();
        inputPanel.add(downPaymentField);

        inputPanel.add(new JLabel("Annual Interest Rate:"));
        JTextField interestRateField = new JTextField();
        inputPanel.add(interestRateField);

        inputPanel.add(new JLabel("Loan Term (Years):"));
        JTextField loanTermField = new JTextField();
        inputPanel.add(loanTermField);

        JButton calculateButton = new JButton("Calculate");
        inputPanel.add(calculateButton);

        // Table to display 
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Payment No.");
        tableModel.addColumn("Interest Paid");
        tableModel.addColumn("Principal Paid");
        tableModel.addColumn("Balance");
        JTable amortizationTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(amortizationTable);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double loanAmount = getDoubleInput(loanAmountField,"Loan Amount");
                    double downPayment = getDoubleInput(downPaymentField, "Down Payment");
                    double annualInterestRate = getDoubleInput(interestRateField, "Annual Interest Rate");
                    int loanTermYears = getIntegerInput(loanTermField, "Loan Term (Years)");

                    loanAmount -= downPayment; 

                    tableModel.setRowCount(0); 
                    calculateAndFillTable(tableModel, loanAmount, annualInterestRate, loanTermYears);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MortgageCalculatorGUI.this, "Invalid inputs. Please enter valid numbers.");
                }
            }
        });

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void calculateAndFillTable(DefaultTableModel tableModel, double loanAmount, double annualInterestRate, int loanTermYears) {
        DefaultTableModel calculatedModel = MortgageCalculator.calculateMortgage(loanAmount, annualInterestRate, loanTermYears);

        for (int i = 0; i < calculatedModel.getRowCount(); i++) {
            ArrayList<Object> rowData = new ArrayList<>(calculatedModel.getDataVector().get(i)); 

            // Format the currency values for interest paid, principal paid, and balance
            rowData.set(1, currencyFormatter.format(rowData.get(1)));
            rowData.set(2, currencyFormatter.format(rowData.get(2)));
            rowData.set(3, currencyFormatter.format(rowData.get(3)));

            Object[] rowArray = new Object[rowData.size()]; 
            for (int j = 0; j < rowData.size(); j++) {
                rowArray[j] = rowData.get(j);
            }
            tableModel.addRow(rowArray); 
        }
    }

     // Helper functions for input validation
    private double getDoubleInput(JTextField field, String fieldName) throws NumberFormatException {
        double value = Double.parseDouble(field.getText());
        if (value < 0) {
            throw new NumberFormatException(fieldName + " cannot be negative.");
        }
        return value;
    }

    private int getIntegerInput(JTextField field, String fieldName) throws NumberFormatException {
        int value = Integer.parseInt(field.getText());
        if (value <= 0) { 
            throw new NumberFormatException(fieldName + " must be a positive integer.");
        }
        return value;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MortgageCalculatorGUI().setVisible(true)); 
    }
}
