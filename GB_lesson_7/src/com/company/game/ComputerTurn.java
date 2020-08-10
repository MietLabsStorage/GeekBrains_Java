package com.company.game;

public abstract class ComputerTurn {
    static int SIZE = GameBoard.dimention;
    static char DOT_X = 'X';
    static char DOT_O = 'O';
    static char DOT_EMPTY = '\u0000';
    static char[][] map;
    public static int[] run(GameBoard gameBoard) {
        int x = -1;
        int y = -1;

        map = gameBoard.getGameField();

        int[] cellPoints = new int[SIZE * SIZE];
        for (int k = 0; k < SIZE * SIZE; k++) {
            int i = k % SIZE;
            int j = k / SIZE;
            if (gameBoard.isTurnable(j, i)) {
                if (isXX_(i, j)) {
                    cellPoints[k] = 100;
                } else if (isOO_(i, j)) {
                    cellPoints[k] = 50;
                } else if (isO__(i, j)) {
                    cellPoints[k] = 25;
                } else if (isX__(i, j)) {
                    cellPoints[k] = 15;
                } else if (isXO_(i, j)) {
                    cellPoints[k] = 10;
                } else if (is___(i, j)) {
                    cellPoints[k] = 5;
                }
            }
        }
        x = 0;
        y = 0;
        int bestWay = cellPoints[0];
        for (int i = 0; i < SIZE * SIZE; i++) {
            if (cellPoints[i] > bestWay) {
                bestWay = cellPoints[i];
                x = i % SIZE;
                y = i / SIZE;
            }

        }
        System.out.println(cellPoints[y* 3 +x]);
        return new int[]{x,y};
    }

    private static boolean isXX_(int x, int y){
        //horizontal
        int XX_ = 0;
        for(int k = 0; k < SIZE; k++){
            if(map[k][y] == DOT_X){
                XX_ += 10;
            }
            else if (map[k][y] == DOT_EMPTY){
                XX_ += 1;
            }
        }
        if(XX_ == 10 + 10 + 1){
            return true;
        }

        //vertical
        XX_ = 0;
        for(int k = 0; k < SIZE; k++){
            if(map[x][k] == DOT_X){
                XX_ += 10;
            }
            else if (map[x][k] == DOT_EMPTY){
                XX_ += 1;
            }
        }
        if(XX_ == 10 + 10 + 1){
            return true;
        }

        //diagonal
        if(x == y){
            XX_ = 0;
            for(int k = 0; k < SIZE; k++){
                if(map[k][k] == DOT_X){
                    XX_ += 10;
                }
                else if (map[k][k] == DOT_EMPTY){
                    XX_ += 1;
                }
            }
            if(XX_ == 10 + 10 + 1){
                return true;
            }
        }

        //second diagonal
        if(x == SIZE - 1 - y){
            XX_ = 0;
            for(int k = 0; k < SIZE; k++){
                if(map[k][SIZE - 1 - k] == DOT_X){
                    XX_ += 10;
                }
                else if (map[k][SIZE - 1 - k] == DOT_EMPTY){
                    XX_ += 1;
                }
            }
            if(XX_ == 10 + 10 + 1){
                return true;
            }
        }

        return false;
    }

    private static boolean isOO_(int x, int y){
        //horizontal
        int XX_ = 0;
        for(int k = 0; k < SIZE; k++){
            if(map[k][y] == DOT_O){
                XX_ += 10;
            }
            else if (map[k][y] == DOT_EMPTY){
                XX_ += 1;
            }
        }
        if(XX_ == 10 + 10 + 1){
            return true;
        }

        //vertical
        XX_ = 0;
        for(int k = 0; k < SIZE; k++){
            if(map[x][k] == DOT_O){
                XX_ += 10;
            }
            else if (map[x][k] == DOT_EMPTY){
                XX_ += 1;
            }
        }
        if(XX_ == 10 + 10 + 1){
            return true;
        }

        //diagonal
        if(x == y){
            XX_ = 0;
            for(int k = 0; k < SIZE; k++){
                if(map[k][k] == DOT_O){
                    XX_ += 10;
                }
                else if (map[k][k] == DOT_EMPTY){
                    XX_ += 1;
                }
            }
            if(XX_ == 10 + 10 + 1){
                return true;
            }
        }

        //second diagonal
        if(x == SIZE - 1 - y){
            XX_ = 0;
            for(int k = 0; k < SIZE; k++){
                if(map[k][SIZE - 1 - k] == DOT_O){
                    XX_ += 10;
                }
                else if (map[k][SIZE - 1 - k] == DOT_EMPTY){
                    XX_ += 1;
                }
            }
            if(XX_ == 10 + 10 + 1){
                return true;
            }
        }

        return false;
    }

