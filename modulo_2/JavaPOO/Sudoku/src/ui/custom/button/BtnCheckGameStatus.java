package ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BtnCheckGameStatus extends JButton {

    public BtnCheckGameStatus(final ActionListener actionListener){
        this.setText("Verificar jogo");
        this.addActionListener(actionListener);
    }
}
