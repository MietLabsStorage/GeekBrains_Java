package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static void create(){
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField left, right;
        left = new JTextField(15);
        right = new JTextField(15);

        JButton runButton = new JButton("calculate");

        JLabel labelX = new JLabel("x:");
        JLabel labelY = new JLabel("y:");

        JLabel[] label = new JLabel[5];
        label[0] = new JLabel("x + y =");
        label[1] = new JLabel("x - y =");
        label[2] = new JLabel("x * y =");
        label[3] = new JLabel("x / y =");
        label[4] = new JLabel("x ^ y =");

        runButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(left.getText());
                    double y = Double.parseDouble(right.getText());
                    /*label[0].setText(x + " + " + y + " = " + Calculator.add(x, y));
                    label[1].setText(x + " - " + y + " = " + Calculator.subtract(x, y) + "\n");
                    label[2].setText(x + " * " + y + " = " + Calculator.multiply(x, y) + "\n");
                    label[3].setText(x + " / " + y + " = " + Calculator.divide(x, y) + "\n");
                    label[4].setText(x + " ^ " + y + " = " + Calculator.power(x, y) + "\n");
                    frame.pack();*/
                }
                catch (Exception exception){
                    JOptionPane.showMessageDialog(frame, exception.toString());
                }
            }
        });

        JPanel panelX = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelY = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panelXY = new JPanel(new GridLayout(2,1));
        JPanel panelXYCalculate = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel labels = new JPanel(new GridLayout(5, 1));
        JPanel contentlabels = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel allContents = new JPanel(new GridLayout(2, 1));
        JPanel iHaveNoNewNames = new JPanel(new FlowLayout(FlowLayout.CENTER));

        panelX.add(labelX);
        panelX.add(left);
        panelY.add(labelY);
        panelY.add(right);
        panelXY.add(panelX);
        panelXY.add(panelY);
        panelXYCalculate.add(panelXY);
        panelXYCalculate.add(runButton);
        for(JLabel jlabels : label)
            labels.add(jlabels);
        contentlabels.add(labels);
        allContents.add(panelXYCalculate);
        allContents.add(contentlabels);
        iHaveNoNewNames.add(allContents);
        frame.setContentPane(iHaveNoNewNames);

        frame.pack();
        frame.setLocation(400,300);
        frame.setVisible(true);
    }

    public static void createGUI(){
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton[] buttonNum = new JButton[10];
        for(int i = 0; i < buttonNum.length; i++){
            buttonNum[i] = new JButton(Integer.toString(i));
        }
        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonMultiply = new JButton("*");
        JButton buttonDivide = new JButton("/");
        JButton buttonPower = new JButton("^");
        JButton[] buttonOperation = {buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonPower};
        JButton buttonDote = new JButton(".");
        JButton buttonAnswer = new JButton("=");
        JButton buttonPlusMinus = new JButton("+/-");
        JLabel answerLabel = new JLabel(Calculator.getMessage());




        for(JButton button : buttonNum){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Calculator.setNum(Integer.parseInt(button.getText()));
                    answerLabel.setText(Calculator.getMessage());
                    frame.pack();
                }
            });
        }
        for(JButton button : buttonOperation){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Calculator.operation(button.getText());
                    answerLabel.setText(Calculator.getMessage());
                    frame.pack();
                }
            });
        }
        buttonDote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator.setDote();
                answerLabel.setText(Calculator.getMessage());
                frame.pack();
            }
        });
        buttonAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator.answer();
                answerLabel.setText(Calculator.getMessage());
                frame.pack();
            }
        });
        buttonPlusMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calculator.setMinus();
                answerLabel.setText(Calculator.getMessage());
                frame.pack();
            }
        });




        JPanel keyboardPanel = new JPanel(new GridLayout(5,5));
        JPanel outputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel allPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        outputPanel.add(answerLabel);
        for(JButton button : buttonNum){
            keyboardPanel.add(button);
        }
        for(JButton button : buttonOperation){
            keyboardPanel.add(button);
        }
        keyboardPanel.add(buttonDote);
        keyboardPanel.add(buttonAnswer);
        keyboardPanel.add(buttonPlusMinus);
        allPanel.add(outputPanel);
        allPanel.add(keyboardPanel);

        frame.setContentPane(allPanel);
        frame.pack();
        frame.setLocation(400,300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }
}
