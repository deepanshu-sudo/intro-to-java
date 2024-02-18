import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GuessTheNumber extends JFrame {
    private int number;
    private int count;
    private JTextField inputField;
    private JTextArea resultArea;

    public GuessTheNumber() {
        setTitle("Guess the Number Game!");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Guess the Number Game!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel instructionsLabel = new JLabel("Choose a number between 1 and 100 and we'll give you hints until you find the number.");
        centerPanel.add(instructionsLabel);

        inputField = new JTextField(10);
        JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        centerPanel.add(inputField);
        centerPanel.add(guessButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        centerPanel.add(resultArea);

        add(centerPanel, BorderLayout.CENTER);

        initializeGame();
    }

    private void initializeGame() {
        Random random = new Random();
        number = random.nextInt(100) + 1;
        count = 0;
        resultArea.setText("");
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(inputField.getText());
            count++;
            if (userGuess == number) {
                resultArea.append("You found the number " + number + " in " + count + " attempts. Well Done!\n");
                int choice = JOptionPane.showConfirmDialog(this, "Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    initializeGame();
                } else {
                    System.exit(0);
                }
            } else if (userGuess > number) {
                resultArea.append("The number you guessed is greater than the actual number. This is your " + count + " attempt. Try Again!\n");
            } else {
                resultArea.append("The number you guessed is lesser than the actual number. This is your " + count + " attempt. Try Again!\n");
            }
        } catch (NumberFormatException ex) {
            resultArea.append("Invalid input. Please enter a valid number.\n");
        }
        inputField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessTheNumber().setVisible(true);
            }
        });
    }
}