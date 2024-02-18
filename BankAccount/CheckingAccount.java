public class CheckingAccount extends BankAccount {
    double transactionFee, interestRate;

    //Constructor of SavingsAccount Class
    CheckingAccount(String accountNumber, double balance, double interestRate, double transactionFee) {
        super(accountNumber, balance);
        this.transactionFee = transactionFee;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount); // Invoking the superclass withdraw method
        setBalance(getBalance() - transactionFee); // Deducting the transaction fee from the balance
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount); // Invoking the superclass deposit method
        setBalance(getBalance() - transactionFee); // Deducting the transaction fee from the balance
    }

    //Definition of abstract calculateInterest() method present in BankAccount class 
    @Override
    public double calculateInterest() {
        return (getBalance() - transactionFee) * (interestRate / 100);
    }
}
