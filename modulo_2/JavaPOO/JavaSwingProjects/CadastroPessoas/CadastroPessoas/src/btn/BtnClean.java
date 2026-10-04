package btn;

import javax.swing.JButton;
import javax.swing.JTextField;

public class BtnClean extends JButton{

    public BtnClean(JTextField nomeField, JTextField idadeField){
        this.setText("Limpar");
        this.addActionListener(e ->{
            nomeField.setText("");
            idadeField.setText("");
        });
    }

}
