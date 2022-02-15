import java.util.*;

class Loan{
    private double annualIntererstRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    public Loan(){
        Date today = new Date();
        this.annualIntererstRate = 2.5;
        this.numberOfYears = 1;
        this.loanAmount = 1000;
        this.loanDate = today;
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount){
        Date today = new Date();
        this.annualIntererstRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = today;
    }

    public double getAnnualInterestRate(){
        return this.annualIntererstRate;
    }

    public int getNumberOfYears(){
        return this.numberOfYears;
    }

    public double getLoanAmount(){
        return this.loanAmount;
    }

    public java.util.Date getLoanDate(){
        return this.loanDate;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        this.annualIntererstRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears){
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }

    
    public void getMonthlyPayment(){
    // monthly payment is loanAmount * monthlyInterestRate OVER 1- [1/ 1+ (monthlyInterestRate)^numOfYears*12]
        double value = ((this.loanAmount*this.annualIntererstRate)/1200)/(1-Math.pow(((this.annualIntererstRate/1200)+1),(-12*this.numberOfYears)));
        value = Math.round(value * 100.0) / 100.0;
        System.out.println("The monthly payment is $" + value);
        this.getTotalPayment(value);
    }

    public void getTotalPayment(double monthlyPayment){
    // totalPayment = monthlyPayment * numOfYears * 12
        double value = monthlyPayment * this.numberOfYears * 12;
        value = Math.round(value * 100.0) / 100.0;
        System.out.println("The total payment is $" + value);
    }

}

public class qns1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter annual interest rate, for example, 8.25:");
        double inputInterestRate = Double.parseDouble(scan.nextLine());
        System.out.print("Enter number of years as integer:");
        int inputYears = (Integer.parseInt(scan.nextLine()));
        System.out.print("Enter loan amount:");
        double inputLoanAmount = Double.parseDouble(scan.nextLine());
        // create loan
        Loan newLoan = new Loan(inputInterestRate, inputYears, inputLoanAmount);
        // create monthly payment
        newLoan.getMonthlyPayment();
    }    
}
