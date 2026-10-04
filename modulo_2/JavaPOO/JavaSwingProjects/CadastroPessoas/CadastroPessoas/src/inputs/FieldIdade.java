package inputs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class FieldIdade extends JTextField {

    public FieldIdade(){                
        setFont(new Font("Arial",Font.PLAIN, 14));
        setHorizontalAlignment(JTextField.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setMaximumSize(new Dimension(20,10));
        setPreferredSize(new Dimension(20,10));
    }


}
