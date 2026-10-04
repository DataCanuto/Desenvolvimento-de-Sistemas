package btn;

import javax.swing.JButton;
import javax.swing.JTextField;

import Calculadora.Calculadora;

public class BtnMult extends JButton{
    public BtnMult(JTextField numberField, Calculadora calculadora){
        this.setText("x");
        this.addActionListener(e -> {
            if(numberField.getText().isEmpty()) return;

            double a = Double.parseDouble(numberField.getText());
            calculadora.processarOperacao(a,this.getText());
            numberField.setText("");
        });
    }



}


