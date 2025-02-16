package carLoanProject;

//This program creates a car loan calculator.
public class CarLoanCalculator {
int carLoan = 10000;
int loanLength = 3;
int interestRate = 5;
int downPayment = 2000;

public CarLoanCalculator() {
  if (carLoan <= 0 ||interestRate <= 0) {
    System.out.println("Error! You must take out a valid car loan.");
  } else if (downPayment > carLoan) {
    System.out.println("The care can be paid in full.");
  } else {
     int remainingBalance = carLoan - downPayment;
     int months = loanLength *  12;
     int monthlyBalance = remainingBalance / months;
     int interest = (monthlyBalance * interestRate) / 100;
     int monthlyPayment = monthlyBalance + interest;
     System.out.println("Your monthly payment will be " + monthlyPayment);
  }
}

	public static void main(String[] args) {
CarLoanCalculator myCar = new CarLoanCalculator();
	}
}
