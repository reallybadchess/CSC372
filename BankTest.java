package checkingAccount;

//demonstrates BankAccount and CheckingAccount
public class BankTest {
 public static void main(String[] args) {

     System.out.println("Test BankAccount");
     BankAccount account1 = new BankAccount();
     account1.setFirstName("Rick");
     account1.setLastName("Sanchez");
     account1.setAccountID(1001);
     account1.deposit(500.00);
     account1.withdrawal(150.00);
     account1.accountSummary();

     System.out.println();

     System.out.println("Test CheckingAccount (normal withdrawal)");
     CheckingAccount account2 = new CheckingAccount("Jane", "Smith", 2001, 1.5);
     account2.deposit(200.00);
     account2.processWithdrawal(100.00); // no overdraft
     account2.displayAccount();

     System.out.println();

     System.out.println("Test CheckingAccount (overdraft withdrawal");
     account2.processWithdrawal(150.00); // triggers overdraft
     account2.displayAccount();
 }
}