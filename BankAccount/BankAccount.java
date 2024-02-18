public abstract class BankAccount {
    private String accountNumber;
    private double balance;

    //Constructor for Bank Account Class
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //Method to Deposit Money into Bank Account
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        }

        System.out.println("Enter an amount > 0");
    }

    //Method to Withdraw Money from Bank Account
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
        }

        System.out.println("Low Balance / Amount Not Specified");
    }

    //Getter : Get Account Number
    public String getAccountNumber() {
        return accountNumber;
    }

    //Getter : Get Balance
    public double getBalance() {
        return balance;
    }

    //Setter : Set Balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    //An abstract method to calculate interest 
    public abstract double calculateInterest();
}