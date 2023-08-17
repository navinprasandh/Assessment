import java.util.Objects;
import java.util.Scanner;
interface BankAccount {
    String createAccount();
    double getInterestRate();
}
class SavingsAccount implements BankAccount {
    @Override
    public String createAccount() {
        return "Savings Account";
    }
    @Override
    public double getInterestRate() {
        return 0.06;
    }
}
class CurrentAccount implements BankAccount {
    @Override
    public String createAccount() {
        return "Current Account";
    }
    @Override
    public double getInterestRate() {
        return 0.07;
    }
}
class LoanAccount implements BankAccount {
    @Override
    public String createAccount() {
        return "Loan Account";
    }
    @Override
    public double getInterestRate() {
        return 0.1;
    }
}
interface Bank {
    BankAccount createAccount(String accountType);
}
class SavingsAcc implements Bank {
    @Override
    public BankAccount createAccount(String accountType) {
        if (Objects.equals(accountType, "Savings Account")) {
            return new SavingsAccount();
        } else {
            throw new IllegalArgumentException("Invalid account type");
        }
    }
}
class CurrentAcc implements Bank {
    @Override
    public BankAccount createAccount(String accountType) {
        if (Objects.equals(accountType, "Current Account")) {
            return new CurrentAccount();
        } else {
            throw new IllegalArgumentException("Invalid account type");
        }
    }
}
class LoanAcc implements Bank {
    @Override
    public BankAccount createAccount(String accountType) {
        if (Objects.equals(accountType, "Loan Account")) {
            return new LoanAccount();
        } else {
            throw new IllegalArgumentException("Invalid account type");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select account type : Savings Account / Current Account / Loan Account");
        String accountType = scanner.nextLine();
        Bank bankacc;
        if (accountType.equalsIgnoreCase("Savings Account")) {
            bankacc = new SavingsAcc();
        } else if (accountType.equalsIgnoreCase("Current Account")) {
            bankacc = new CurrentAcc();
        } else if (accountType.equalsIgnoreCase("Loan Account")) {
            bankacc = new LoanAcc();
        } else {
            System.out.println("Invalid Account type");
            return;
        }
        BankAccount account = bankacc.createAccount(accountType);
        System.out.println("Account type: " + account.createAccount());
        System.out.println("Interest Rate: " + account.getInterestRate());
        scanner.close();
    }
}
