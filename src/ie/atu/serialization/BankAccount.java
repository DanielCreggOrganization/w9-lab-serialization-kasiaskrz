package ie.atu.serialization;

import java.io.Serializable;
import java.util.Date;

public class BankAccount implements Serializable{
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private transient String pin;
    private transient Date lastAccessTime;

    public BankAccount(String accountNumber, String accountHolder, double balance, String pin, Date lastAccessTime) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.pin = pin;
        this.lastAccessTime = lastAccessTime;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                throw new IllegalArgumentException("Insufficient balance");
            }
        } else {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
    }

    public void updatePin(String oldPin, String newPin) {
        if (this.pin.equals(oldPin)) {
            this.pin = newPin;
        } else {
            throw new IllegalArgumentException("Invalid old PIN");
        }
    }

    public double checkBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("BankAccount{accountNumber='%s', accountHolder='%s', balance=%f, pin='%s', lastAccessTime='%s'}", accountNumber, accountHolder, balance, pin, lastAccessTime);
    }

    // Getters

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    // Setters

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }


    public void transfer(BankAccount other, double amount) {
        withdraw(amount);
        other.deposit(amount);
    }

    public void printStatement() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Last Access Time: " + lastAccessTime);
    }

    public void changePin(String oldPin, String newPin) {
        if (pin.equals(oldPin)) {
            pin = newPin;
        } else {
            System.out.println("Invalid PIN");
        }
    }

    


    
}