    private static boolean isO__(int x, int y){
        //horizontal
        int XX_ = 0;
        for(int k = 0; k < SIZE; k++){
            if(map[k][y] == DOT_O){
                XX_ += 10;
            }
            else if (map[k][y] == DOT_EMPTY){
                XX_ += 1;
            }
        }
        if(XX_ == 10 + 1 + 1){
            return true;
        }

        //vertical
        XX_ = 0;
        for(int k = 0; k < SIZE; k++){
            if(map[x][k] == DOT_O){
                XX_ += 10;
            }
            else if (map[x][k] == DOT_EMPTY){
                XX_ += 1;
            }
        }
        if(XX_ == 10 + 1 + 1){
            return true;
        }

        //diagonal
        if(x == y){
            XX_ = 0;
            for(int k = 0; k < SIZE; k++){
                if(map[k][k] == DOT_O){
                    XX_ += 10;
                }
                else if (map[k][k] == DOT_EMPTY){
                    XX_ += 1;
                }
            }
            if(XX_ == 10 + 1 + 1){
                return true;
            }
        }

        //second diagonal
        if(x == SIZE - 1 - y){
            XX_ = 0;
            for(int k = 0; k < SIZE; k++){
                if(map[k][SIZE - 1 - k] == DOT_O){
                    XX_ += 10;
                }
                else if (map[k][SIZE - 1 - k] == DOT_EMPTY){
                    XX_ += 1;
                }
            }
            if(XX_ == 10 + 1 + 1){
                return true;
            }
        }

        return false;
    }

    private static boolean isX__(int x, int y){
        //horizontal
        int XX_ = 0;
        for(int k = 0; k < SIZE; k++){
            if(map[k][y] == DOT_X){
                XX_ += 10;
            }
            else if (map[k][y] == DOT_EMPTY){
                XX_ += 1;
            }
        }
        if(XX_ == 10 + 1 + 1){
            return true;
        }

        //vertical
        XX_ = 0;
        for(int k = 0; k < SIZE; k++){
            if(map[x][k] == DOT_X){
                XX_ += 10;
            }
            else if (map[x][k] == DOT_EMPTY){
                XX_ += 1;
            }
        }
        if(XX_ == 10 + 1 + 1){
            return true;
        }

        //diagonal
        if(x == y){
            XX_ = 0;
            for(int k = 0; k < SIZE; k++){
                if(map[k][k] == DOT_X){
                    XX_ += 10;
                }
                else if (map[k][k] == DOT_EMPTY){
                    XX_ += 1;
                }
            }
            if(XX_ == 10 + 1 + 1){
                return true;
            }
        }

        //second diagonal
        if(x == SIZE - 1 - y){
            XX_ = 0;
            for(int k = 0; k < SIZE; k++){
                if(map[k][SIZE - 1 - k] == DOT_X){
                    XX_ += 10;
                }
                else if (map[k][SIZE - 1 - k] == DOT_EMPTY){
                    XX_ += 1;
                }
            }
            if(XX_ == 10 + 1 + 1){
                return true;
            }
        }

        return false;
    }

    private static boolean isXO_(int x, int y){
        //horizontal
        int XX_ = 0;
        for(int k = 0; k < SIZE; k++){
            if(map[k][y] == DOT_X){
                XX_ += 10;
            }
            else if (map[k][y] == DOT_O){
                XX_ += 1;
            }
        }
        if(XX_ == 10 + 1){
            return true;
        }

        //vertical
        XX_ = 0;
        for(int k = 0; k < SIZE; k++){
            if(map[x][k] == DOT_X){
                XX_ += 10;
            }
            else if (map[x][k] == DOT_O){
                XX_ += 1;
            }
        }
        if(XX_ == 10 + 1){
            return true;
        }

        //diagonal
        if(x == y){
            XX_ = 0;
            for(int k = 0; k < SIZE; k++){
                if(map[k][k] == DOT_X){
                    XX_ += 10;
                }
                else if (map[k][k] == DOT_O){
                    XX_ += 1;
                }
            }
            if(XX_ == 10 + 1){
                return true;
            }
        }

        //second diagonal
        if(x == SIZE - 1 - y){
            XX_ = 0;
            for(int k = 0; k < SIZE; k++){
                if(map[k][SIZE - 1 - k] == DOT_X){
                    XX_ += 10;
                }
                else if (map[k][SIZE - 1 - k] == DOT_O){
                    XX_ += 1;
                }
            }
            if(XX_ == 10 + 1){
                return true;
            }
        }

        return false;
    }

    private static boolean is___(int x, int y){
        //horizontal
        int XX_ = 0;
        for(int k = 0; k < SIZE; k++){
            if(map[k][y] == DOT_X){
                XX_ += 10;
            }
            else if (map[k][y] == DOT_O){
                XX_ += 1;
            }
        }
        if(XX_ == 0){
            return true;
        }

        //vertical
        XX_ = 0;
        for(int k = 0; k < SIZE; k++){
            if(map[x][k] == DOT_X){
                XX_ += 10;
            }
            else if (map[x][k] == DOT_O){
                XX_ += 1;
            }
        }
        if(XX_ == 0){
            return true;
        }

        //diagonal
        if(x == y){
            XX_ = 0;
            for(int k = 0; k < SIZE; k++){
                if(map[k][k] == DOT_X){
                    XX_ += 10;
                }
                else if (map[k][k] == DOT_O){
                    XX_ += 1;
                }
            }
            if(XX_ == 0){
                return true;
            }
        }

        //second diagonal
        if(x == SIZE - 1 - y){
            XX_ = 0;
            for(int k = 0; k < SIZE; k++){
                if(map[k][SIZE - 1 - k] == DOT_X){
                    XX_ += 10;
                }
                else if (map[k][SIZE - 1 - k] == DOT_O){
                    XX_ += 1;
                }
            }
            if(XX_ == 0){
                return true;
            }
        }

        return false;
    }
}
