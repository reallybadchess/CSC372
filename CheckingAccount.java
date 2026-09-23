package checkingAccount;

//subclass of BankAccount, adds interest rate and overdraft handling.
public class CheckingAccount extends BankAccount {

 private double interestRate;
 private static final double OVERDRAFT_FEE = 30.0;

 // balance and interest rate start at zero.
 public CheckingAccount() {
     super();
 }

 // sets name, id, and interest rate.
 public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
     super(firstName, lastName, accountID);
     this.interestRate = interestRate;
 }

 public double getInterestRate() {
     return interestRate;
 }

 public void setInterestRate(double interestRate) {
     this.interestRate = interestRate;
 }

 // withdraws amount, allows overdraft with a $30 fee.
 public void processWithdrawal(double amount) {
     if (amount > getBalance()) {
         withdrawal(amount); // let balance go negative
         withdrawal(OVERDRAFT_FEE); // subtract fee
         System.out.println("ALERT: Overdraft! A $30.00 fee has been assessed.");
         System.out.println("Balance: " + formatCurrency(getBalance()));
     } else {
         withdrawal(amount);
         System.out.println("Balance: " + formatCurrency(getBalance()));
     }
 }

 // shows account info plus interest rate.
 public void displayAccount() {
     accountSummary();
     System.out.printf("Interest Rate:  %.2f%%%n", interestRate);
 }
}