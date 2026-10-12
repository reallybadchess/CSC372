package checkingAccount;


//superclass for a bank account.
public class BankAccount {

 private String firstName;
 private String lastName;
 private int accountID;
 private double balance;

 // balance starts at zero.
 public BankAccount() {
     this.balance = 0.0;
 }

 // sets name and id, balance starts at zero.
 public BankAccount(String firstName, String lastName, int accountID) {
     this.firstName = firstName;
     this.lastName = lastName;
     this.accountID = accountID;
     this.balance = 0.0;
 }

 // adds amount to balance.
 public void deposit(double amount) {
     balance += amount;
 }

 // subtracts amount from balance.
 public void withdrawal(double amount) {
     balance -= amount;
 }

 // getters and setters

 public String getFirstName() {
     return firstName;
 }

 public void setFirstName(String firstName) {
     this.firstName = firstName;
 }

 public String getLastName() {
     return lastName;
 }

 public void setLastName(String lastName) {
     this.lastName = lastName;
 }

 public int getAccountID() {
     return accountID;
 }

 public void setAccountID(int accountID) {
     this.accountID = accountID;
 }

 // returns balance.
 public double getBalance() {
     return balance;
 }

 // prints account info.
 public void accountSummary() {
     System.out.println("Account Summary");
     System.out.println("Account Holder: " + firstName + " " + lastName);
     System.out.println("Account ID:     " + accountID);
     System.out.println("Balance:        " + formatCurrency(balance));
 }

 // formats amount as currency, negative shown as -$x.xx.
 protected String formatCurrency(double amount) {
     if (amount < 0) {
         return String.format("-$%.2f", Math.abs(amount));
     }
     return String.format("$%.2f", amount);
 }
}
