package ui.custom.screen;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import static javax.swing.JOptionPane.*;
import model.Space;
import service.BoardService;
import static service.EventEnum.*;
import service.NotifierService;
import ui.custom.button.BtnCheckGameStatus;
import ui.custom.button.BtnFinishGame;
import ui.custom.button.BtnReset;
import ui.custom.frame.MainFrame;
import ui.custom.inputs.NumberText;
import ui.custom.panel.MainPanel;
import ui.custom.panel.SudokuSector;

public class MainScreen {

    private final static Dimension dimension = new Dimension(600, 600);

    private final BoardService boardService;
    private final NotifierService notifierService;

    private JButton btnFinishGame;
    private JButton btnCheckGameStatus;
    private JButton btnReset;

    public MainScreen(final Map<String, String> gameConfig) {
        this.boardService = new BoardService(gameConfig);
        this.notifierService = new NotifierService();
    }

    public void buildMainScreen(){
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);
        for(int r = 0; r < 9; r+= 3){
            var endRow = r + 2;
            for (int c = 0; c < 9; c+= 3){
                var endCol = c + 2;
                var spaces = getSpacesFromSector(boardService.getSpaces(),c, endCol, r, endRow);
                JPanel sector = generateSection(spaces);
                mainPanel.add(sector);
                /*List<Space> sectorSpaces = new ArrayList<>();
                for (int row = r; row <= endRow; row++) {
                    for (int col = c; col <= endCol; col++) {
                        sectorSpaces.add(boardService.getSpaces().get(row).get(col));
                    }
                }
                mainPanel.add(generateSection(sectorSpaces));*/
            }
        }
        addResetBtn(mainPanel);
        addShowGameStatusBtn(mainPanel);
        addFinishGameBtn(mainPanel);
        mainFrame.revalidate();
        mainFrame.repaint();

    }

    private List<Space> getSpacesFromSector(
        List<List<Space>> spaces, 
        final int initColl, final int endCol,
        final int initRow, final int endRow){
            List<Space> spaceSector = new ArrayList<>();
            for (int r = initRow; r <= endRow; r++){
                for(int c = initColl; c <= endCol; c++){
                    spaceSector.add(spaces.get(c).get(r));
                }
            }
            return spaceSector;
    }

    private JPanel generateSection(final List<Space> spaces){
        List<NumberText> fields = spaces.stream().map(NumberText::new).toList();
        fields.forEach(t -> notifierService.subscriber(CLEAR_SPACE,t));
        return new SudokuSector(fields);
    }

    private void addFinishGameBtn(JPanel mainPanel) {
        btnFinishGame = new BtnFinishGame(e -> {
            if(boardService.gameIsFinished()){
                showMessageDialog(null, "Parabéms, você concluiu o jogo");
                btnReset.setEnabled(false);
                btnCheckGameStatus.setEnabled(false);
                btnFinishGame.setEnabled(false);
            } else {
                showMessageDialog(null,"Seu jogo tem alguma inconsistência\nAjuste e tente novamente.");
            }
        });

        mainPanel.add(btnFinishGame);


    }

    private void addShowGameStatusBtn(JPanel mainPanel) {
        btnCheckGameStatus = new BtnCheckGameStatus(e -> {
            var hasErrors = boardService.hasErrors();
            var gameStatus = boardService.getStatus();
            var message = switch(gameStatus){
                case NON_STARTED -> "O jogo ainda não foi iniciado";
                case INCOMPLETE -> "O jogo está incompleto";
                case COMPLETE -> "O jogo está completo";
            };
            message += hasErrors ? " e contem errros" : " e não contem erros";
            showMessageDialog(null,message);
        });
        mainPanel.add(btnCheckGameStatus);

    }

    private void addResetBtn(JPanel mainPanel) {
        btnReset = new BtnReset(e ->{
            var dialogResult = showConfirmDialog(
                    null,
                    "Deseja realmente reiniciar o jogo?",
                    "Limpar o jogo",
                    YES_NO_OPTION,
                    QUESTION_MESSAGE
            );
            if(dialogResult == 0){
                boardService.reset();
                notifierService.notify(CLEAR_SPACE);
            }

        });
        mainPanel.add(btnReset);

    }
}
