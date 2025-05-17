import java.util.*;

public class Bank {
    protected String bankName;
    protected String branchName;
    protected List<Account> accounts;
    private static int bankCounter = 1;
    protected static final String BANK_CODE_PREFIX = "BANK-";
    protected final String bankCode;

    public Bank(String bankName, String branchName) {
        this.bankName = bankName;
        this.branchName = branchName;
        this.accounts = new ArrayList<>();
        this.bankCode = generateBankCode();
    }

    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("Account opened successfully.");
    }

    public void displayBankInfo() {
        System.out.println("--- Bank Details ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Branch: " + branchName);
        System.out.println("Bank Code: " + bankCode);
    }

    private String generateBankCode() {
        return BANK_CODE_PREFIX + String.format("%03d", bankCounter++);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }
}
