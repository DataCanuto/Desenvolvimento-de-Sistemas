package panel;

import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import btn.BtnNumber;

public class NumberPanel extends JPanel {
    public NumberPanel(JTextField numberField){
        this.setLayout(new GridLayout(3,3,5,5));
        int[] ordem = {7,8,9,6,5,4,3,2,1};

        for(int num : ordem){
            this.add(new BtnNumber(numberField, String.valueOf(num)));
        }
        
    }

}
