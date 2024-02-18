import java.util.Random;

class Matrix {
    int[][] array;
    
    // Constructor to initialize the matrix with specified dimensions
    public Matrix(int rows, int cols) {
        array = new int[rows][cols];
    }
    
    // Method to populate the matrix with random values between 1 and 'range'
    public void populate(int range) {
        Random random = new Random();
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(range) + 1; // Generate values between 1 and 'range'
            }
        }
    }
    
    // Override the toString() method to provide a string representation of the matrix
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                result.append(array[i][j]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}

class Main {
    public static void main(String args[]) {
        // Create a Matrix object with dimensions 2x3
        Matrix matrix = new Matrix(2, 3);
        
        // Populate the matrix with random values between 1 and 50
        matrix.populate(50);
        
        // Print the matrix using System.out.println(matrix)
        System.out.println(matrix);
    }
}