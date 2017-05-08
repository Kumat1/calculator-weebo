import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kirana on 07/05/2017.
 */
public class Calculator extends JFrame {
    private JPanel panelMain;
    private JTextField Display;
    private JPanel panelButtons;
    private Double displayValue;
    private Double tempValue;
    private JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonTimes, buttonDiv, buttonAdd, buttonMin, buttonDel, buttonPosMin, buttonEq;
    private Font fontDisplay, fontButton;
    private char lastOperator;

    private ActionListener actionButton = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("buttonAdd") || command.equals("buttonMin") || command.equals("buttonTimes") || command.equals("buttonDiv") || command.equals("buttonPosMin") || command.equals("buttonEq")) {
                if (lastOperator != ' ') {
                    if (lastOperator == '+') {
                        tempValue = tempValue + displayValue;
                    } else if (lastOperator == '-') {
                        tempValue = tempValue - displayValue;
                    } else if (lastOperator == 'x') {
                        tempValue = tempValue * displayValue;
                    } else if (lastOperator == '/') {
                        tempValue = tempValue / displayValue;
                    } else if (lastOperator == '.') {
                        tempValue = tempValue * -1;
                    }
                    displayValue = tempValue;
                } else {
                    tempValue = displayValue;
                }

                updateDisplay();
                displayValue = 0d;

                if (command.equals("buttonAdd")) {
                    lastOperator = '+';
                } else if (command.equals("buttonMin")) {
                    lastOperator = '-';
                } else if (command.equals("buttonTimes")) {
                    lastOperator = 'x';
                } else if (command.equals("buttonDiv")) {
                    lastOperator = '/';
                } else if (command.equals("buttonPosMin")) {
                    lastOperator ='.';
                } else if (command.equals("buttonEq")) {
                    lastOperator = '=';
                }
            } else if (command.equals("buttonDel")) {
                String stringLayar = Display.getText();

                if (displayValue == 0d && Double.parseDouble(stringLayar) != 0d) {
                    stringLayar = "0.0";
                }
                stringLayar = stringLayar.substring(0, stringLayar.length() - 1);
                displayValue = Double.parseDouble(stringLayar.isEmpty() ? "0.0" : stringLayar);
                updateDisplay();
            } else {
                displayValue = displayValue * 10 + Integer.parseInt(String.valueOf(command.charAt(6)));
                updateDisplay();
            }
        }
    };

    public Calculator() {
        this.setTitle("Calculator");
        this.setSize(400, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setFont(new JLabel().getFont());

        displayValue = 0d;
        tempValue = 0d;
        lastOperator = ' ';

        fontDisplay = this.getFont().deriveFont(60f);
        fontButton = this.getFont().deriveFont(30f);

        panelMain = (JPanel) this.getContentPane();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));

        Display = new JTextField();
        Display.setEditable(false);
        Display.setHorizontalAlignment(SwingConstants.RIGHT);
        Display.setFont(fontDisplay);
        Display.setPreferredSize(new Dimension(this.getWidth(), 100));
        Display.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        updateDisplay();

        panelMain.add(Display);

        panelButtons = new JPanel();
        panelButtons.setBackground(Color.GRAY);
        panelButtons.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;

        button1 = new JButton("1");
        button1.setFont(fontButton);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        button1.setActionCommand("button1");
        button1.addActionListener(actionButton);
        panelButtons.add(button1, gridBagConstraints);

        button2 = new JButton("2");
        button2.setFont(fontButton);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        button2.setActionCommand("button2");
        button2.addActionListener(actionButton);
        panelButtons.add(button2, gridBagConstraints);

        button3 = new JButton("3");
        button3.setFont(fontButton);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        button3.setActionCommand("button3");
        button3.addActionListener(actionButton);
        panelButtons.add(button3, gridBagConstraints);

        button4 = new JButton("4");
        button4.setFont(fontButton);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        button4.setActionCommand("button4");
        button4.addActionListener(actionButton);
        panelButtons.add(button4, gridBagConstraints);

        button5 = new JButton("5");
        button5.setFont(fontButton);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        button5.setActionCommand("button5");
        button5.addActionListener(actionButton);
        panelButtons.add(button5, gridBagConstraints);

        button6 = new JButton("6");
        button6.setFont(fontButton);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        button6.setActionCommand("button6");
        button6.addActionListener(actionButton);
        panelButtons.add(button6, gridBagConstraints);

        button7 = new JButton("7");
        button7.setFont(fontButton);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        button7.setActionCommand("button7");
        button7.addActionListener(actionButton);
        panelButtons.add(button7, gridBagConstraints);

        button8 = new JButton("8");
        button8.setFont(fontButton);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        button8.setActionCommand("button8");
        button8.addActionListener(actionButton);
        panelButtons.add(button8, gridBagConstraints);

        button9 = new JButton("9");
        button9.setFont(fontButton);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        button9.setActionCommand("button9");
        button9.addActionListener(actionButton);
        panelButtons.add(button9, gridBagConstraints);

        button0 = new JButton("0");
        button0.setFont(fontButton);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        button0.setActionCommand("button0");
        button0.addActionListener(actionButton);
        panelButtons.add(button0, gridBagConstraints);

        buttonAdd = new JButton("+");
        buttonAdd.setFont(fontButton);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        buttonAdd.setActionCommand("buttonAdd");
        buttonAdd.addActionListener(actionButton);
        panelButtons.add(buttonAdd, gridBagConstraints);

        buttonMin = new JButton("-");
        buttonMin.setFont(fontButton);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        buttonMin.setActionCommand("buttonMin");
        buttonMin.addActionListener(actionButton);
        panelButtons.add(buttonMin, gridBagConstraints);

        buttonTimes = new JButton("x");
        buttonTimes.setFont(fontButton);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        buttonTimes.setActionCommand("buttonTimes");
        buttonTimes.addActionListener(actionButton);
        panelButtons.add(buttonTimes, gridBagConstraints);

        buttonDiv = new JButton("/");
        buttonDiv.setFont(fontButton);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        buttonDiv.setActionCommand("buttonDiv");
        buttonDiv.addActionListener(actionButton);
        panelButtons.add(buttonDiv, gridBagConstraints);

        buttonDel = new JButton("Del");
        buttonDel.setFont(fontButton);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        buttonDel.setActionCommand("buttonDel");
        buttonDel.addActionListener(actionButton);
        panelButtons.add(buttonDel, gridBagConstraints);

        buttonPosMin = new JButton("+/-");
        buttonPosMin.setFont(fontButton);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        buttonPosMin.setActionCommand("buttonPosMin");
        buttonPosMin.addActionListener(actionButton);
        panelButtons.add(buttonPosMin, gridBagConstraints);

        buttonEq = new JButton("=");
        buttonEq.setFont(fontButton);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        buttonEq.setActionCommand("buttonEq");
        buttonEq.addActionListener(actionButton);
        panelButtons.add(buttonEq, gridBagConstraints);

        panelMain.add(panelButtons);

        this.setVisible(true);
    }

    private void updateDisplay() {
        String stringToDisplay = "";

        if (isWholeDecimal(displayValue)) {
            stringToDisplay = ((Integer) displayValue.intValue()).toString();
        } else {
            stringToDisplay = displayValue.toString();
        }
        Display.setText(stringToDisplay);
    }

    private boolean isWholeDecimal(Double value) {
        return (value == Math.floor(value)) && !Double.isInfinite(value);
    }

    public  static void main(String[] args) {
        new Calculator();
    }
}
