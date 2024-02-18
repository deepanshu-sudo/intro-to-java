import java.util.Scanner;
import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        // Get Input From User
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to find its factorial: ");
        long number = sc.nextLong();

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            BigInteger result = factorial(BigInteger.valueOf(number));
            System.out.println("The factorial of " + number + " is: " + result);
        }
    }
    
    // Recursive Function to find the factorial of a number
    public static BigInteger factorial(BigInteger number) {
        if (number.compareTo(BigInteger.ZERO) <= 0) {
            return BigInteger.ONE;
        } else {
            return number.multiply(factorial(number.subtract(BigInteger.ONE)));
        }
    }
}