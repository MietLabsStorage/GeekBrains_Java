package com.company.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoard extends JFrame {
    static int dimention = 3;
    static int cellSize = 150;
    private char[][] gameField;
    private GameButton[] gameButtons;

    private Game game;

    static char nullSymbol = '\u0000';

    public GameBoard(Game currentGame){
        this.game = currentGame;
        initField();
    }

    private void initField(){
        setBounds((cellSize * dimention), cellSize * dimention, 400, 300);
        setTitle("X-es - O-es");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("New game");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(newGameButton);
        controlPanel.setSize(cellSize * dimention, 150);

        JPanel gameFieldPanel = new JPanel();
        gameFieldPanel.setLayout(new GridLayout(dimention, dimention));
        gameFieldPanel.setSize(cellSize * dimention, cellSize * dimention);

        gameField = new char[dimention][dimention];
        gameButtons = new GameButton[dimention*dimention];

        for(int i = 0; i < (dimention*dimention); i++){
            GameButton fieldButton = new GameButton(i, this);
            gameFieldPanel.add(fieldButton);
            gameButtons[i] = fieldButton;
        }

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    void emptyField(){
        for(int i = 0; i < (dimention)*(dimention); i++){
            gameButtons[i].setText("");

            int x = i / GameBoard.dimention;
            int y = i % GameBoard.dimention;

            gameField[x][y] = nullSymbol;

            if(game.getCurrentPlayer().isRealPlayer())
                game.passTurn();
            game.initGame();
        }
    }

    Game getGame(){
        return game;
    }

    boolean isTurnable(int x, int y){
        return gameField[y][x] == nullSymbol;
    }

    void updateGameField(int x, int y){
        gameField[y][x] = game.getCurrentPlayer().getPlayerSign();
    }

    boolean checkWin(){
        boolean result = false;

        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();
        return checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol);
    }

    private boolean checkWinLines(char playerSymbol){
        boolean cols, rows;
        for(int col = 0; col < dimention; col++){
            cols = true;
            rows = true;

            for(int row = 0; row < dimention; row++){
                cols &= (gameField[col][row] == playerSymbol);
                rows &= (gameField[row][col] == playerSymbol);
            }
            if(cols || rows){
                return true;
            }
        }

        return false;
    }
    private boolean checkWinDiagonals(char playerSymbol){
        boolean cols, rows;
        cols = true;
        rows = true;
        for(int col = 0; col < dimention; col++){

            cols &= (gameField[col][col] == playerSymbol);
            rows &= (gameField[dimention - 1 - col][col] == playerSymbol);
        }
        if(cols || rows){
            return true;
        }
        return false;
    }

    boolean isFull(){
        for(int i = 0; i < dimention*dimention; i++){
            if(gameField[i / dimention][i % dimention] == nullSymbol)
                return false;
        }
        return true;
    }

    public GameButton getButton(int buttonIndex){
        return gameButtons[buttonIndex];
    }

    public char[][] getGameField(){
        return gameField;
    }

}
