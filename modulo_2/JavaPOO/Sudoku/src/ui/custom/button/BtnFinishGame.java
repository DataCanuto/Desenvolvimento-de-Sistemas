package ui.custom.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BtnFinishGame extends JButton {

    public BtnFinishGame(final ActionListener actionListener){
        this.setText("Concluir");
        this.addActionListener(actionListener);
    }


}
