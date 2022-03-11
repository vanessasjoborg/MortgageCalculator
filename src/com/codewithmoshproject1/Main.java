package com.codewithmoshproject1;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte periodInYears =(byte) Console.readNumber("Period (years): ", 1, 30);


        var calculator = new MortgageCalculator(principal, annualInterestRate, periodInYears);

        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();

//        FizzBuzz fizzBuzz = new FizzBuzz();
    }
}
