package btn;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;

public class BtnNumber extends JButton{

    public BtnNumber(JTextField numberField, String n){
        Dimension dimension = new Dimension(30,15);
        this.setText(n);
        this.setSize(dimension);
        this.setPreferredSize(dimension);        
        this.addActionListener(e ->{
            numberField.setText(this.getText());
        });
    }

}
