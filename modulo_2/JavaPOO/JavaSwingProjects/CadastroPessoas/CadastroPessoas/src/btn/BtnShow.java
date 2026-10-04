package btn;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Usuario;

public class BtnShow extends JButton {
    public BtnShow(ArrayList<Usuario> usuarios){
        this.setText("Exibir");
        this.addActionListener(e -> {
            if (usuarios.isEmpty()){
                JOptionPane.showMessageDialog(null,"Nenhum usuário cadastrado");
            }else{
                StringBuilder sb = new StringBuilder();
                for(Usuario u : usuarios){
                    sb.append(u.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null,sb.toString(),"Usuários Cadastrados", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
