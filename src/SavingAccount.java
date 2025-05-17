public class SavingAccount extends Account {
    public SavingAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void showAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}
