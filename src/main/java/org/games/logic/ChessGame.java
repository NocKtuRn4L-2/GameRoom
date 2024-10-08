package org.games.logic;

import org.games.ui.GameWindow;

import java.io.IOException;

public class ChessGame {
    public static void main(String[] args) {
        String stockfishPath = "\"D:\\Programming\\Projects\\3296_Software_Design\\stockfish\\stockfish-windows-x86-64-avx2.exe\"";
        GameManager gameManager;
        try {
            gameManager = new GameManager(stockfishPath);
            GameWindow gameWindow = new GameWindow(gameManager);
            gameWindow.setVisible(true);

            // Move a white pawn from (1, 0) to (3, 0) (2 squares forward, initial move)
            boolean moved = gameManager.movePiece(1, 0, 3, 0);
            System.out.println("\nMove white pawn from (1, 0) to (3, 0): " + moved);
            gameManager.printBoard();

            // Try moving a black pawn from (6, 0) to (5, 0) (1 square forward)
            moved = gameManager.movePiece(6, 0, 5, 0);
            System.out.println("\nMove black pawn from (6, 0) to (5, 0): " + moved);
            gameManager.printBoard();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}