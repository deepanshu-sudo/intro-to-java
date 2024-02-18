import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FlowLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating a panel with FlowLayout
        JPanel panel = new JPanel(new FlowLayout());

        // Adding buttons to the panel
        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton("Button " + i);
            panel.add(button);
        }

        // Adding the panel to the frame
        frame.add(panel);

        frame.setSize(300, 150);
        frame.setVisible(true);
    }
}
