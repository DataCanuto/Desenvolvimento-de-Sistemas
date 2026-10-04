package btn;

import javax.swing.JButton;
import javax.swing.JTextField;

public class BtnClear extends JButton {
    public BtnClear (JTextField numberField){
        this.setText("C");
        this.addActionListener(e ->{
            numberField.setText("0");
        });
        
    }

}
