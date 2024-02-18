public class SavingsAccount extends BankAccount {
    private double interestRate;

    //Constructor of SavingsAccount Class
    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    //Definition of abstract calculateInterest() method present in BankAccount class 
    @Override
    public double calculateInterest() {
        return getBalance() * (interestRate/100);    
    }
}
