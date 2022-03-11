package com.codewithmoshproject1;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal = 0;
    private float annualInterestRate;
    private byte periodInYears = 0;



    public MortgageCalculator(int principal, float annualInterestRate, byte periodInYears) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.periodInYears = periodInYears;
    }

    public double calculateMortgage() {
        float numberOfPayments = getNumberOfPayments();
        float monthlyInterestRate = getMonthlyInterestRate();
        double mortgage = principal*(monthlyInterestRate * Math.pow(1+monthlyInterestRate,numberOfPayments))/(Math.pow(1+monthlyInterestRate,numberOfPayments)-1);

        return mortgage;
    }



    public double calculateBalance(
                                   short numberOfPaymentsMade) {
        // L = principal
        // c = monthlyInterest
        // n = numberOfPayments
        // p = numberOfPaymentsMade

        float numberOfPayments = getNumberOfPayments();
        float monthlyInterestRate = getMonthlyInterestRate();

        double loanBalance = principal *
                (Math.pow(1+monthlyInterestRate, numberOfPayments)-Math.pow(1+monthlyInterestRate, numberOfPaymentsMade))
                /(Math.pow(1+monthlyInterestRate, numberOfPayments)-1);

        return loanBalance;

    }

    private float getMonthlyInterestRate() {
        return annualInterestRate / PERCENT / MONTHS_IN_YEAR;
    }

    private short getNumberOfPayments() {
        return (short) (periodInYears * MONTHS_IN_YEAR);
    }

    public double[] getRemainingBalances() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);

        return balances;
        }

}
