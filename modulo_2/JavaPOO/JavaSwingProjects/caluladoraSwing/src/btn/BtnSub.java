package btn;

import Calculadora.Calculadora;
import javax.swing.*;

public class BtnSub extends JButton {
    public BtnSub(JTextField numberField, Calculadora calculadora) {
        this.setText("-");
        this.addActionListener(e -> {
            if(numberField.equals("")){
                double a = 0;
            }
            double a = Double.parseDouble(numberField.getText());
            calculadora.processarOperacao(a,this.getText());
            numberField.setText("");
        });
    }
}
