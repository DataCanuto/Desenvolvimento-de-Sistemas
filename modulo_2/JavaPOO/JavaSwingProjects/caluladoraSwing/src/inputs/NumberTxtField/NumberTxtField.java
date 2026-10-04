package inputs.NumberTxtField;

import java.awt.*;
import javax.swing.*;

public class NumberTxtField extends JTextField {
    public NumberTxtField(){
        this.setText("0");
        Dimension dimension = new Dimension(300,50);
        this.setFont(new Font("Arial", Font.PLAIN,20));
        this.setHorizontalAlignment(LEFT);
        this.setSize(dimension);
        this.setPreferredSize(dimension);

    }
}
