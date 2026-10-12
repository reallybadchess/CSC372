import javax.swing.*;
import java.awt.event.*;

public class BankBalanceApp implements ActionListener {
    double balance;

    JFrame frame = new JFrame("Bank Balance");
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Balance: ?");
    JTextField amount = new JTextField(8);
    JButton show = new JButton("Show Balance");
    JButton deposit = new JButton("Deposit");
    JButton withdraw = new JButton("Withdraw");
    JButton exit = new JButton("Exit");

    public BankBalanceApp() {
        balance = Double.parseDouble(JOptionPane.showInputDialog("Enter starting balance:"));

        show.addActionListener(this);
        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        exit.addActionListener(this);

        panel.add(label);
        panel.add(amount);
        panel.add(show);
        panel.add(deposit);
        panel.add(withdraw);
        panel.add(exit);

        frame.add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == show) {
            label.setText("Balance: $" + balance);
        } else if (e.getSource() == deposit) {
            balance += Double.parseDouble(amount.getText());
            label.setText("Balance: $" + balance);
        } else if (e.getSource() == withdraw) {
            balance -= Double.parseDouble(amount.getText());
            label.setText("Balance: $" + balance);
        } else if (e.getSource() == exit) {
            JOptionPane.showMessageDialog(frame, "Remaining balance: $" + balance);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new BankBalanceApp();
    }
}