package btn;

import Calculadora.Calculadora;
import javax.swing.JButton;
import javax.swing.JTextField;

public class BtnDiv extends JButton {
    public BtnDiv(JTextField numberField, Calculadora calculadora){
        this.setText("/");
        this.addActionListener(e ->{
            if(numberField.getText().isEmpty()) return;
            double a = Double.parseDouble(numberField.getText());
            calculadora.processarOperacao(a,this.getText());
            numberField.setText("");
        });
    }

}
