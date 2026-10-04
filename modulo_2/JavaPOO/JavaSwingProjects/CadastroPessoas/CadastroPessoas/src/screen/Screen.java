package screen;

import btn.BtnAdd;
import btn.BtnClean;
import btn.BtnCleanList;
import btn.BtnShow;
import inputs.FieldIdade;
import inputs.FieldNome;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Usuario;
import panel.PainelBotoes;
import panel.PainelForm;

public class Screen extends JFrame{

    private JTextField campoNome;
    private JTextField campoIdade;
    private JLabel labelNome;
    private JLabel labelIdade;
    private ArrayList<Usuario> usuarios;

    public Screen(){
        campoNome = new FieldNome();
        campoIdade = new FieldIdade();
        labelNome = new JLabel("Nome");
        labelIdade = new JLabel("Idade");
        usuarios = new ArrayList<>();

        BtnAdd btnAdd = new BtnAdd(campoNome, campoIdade, usuarios);
        BtnShow btnShow = new BtnShow(usuarios);
        BtnClean btnClean = new BtnClean(campoNome, campoIdade);
        BtnCleanList btnCleanList = new BtnCleanList(usuarios);

        PainelForm painelForm = new PainelForm(labelNome,campoNome,labelIdade,campoIdade);
        PainelBotoes painelBotoes = new PainelBotoes(btnAdd, btnClean, btnShow, btnCleanList);

        painelForm.add(labelNome); 
        painelForm.add(campoNome);
        painelForm.add(labelIdade); 
        painelForm.add(campoIdade);

        painelBotoes.add(btnAdd);
        painelBotoes.add(btnShow);
        painelBotoes.add(btnClean);
        painelBotoes.add(btnCleanList);
        
        add(painelForm, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        
        setTitle("Cadastro de Usuários");        
        setSize(800,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

   


}
