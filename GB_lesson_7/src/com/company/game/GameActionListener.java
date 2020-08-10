package com.company.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;

    public GameActionListener(int row, int cell, GameButton gButton){
        this.row = row;
        this.cell = cell;
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();
        if(board.isTurnable(row, cell)){
            updateByPlayersData(board);

            if(board.isFull()){
                board.getGame().showMessage("No winners");
                board.emptyField();
            }
            else{
                updateByAiData(board);
            }
        }
        else{
            board.getGame().showMessage("Incorrect step");
        }
    }

    private void updateByAiData(GameBoard board) {
        int x,y;
        Random rnd = new Random();
//        do{
//            x = rnd.nextInt(GameBoard.dimention);
//            y = rnd.nextInt(GameBoard.dimention);
//        }
//        while (!board.isTurnable(x,y));
        int[] xy = ComputerTurn.run(board);
        x= xy[1]; y = xy[0];

        board.updateGameField(x,y);
        int cellIndex = GameBoard.dimention * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if(board.checkWin()){
            button.getBoard().getGame().showMessage("Computer win");
            board.emptyField();
        }
        else{
            board.getGame().passTurn();
        }
    }

    private void updateByPlayersData(GameBoard board) {
        board.updateGameField(row,cell);
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if(board.checkWin()){
            button.getBoard().getGame().showMessage("You win");
            board.emptyField();
        }
        else{
            board.getGame().passTurn();
        }
    }
}
