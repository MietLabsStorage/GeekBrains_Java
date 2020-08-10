package com.company;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final int SIZE = 3;
    private static char[][] map;

    private static final char DOT_EMPTY = '*';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static final boolean SILLY_MODE = false;

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            if (isEndGame(DOT_X)) {
                break;
            }
            computerTurn();
            if (isEndGame(DOT_O)) {
                break;
            }
        }
        System.out.println("Endgame");
    }

    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE*SIZE; i++)
                map[i % SIZE][i / SIZE] = DOT_EMPTY;
    }

    private static void printMap() {
//        for(int i = 0; i < SIZE; i++)
//            System.out.print(i+" ");
//        System.out.println();
//
//        for(int i = 0; i < SIZE; i++){
//            System.out.print((i+1)+" ");
//            for(int j = 0; j < SIZE; j++)
//                System.out.print(map[i][j]+" ");
//            System.out.println();
//        }

        //the best way that I invent
        //so was O(n^2 + n), but now O(2n^2) that some better
        //thus it's optimized :)
        for (int i = -1; i < SIZE; i++) {
            if (i == -1) {
                for (int j = 0; j <= SIZE; j++)
                    System.out.print(j + " ");
            } else {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < SIZE; j++)
                    System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Write coordinates");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;
    }

    private static void computerTurn(){
        int x = -1;
        int y = -1;
        if(SILLY_MODE){
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            }while (!isCellValid(x,y));
        }
        else{
            int[] cellPoints = new int[SIZE*SIZE];
            for (int k = 0; k < SIZE*SIZE; k++) {
                int i = k % SIZE;
                int j = k / SIZE;
                if(isCellValid(i, j)){
                    if(isXX_(i, j)){
                        cellPoints[k] = 100;
                    }
                    else if(isOO_(i, j)){
                        cellPoints[k] = 50;
                    }
                    else if(isO__(i, j)){
                        cellPoints[k] = 25;
                    }
                    else if(isX__(i, j)){
                        cellPoints[k] = 15;
                    }
                    else if(isXO_(i, j)){
                        cellPoints[k] = 10;
                    }
                    else if(is___(i, j)){
                        cellPoints[k] = 5;
                    }
                }
            }
            x = 0;
            y = 0;
            int bestWay = cellPoints[0];
            for (int i = 0; i < SIZE*SIZE; i++){
                if(cellPoints[i] > bestWay){
                    bestWay = cellPoints[i];
                    x = i % SIZE;
                    y = i / SIZE;
                }
            }
        }

        map[x][y] = DOT_O;
        System.out.println("Computer choose cell (" + (x+1) + ";" + (y+1) + ")");
    }

    private static boolean isEndGame(char playerSymbol) {
        boolean result = false;

        printMap();

        if (checkWin(playerSymbol)) {
            System.out.println(playerSymbol + " are winner");
            result = true;
        } else if (isMapFull()) {
            System.out.println("Noone's win");
            result = true;
        }

        return result;
    }

    private static boolean isCellValid(int x, int y) {
        boolean result = false;
        result = (x >= 0 || x < SIZE || y >= 0 || y < SIZE);
        if (result)
            result = map[x][y] == DOT_EMPTY;
        return result;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char playerSymbol) {
        //i don't know how it can optimized
        //if I would know but i don't know
        //p.s. if you know say pls
        return (map[0][0] == playerSymbol && map[0][1] == playerSymbol && map[0][2] == playerSymbol) ||
                (map[1][0] == playerSymbol && map[1][1] == playerSymbol && map[1][2] == playerSymbol) ||
                (map[2][0] == playerSymbol && map[2][1] == playerSymbol && map[2][2] == playerSymbol) ||
                (map[0][0] == playerSymbol && map[1][0] == playerSymbol && map[2][0] == playerSymbol) ||
                (map[0][1] == playerSymbol && map[1][1] == playerSymbol && map[2][1] == playerSymbol) ||
                (map[0][2] == playerSymbol && map[1][2] == playerSymbol && map[2][2] == playerSymbol) ||
                (map[0][0] == playerSymbol && map[1][1] == playerSymbol && map[2][2] == playerSymbol) ||
                (map[0][2] == playerSymbol && map[1][1] == playerSymbol && map[2][0] == playerSymbol);
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
