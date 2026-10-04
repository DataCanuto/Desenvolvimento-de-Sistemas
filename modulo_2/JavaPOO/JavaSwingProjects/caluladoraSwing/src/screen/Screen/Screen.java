package screen.Screen;

import Calculadora.Calculadora;
import inputs.NumberTxtField.NumberTxtField;
import java.awt.BorderLayout;
import javax.swing.*;
import panel.BtnPanel;
import panel.NumberPanel;

public class Screen extends JFrame{
    private JTextField numberField;
    private Calculadora calculadora;

    public Screen(){
        this.calculadora = new Calculadora();
        this.numberField = new NumberTxtField();

        this.setLayout(new BorderLayout(5,5));
        this.add(numberField, BorderLayout.NORTH);
        this.add(new NumberPanel(numberField), BorderLayout.CENTER);
        this.add(new BtnPanel(numberField, calculadora), BorderLayout.EAST);

        this.setTitle("Calculadora");
        this.setSize(350,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
