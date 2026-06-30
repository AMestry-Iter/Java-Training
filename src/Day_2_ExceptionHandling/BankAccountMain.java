package Day_2_ExceptionHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class InvalidAmountException extends Exception{
    public InvalidAmountException(String message){
        super(message);
    }
}

class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(String message){
        super(message);
    }
}

class BankAccount{
    private String accountId;
    private double balance;

    BankAccount(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if(amount<0){
            throw new InvalidAmountException("Deposit Amount cannot be negative.");
        }
        balance += amount;
        System.out.println("LOG: Deposited " + amount + " | New Balance: " + balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if(amount<0){
            throw new InvalidAmountException("Withdraw Amount cannot be negative.");
        }
        if(amount>balance){
            throw new InsufficientFundsException(
                    "Withdrawal amount: " + amount +
                            " is more than available balance: " + balance
            );
        }
        balance -= amount;
        System.out.println("LOG: Withdrawn " + amount + " | New Balance: " + balance);
    }

    public static void readAccountData(String filepath){
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            while((line = reader.readLine())!=null){
                System.out.println("File Data: " +line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("ERROR: I/O error while reading file: " + e.getMessage());
        }finally {
            System.out.println("LOG: File read attempt finished for: " +filepath);
        }
    }

}

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC123",1000.0);

        //withdrawal with insufficient funds
        try {
            account.withdraw(5000.0);
        } catch (InsufficientFundsException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println("ERROR: " + e.getMessage());
        }finally {
            System.out.println("LOG: Withdraw attempt complete.");
        }

        // deposit with negative amount
        try {
            account.deposit(-5000.0);
        }catch (InvalidAmountException e) {
            System.out.println("ERROR: " + e.getMessage());
        }finally {
            System.out.println("LOG: Deposit attempt complete.");
        }

        // file reading with non-existent file
        BankAccount.readAccountData("nonexistentFile.txt");

        //withdrawal with sufficient funds
        try {
            account.withdraw(200);
        } catch (InsufficientFundsException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            System.out.println("LOG: Withdraw attempt complete.");
        }

        System.out.println("Final Balance: " +account.getBalance());

    }
}
