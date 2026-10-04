package inputs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class FieldNome extends JTextField{

    public FieldNome(){        
        setFont(new Font("Arial",Font.BOLD,14));
        setHorizontalAlignment(LEFT);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        setMaximumSize(new Dimension(20,40));
        setPreferredSize(new Dimension(20,40));
    }

}
