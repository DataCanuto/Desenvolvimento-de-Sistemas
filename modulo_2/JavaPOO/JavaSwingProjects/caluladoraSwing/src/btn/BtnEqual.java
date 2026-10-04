package btn;

import Calculadora.Calculadora;
import javax.swing.*;

public class BtnEqual extends JButton {
    public BtnEqual(JTextField numberField, Calculadora calculadora){
        this.setText("=");
        this.addActionListener(e ->{
            if(numberField.getText().isEmpty()) return;
            double v = Double.parseDouble(numberField.getText());
            double result = calculadora.calcularResultado(v);
            numberField.setText(Calculadora.formatarResultado(result));
        });
    }
}
