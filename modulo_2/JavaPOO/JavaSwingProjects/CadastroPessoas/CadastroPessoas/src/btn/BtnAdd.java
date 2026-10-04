package btn;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.Usuario;

public class BtnAdd extends JButton{
    public BtnAdd(JTextField nomeField, JTextField idadeField, ArrayList<Usuario> usuarios){
        this.setText("Adicionar");
        this.addActionListener(e -> {
            String nome = nomeField.getText();
            int idade = Integer.parseInt(idadeField.getText());
            Usuario usuario = new Usuario(nome,idade);
            usuarios.add(usuario);
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
        });
    }

    

}
