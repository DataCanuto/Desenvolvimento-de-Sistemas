package btn;

import java.util.ArrayList;

import javax.swing.JButton;

import model.Usuario;

public class BtnCleanList extends JButton {

    public BtnCleanList(ArrayList<Usuario> usuarios){
        this.setText("Limpar lista");
        this.addActionListener(e -> {
            usuarios.clear();
        });
    }

}
