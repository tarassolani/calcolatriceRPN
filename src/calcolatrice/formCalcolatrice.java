package calcolatrice;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class formCalcolatrice extends JPanel{
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
    private JTextArea txtCronologia;
    private JButton btnCronologia;

    private Database db;
    String username;

    //Funzione che aggiunge cifre e segni all'input
    void OnButtonClick(JButton b){
        txtInput.setText(txtInput.getText()+b.getText());
    }

    //Conversione in notazione polacca inversa
    String convertToRPN(String input){
        String s="";
        Stack<Character> stack = new Stack<>();

        for(char c:input.toCharArray()){
            //Se si tratta di un numero, lo aggiungo direttamente alla stringa di output
            if(Character.isDigit(c)){
                s+=c;
            }
            //In tutti gli altri casi si tratta di simboli
            else if(c=='('){
                    stack.push(c);
                }
            else if(c==')'){ //Svuoto lo stack appena trovo una parentesi chiusa
                while (!stack.isEmpty() && stack.peek() != '(') {
                    s += " " + stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); //Tolgo la parentesi aperta rimasta
                }
            }
            //In tutti gli altri casi, confronto le priorità degli operatori, e tolgo elementi dallo stack in base alle priorità
            else{
                if(!s.isEmpty() && s.charAt(s.length() - 1) != ' '){
                    s+=" "; //Aggiungo uno spazio alla stringa di output in modo da separare i numeri
                }
                while(!stack.isEmpty() && comparePriority(stack.peek(), c)){
                    s+=stack.pop()+" ";
                }
                    //Inserisco l'ultimo operatore nello stack
                stack.push(c);
            }
        }

        //Svuoto lo stack quando finisco di scorrere la stringa di input
        while(!stack.isEmpty()){
            s+=" "+stack.pop();
        }
        return s;
    }

    //Calcolo espressione in notazione polacca inversa
    float solveRPN(String input){
        Stack<Float> st = new Stack<>(); //Stack per aggiungere i numeri
        float n1, n2;
        String[] arr = input.split("\\s+"); //Divisione della stringa di input

        for(String s:arr){
            float res=0;
            if(s.matches("\\d+")){
                st.push(Float.parseFloat(s));
            }
            else{
                n2=st.pop();
                n1=st.pop();
                if(s.equals("+")){
                    res=n1+n2;
                }
                else if(s.equals("-")){
                    res=n1-n2;
                }
                else if(s.equals("/") || s.equals("÷")){
                    res=n1/n2;
                }
                else if(s.equals("*") || s.equals("×")){
                    res=n1*n2;
                }
                st.push(res);
            }
        }
        return st.pop();
    }

    //Assegno priorità agli operatori
    int operatorPriority(char c){
        if(c=='*' || c=='×' || c=='/' || c=='÷'){
            return 2;
        }
        else if(c=='+' || c=='-'){
            return 1;
        }
        return 0;
    }

    //Confronto priorità tra due operatori
    boolean comparePriority(char c1, char c2){
        if(operatorPriority(c1) >= operatorPriority(c2)){
            return true;
        }
        return false;
    }

    //Controllo se la stringa è RPN o infissa
    boolean isPostfix(String input){
        char lastChar=input.charAt(input.length()-1);
        if(lastChar=='+'||lastChar=='-'||lastChar=='*'||lastChar=='/'||lastChar=='×'||lastChar=='÷'){
            return true;
        }
        return false;
    }

    public formCalcolatrice(Database database, String user) {

        db=database;
        username=user;

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
        bSolve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText=txtInput.getText();
                if(!inputText.isBlank() && !inputText.isEmpty()) { //Se l'input non è vuoto
                    if (isPostfix(inputText)) { //Controllo se si tratta di espressione RPN o infissa
                        txtOutput.setText(Float.toString(solveRPN(inputText))); //Calcolo direttamente il risultato
                    } else {
                        txtOutput.setText(Float.toString(solveRPN(convertToRPN(inputText)))); //Converto in RPN prima di trovare il risultato
                    }
                    db.InsertExpression(username, inputText, Float.parseFloat(txtOutput.getText()));
                }
            }
        });

        //Button per mostrare la cronologia di espressioni di un dato utente
        btnCronologia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCronologia.setText(db.SelectFromCronologia(username).toString());
            }
        });
    }

    public void showForm() {
        JFrame frame = new JFrame("Form Calcolatrice");
        frame.setContentPane(panelBase);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /*//Main
    public static void main(String[] args) {
        JFrame frame = new JFrame("formCalcolatrice");
        frame.setContentPane(new formCalcolatrice().panelBase);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }*/

}
