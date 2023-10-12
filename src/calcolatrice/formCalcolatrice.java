package calcolatrice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formCalcolatrice {
    private JPanel panelBase;
    private JTextField txtOutput;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b0;
    private JButton bParOpen;
    private JButton bParClose;
    private JButton bPlus;
    private JButton bMinus;
    private JButton bTimes;
    private JButton bDiv;
    private JButton bCanc;
    private JButton bSolve;
    private JTextField txtInput;

    //Funzione che aggiunge cifre e segni all'input
    void OnButtonClick(JButton b){
        txtInput.setText(txtInput.getText()+b.getText());
    }

    String convertToRPN(String input){
        String s="";

        return s;
    }

    public formCalcolatrice() {

        //AGGIUNTA DI LISTENERS AI TASTI
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(b1);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(b2);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(b3);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(b4);
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(b5);
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(b6);
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(b7);
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(b8);
            }
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(b9);
            }
        });
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(b0);
            }
        });
        bParOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(bParOpen);
            }
        });
        bParClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(bParClose);
            }
        });
        bPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(bPlus);
            }
        });
        bMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(bMinus);
            }
        });
        bTimes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(bTimes);
            }
        });
        bDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OnButtonClick(bDiv);
            }
        });
        bCanc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtInput.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("formCalcolatrice");
        frame.setContentPane(new formCalcolatrice().panelBase);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
