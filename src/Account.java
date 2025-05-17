public abstract class Account implements AccountOperations {
    protected String accountNumber;
    protected String holderName;
    protected Balance balance;

    public Account(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = new Balance(initialBalance);
    }

    public abstract void showAccountType();

    @Override
    public void deposit(double amount) {
        balance.deposit(amount);
        System.out.println("₹" + amount + " deposited successfully.");
    }

    @Override
    public void withdraw(double amount) {
        if (balance.withdraw(amount)) {
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public double getBalance() {
        return balance.getAmount();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }
}
