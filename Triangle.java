import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Triangle {
    int s1, s2, s3;

    public Triangle(int s1, int s2, int s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    double findArea() {
        double s = (this.s1 + this.s2 + this.s3)/2.0;
        return (Math.sqrt(s*(s-this.s1)*(s-this.s2)*(s-this.s3)));
    }

    boolean isTriangle() {
        int sum1 = this.s1 + this.s2;
        int sum2 = this.s2 + this.s3;
        int sum3 = this.s3 + this.s1;

        if(sum1 < this.s3 || sum2 < this.s1 || sum3 < this.s2) {
            return false;
        }
    
        return true;
    }

    boolean isEquilateral() {
        if(this.s1 == this.s2) {
            if(this.s2 == this.s3) {
                return true;
            }
        }
        return false;
    }

    boolean isScalene() {
        if(this.s1 != this.s2) {
            if(this.s2 != this.s3) {
                if(this.s3 != this.s2) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isIsosceles() {

        if(this.s1 == this.s2) {
            if(this.s2 != this.s3) {
                return true;
            }
        }

        if(this.s2 == this.s3) {
            if(this.s2 != this.s1) {
                return true;
            }
        }

        if(this.s1 == this.s3) {
            if(this.s3 != this.s2) {
                return true;
            }
        }

        return false;
    }
}


class TriangleGUI extends JFrame {
    private JTextField side1Field, side2Field, side3Field;
    private JTextArea resultArea;

    public TriangleGUI() {
        setTitle("Triangle Classification");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Side 1:"));
        side1Field = new JTextField();
        inputPanel.add(side1Field);
        inputPanel.add(new JLabel("Side 2:"));
        side2Field = new JTextField();
        inputPanel.add(side2Field);
        inputPanel.add(new JLabel("Side 3:"));
        side3Field = new JTextField();
        inputPanel.add(side3Field);

        JButton classifyButton = new JButton("Classify");
        classifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classifyTriangle();
            }
        });

        inputPanel.add(classifyButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(resultArea, BorderLayout.CENTER);
    }

    private void classifyTriangle() {
        try {
            int side1 = Integer.parseInt(side1Field.getText());
            int side2 = Integer.parseInt(side2Field.getText());
            int side3 = Integer.parseInt(side3Field.getText());

            Triangle myTriangle = new Triangle(side1, side2, side3);

            if (myTriangle.isTriangle()) {
                resultArea.setText("");
                resultArea.append("Area of the Triangle is: " + myTriangle.findArea() + "\n");

                if (myTriangle.isEquilateral()) {
                    resultArea.append("The triangle is Equilateral.");
                } else if (myTriangle.isIsosceles()) {
                    resultArea.append("The triangle is Isosceles.");
                } else if (myTriangle.isScalene()) {
                    resultArea.append("The triangle is Scalene.");
                }
            } else {
                resultArea.append("Not a Triangle!");
            }

        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid input. Please enter valid side lengths.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TriangleGUI().setVisible(true);
            }
        });
    }
}
