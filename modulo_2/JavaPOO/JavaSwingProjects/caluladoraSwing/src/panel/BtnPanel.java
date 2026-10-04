package panel;

import Calculadora.Calculadora;
import btn.BtnClear;
import btn.BtnDiv;
import btn.BtnEqual;
import btn.BtnMult;
import btn.BtnSub;
import btn.BtnSum;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BtnPanel extends JPanel{
    public BtnPanel(JTextField numberField, Calculadora calculadora){
        this.setLayout(new GridLayout(4,1,5,5));

        this.add(new BtnSum(numberField, calculadora));
        this.add(new BtnSub(numberField, calculadora));
        this.add(new BtnMult(numberField, calculadora));
        this.add(new BtnDiv(numberField, calculadora));
        this.add(new BtnEqual(numberField, calculadora));
        this.add(new BtnClear(numberField));
        

        
    }

}
