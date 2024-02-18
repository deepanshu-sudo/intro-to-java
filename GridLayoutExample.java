import javax.swing.*;
import java.awt.*;

public class GridLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grid Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating a panel with GridLayout
        JPanel panel = new JPanel(new GridLayout(3, 3, 5, 5)); // 3x3 grid with 5px horizontal and vertical gaps

        // Adding buttons to the panel
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton("Button " + i);
            panel.add(button);
        }

        // Adding the panel to the frame
        frame.add(panel);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
