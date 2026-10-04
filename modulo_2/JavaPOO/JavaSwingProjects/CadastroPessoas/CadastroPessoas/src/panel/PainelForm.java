package panel;

import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelForm extends JPanel{

    public PainelForm(JLabel nome, JTextField nomeField, JLabel idade, JTextField idadeField){
        setLayout(new GridLayout(4,1,5,5));
        setBorder(BorderFactory.createEmptyBorder(10,40,20,40));
        add(nome);
        add(nomeField);
        add(idade);
        add(idadeField);
        
    }

}
