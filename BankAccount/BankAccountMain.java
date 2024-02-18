// The main class that demonstrates the functionality of the bank accounts
public class BankAccountMain {
    
     public static void main(String []args){
        
         // Creating objects of both SavingsAccount and CheckingAccount classes
        
         SavingsAccount sa = new SavingsAccount("SA123", 10000, 5); // A savings account with initial balance of 10000 and interest rate of 5%
         CheckingAccount ca = new CheckingAccount("CA456", 5000, 5, 100); // A checking account with initial balance of 5000 and transaction fee of 10
        
         System.out.println("Initial balances:");
         System.out.println("Savings Account: " + sa.getBalance());
         System.out.println("Checking Account: " + ca.getBalance());
        
         System.out.println();
        
         System.out.println("Performing various operations:");
        
         sa.deposit(2000); // Depositing 2000 to savings account
        
         ca.withdraw(1000); // Withdrawing 1000 from checking account
        
         System.out.println();
        
         System.out.println("Updated balances:");
         System.out.println("Savings Account: " + sa.getBalance());
         System.out.println("Checking Account: " + ca.getBalance());
        
         System.out.println();
        
         System.out.println("Calculating interests:");
         System.out.println("Savings Account Interest: " + sa.calculateInterest());
         System.out.println("Checking Account Interest: " + ca.calculateInterest());
     }
}