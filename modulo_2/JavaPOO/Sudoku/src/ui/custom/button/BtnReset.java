package ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BtnReset extends JButton {

    public BtnReset(final ActionListener actionListener){
        this.setText("Reiniciar jogo");
        this.addActionListener(actionListener);
    }
}
