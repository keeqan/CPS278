package mortgagecalculator.example.mortgagecalculator;

import javax.swing.table.DefaultTableModel;

public class MortgageCalculator {


    public static DefaultTableModel calculateMortgage(double loanAmount, double annualInterestRate, int loanTermYears) {
        // Convert annual interest rate to monthly interest rate
        double monthlyInterestRate = annualInterestRate / 12.0;
        // Total number of payments over the loan term
        int numberOfPayments = loanTermYears * 12;

        // Calculate monthly payment using the mortgage formula
        double monthlyPayment = loanAmount *
                (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) /
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        // Initialize the table model for the amortization schedule with column names
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Payment No.", "Interest Paid", "Principal Paid", "Balance"}, 0);

        double balance = loanAmount;

        // Loop through each payment
        for (int paymentNumber = 1; paymentNumber <= numberOfPayments; paymentNumber++) {

            double interestPaid = balance * monthlyInterestRate;
            double principalPaid = monthlyPayment - interestPaid;
            balance -= principalPaid;

            if (balance < 0) {
                principalPaid += balance; 
                balance = 0;
            }

            // Add a row to the table model with the payment details
            tableModel.addRow(new Object[]{paymentNumber, interestPaid, principalPaid, balance});

            // Break the loop if loan paid off
            if (balance <= 0) {
                break;
            }
        }
        return tableModel;
    }
}
