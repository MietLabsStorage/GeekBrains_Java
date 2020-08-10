package com.company.game;

import javax.swing.*;

public class GameButton extends JButton {
    private int buttonIndex;
    private  GameBoard board;

    public GameButton(int gameButtonIndex, GameBoard currentGameBoard){
        buttonIndex = gameButtonIndex;
        board = currentGameBoard;

        int rowNum = buttonIndex / GameBoard.dimention;
        int cellNum = buttonIndex % GameBoard.dimention;

        setSize(GameBoard.cellSize = 5, GameBoard.cellSize = 5);
        addActionListener(new GameActionListener(rowNum, cellNum, this));
    }

    public  GameBoard getBoard() {return  board;}

}
