import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ArithmeticGame extends JFrame {
    private JPanel panel1, panel2, panel3;
    private JTextField num1Field, num2Field, operatorLabel, userInputField;
    private JButton submitButton, cancelButton, nextButton;
    private JLabel messageLabel, scrollingLabel, correctLabel, incorrectLabel;
    private JRadioButton addButton, subButton, mulButton, divButton;
    private JRadioButton level1Button, level2Button, level3Button;
    private ButtonGroup operatorGroup, levelGroup;
    private int num1, num2, correctAnswer;
    private String selectedOperator;
    private Random random = new Random();
    private int correctCount = 0, incorrectCount = 0; // Scoreboard counters
    private String[] messages = {
        "Let's see if you can solve this one!",
        "Math is fun, right? Prove it!",
        "Challenge accepted? Go for it!",
        "Think fast and calculate!",
        "You're a math wizard in the making!"
    };
    private String scrollText = "this is programmed by: LOLO, LEANDRO ALEXIS ";
    private Timer scrollTimer;

    public ArithmeticGame() {
        setTitle("Arithmetic Game");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel 3: Radio buttons for operator and level
        panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createTitledBorder("Settings"));
        panel3.setLayout(new GridLayout(2, 4));

        operatorGroup = new ButtonGroup();
        addButton = new JRadioButton("Addition (+)", true);
        subButton = new JRadioButton("Subtraction (-)");
        mulButton = new JRadioButton("Multiplication (*)");
        divButton = new JRadioButton("Division (/)");
        operatorGroup.add(addButton);
        operatorGroup.add(subButton);
        operatorGroup.add(mulButton);
        operatorGroup.add(divButton);

        levelGroup = new ButtonGroup();
        level1Button = new JRadioButton("Level 1 (1-100)", true);
        level2Button = new JRadioButton("Level 2 (100-200)");
        level3Button = new JRadioButton("Level 3 (200-300)");
        levelGroup.add(level1Button);
        levelGroup.add(level2Button);
        levelGroup.add(level3Button);

        panel3.add(new JLabel("Operator:"));
        panel3.add(addButton);
        panel3.add(subButton);
        panel3.add(mulButton);
        panel3.add(divButton);
        panel3.add(new JLabel("Level:"));
        panel3.add(level1Button);
        panel3.add(level2Button);
        panel3.add(level3Button);

        // Panel 1: Display numbers, operator, input field, buttons, and scoreboard labels
        panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createTitledBorder("Arithmetic Problem"));
        panel1.setLayout(new FlowLayout());

        num1Field = new JTextField(5);
        num1Field.setEditable(false);
        num1Field.setHorizontalAlignment(JTextField.CENTER);
        num1Field.setFont(new Font("Arial", Font.BOLD, 20));

        operatorLabel = new JTextField(3);
        operatorLabel.setEditable(false);
        operatorLabel.setHorizontalAlignment(JTextField.CENTER);
        operatorLabel.setFont(new Font("Arial", Font.BOLD, 20));

        num2Field = new JTextField(5);
        num2Field.setEditable(false);
        num2Field.setHorizontalAlignment(JTextField.CENTER);
        num2Field.setFont(new Font("Arial", Font.BOLD, 20));

        userInputField = new JTextField(10);
        userInputField.setFont(new Font("Arial", Font.PLAIN, 16));

        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");
        nextButton = new JButton("Next");

        // Scoreboard labels
        correctLabel = new JLabel("Correct: " + correctCount);
        correctLabel.setFont(new Font("Arial", Font.BOLD, 14));
        incorrectLabel = new JLabel("Incorrect: " + incorrectCount);
        incorrectLabel.setFont(new Font("Arial", Font.BOLD, 14));

        panel1.add(num1Field);
        panel1.add(operatorLabel);
        panel1.add(num2Field);
        panel1.add(new JLabel(" = "));
        panel1.add(userInputField);
        panel1.add(submitButton);
        panel1.add(cancelButton);
        panel1.add(nextButton);
        panel1.add(correctLabel);
        panel1.add(incorrectLabel);

        // Panel 2: Message label and scrolling text
        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createTitledBorder("Message"));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS)); // Vertical layout for stacking

        messageLabel = new JLabel("Select operator and level, then click Next to start!");
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        scrollingLabel = new JLabel(scrollText);
        scrollingLabel.setFont(new Font("Arial", Font.BOLD, 14));
        scrollingLabel.setHorizontalAlignment(JLabel.CENTER);
        scrollingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel2.add(messageLabel);
        panel2.add(Box.createVerticalStrut(10)); // Spacer
        panel2.add(scrollingLabel);

        // Add panels to frame
        add(panel3, BorderLayout.NORTH);
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        // Event listeners
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateProblem();
                userInputField.setText("");
                messageLabel.setText(messages[random.nextInt(messages.length)]);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userInputField.setText("");
                messageLabel.setText("Cancelled. Click Next for a new problem.");
            }
        });

        // Scrolling text timer
        scrollTimer = new Timer(300, new ActionListener() { // Update every 200ms for smooth scrolling
            public void actionPerformed(ActionEvent e) {
                // Shift text from right to left: move first char to end
                scrollText = scrollText.substring(1) + scrollText.charAt(0);
                scrollingLabel.setText(scrollText);
            }
        });
        scrollTimer.start();

        setVisible(true);
    }

    private void generateProblem() {
        // Determine range based on level
        int min = 1, max = 100;
        if (level2Button.isSelected()) {
            min = 100; max = 200;
        } else if (level3Button.isSelected()) {
            min = 200; max = 300;
        }

        num1 = random.nextInt(max - min + 1) + min;
        num2 = random.nextInt(max - min + 1) + min;

        // Determine operator
        if (addButton.isSelected()) {
            selectedOperator = "+";
            correctAnswer = num1 + num2;
        } else if (subButton.isSelected()) {
            selectedOperator = "-";
            correctAnswer = num1 - num2;
        } else if (mulButton.isSelected()) {
            selectedOperator = "*";
            correctAnswer = num1 * num2;
        } else if (divButton.isSelected()) {
            selectedOperator = "/";
            int attempts = 0;
            do {
                if (attempts > 100) {
                    num1 = random.nextInt(max - min + 1) + min;
                    attempts = 0;
                }
                num2 = random.nextInt(max) + 1; // Allow num2 from 1 to max for more divisors
                attempts++;
            } while (num2 == 0 || num1 % num2 != 0 || num2 == num1);
            correctAnswer = num1 / num2;
        }

        num1Field.setText(String.valueOf(num1));
        operatorLabel.setText(selectedOperator);
        num2Field.setText(String.valueOf(num2));
    }

    private void checkAnswer() {
        try {
            int userAnswer = Integer.parseInt(userInputField.getText().trim());
            if (userAnswer == correctAnswer) {
                correctCount++;
                messageLabel.setText("Congratulations! You have got the correct answer.");
            } else {
                incorrectCount++;
                messageLabel.setText("Try again and do better. Correct answer: " + correctAnswer);
            }
            correctLabel.setText("Correct: " + correctCount);
            incorrectLabel.setText("Incorrect: " + incorrectCount);
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ArithmeticGame());
    }
}
