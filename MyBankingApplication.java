// design and implement my own banking application (without help of tutorial)
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class MyBankingApplication {
    public static void main (String[] args) {
        Account account = new Account(345435, "Rexinex");
        account.looper();
    }

}


public class Account {
    int customerId;
    String customerName;
    int balance;
    ArrayList<Integer> transactions = new ArrayList<Integer>();
    int amount;
    Scanner scanner = new Scanner(System.in);

    // intialize account details for the person
    Account(int cId, String cname) {
        customerId = cId;
        customerName = cname;
    }

    // design methods for banking operations
    public void deposit() {
        try {
        System.out.println("Enter deposit amount: ");
        amount = scanner.nextInt();
        if (amount<0) {
            throw new IOException("Invalid input");
        }
        balance += amount;
        transactions.add(amount);
        System.out.println("Deposited amount: "+amount);
        System.out.println("Your total balance is: "+balance);
        }
        catch(Exception e) {
            System.out.println("Invalid amount");
        }
    }

    public void withdraw() {
        try {
        System.out.println("Enter withdraw amount: ");
        amount = scanner.nextInt();
        if (amount<0) {
            throw new IOException("Invalid input");
        }
        balance -= amount;
        transactions.add(-amount);
        System.out.println("withdrawed amount: "+amount);
        System.out.println("Your total balance is: "+balance);
        }
        catch (Exception e) {
            System.out.println("Invalid Amount!");
        }

    }

    public void checkBalance() {
        System.out.println("Your total balance is: "+ balance);
    }

    public void showTransactions() {
        System.out.println("Your transactions are: "+transactions);
    }

    int option;
    public void looper() {
            System.out.println("Welcome to UY Bank! Please select from the options");
        do{
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check balances");
            System.out.println("4. Show transactions");
            System.out.println("0. Exit");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    showTransactions();
                    break;
                case 0:
                    System.out.println("Thank for using UY Bank. Have a nice day!");
                    break;
                default:
                    System.out.println("Invalid option. Retry!");
            }
        }while(option!=0);
    }
}