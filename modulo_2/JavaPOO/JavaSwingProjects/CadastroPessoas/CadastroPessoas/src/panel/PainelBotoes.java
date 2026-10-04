package panel;

import javax.swing.JPanel;

import btn.BtnAdd;
import btn.BtnClean;
import btn.BtnCleanList;
import btn.BtnShow;

import java.awt.FlowLayout;
import javax.swing.BorderFactory;

import javax.swing.JButton;

public class PainelBotoes extends JPanel{

    public PainelBotoes(JButton add, JButton clean, JButton show, JButton cleanList){
        setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        add(add);
        add(clean);
        add(show);
        add(cleanList);
    }

}
