public class Balance {
    private double amount;

    public Balance(double amount) {
        this.amount = amount;
    }

    public void deposit(double depositAmount) {
        amount += depositAmount;
    }

    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount <= amount) {
            amount -= withdrawAmount;
            return true;
        } else {
            return false;
        }
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "₹" + amount;
    }
}
