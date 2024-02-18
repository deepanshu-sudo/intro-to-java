import java.util.Random;

public class RaggedArrayStaircase {

    public static void main(String[] args) {
        // Create a random number generator.
        Random random = new Random();

        // Get the number of rows and columns for the ragged array.
        int rows = 5;

        // Create the ragged array.
        int[][] array = new int[rows][];
        for (int i = 0; i < rows; i++) {
            array[i] = new int[i + 1];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(100);
            }
        }

        // Print the ragged array.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}