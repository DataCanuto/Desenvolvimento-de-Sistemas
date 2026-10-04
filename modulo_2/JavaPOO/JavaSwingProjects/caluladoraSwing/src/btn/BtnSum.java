package btn;

import Calculadora.Calculadora;
import javax.swing.*;

public class BtnSum extends JButton {
    public BtnSum(JTextField numberField, Calculadora calculadora) {
        this.setText("+");

        this.addActionListener(e ->{
            if(numberField.equals("")){
                double a = 0;
            }
            double a = Double.parseDouble(numberField.getText());
            calculadora.processarOperacao(a,this.getText());
            numberField.setText("");
        });
    }
}
