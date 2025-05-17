import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static int accountCounter = 100;

    private static String generateAccountNumber() {
        return "ACC" + (++accountCounter);
    }

    public static void main(String[] args) {
        System.out.print("Enter Bank Name: ");
        String bankName = scanner.nextLine();

        System.out.print("Enter Branch Name: ");
        String branchName = scanner.nextLine();

        Bank bank = new Bank(bankName, branchName);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Open Account\n2. Deposit\n3. Withdraw\n4. Display Details\n5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Select Account Type:\n1. Savings\n2. Current\n3. Loan");
                    int accType = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Holder Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Initial Deposit: ");
                    double deposit = scanner.nextDouble();

                    String accNumber = generateAccountNumber();
                    Account account;

                    switch (accType) {
                        case 1: account = new SavingAccount(accNumber, name, deposit); break;
                        case 2: account = new CurrentAccount(accNumber, name, deposit); break;
                        case 3: account = new LoanAccount(accNumber, name, deposit); break;
                        default: System.out.println("Invalid Account Type."); continue;
                    }

                    bank.openAccount(account);
                    System.out.println("Account Number: " + accNumber);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depAcc = scanner.nextLine();
                    Account acc1 = bank.findAccount(depAcc);
                    if (acc1 != null) {
                        System.out.print("Enter Amount: ");
                        double amt = scanner.nextDouble();
                        acc1.deposit(amt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String withAcc = scanner.nextLine();
                    Account acc2 = bank.findAccount(withAcc);
                    if (acc2 != null) {
                        System.out.print("Enter Amount: ");
                        double amt = scanner.nextDouble();
                        acc2.withdraw(amt);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    bank.displayBankInfo();
                    for (Account acc : bank.getAccounts()) {
                        System.out.println("--- Account Details ---");
                        acc.showAccountType();
                        System.out.println("Holder: " + acc.getHolderName());
                        System.out.println("Account Number: " + acc.getAccountNumber());
                        System.out.println("Balance: ₹" + acc.getBalance());
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
