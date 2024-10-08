package org.games.logic;

import org.games.ui.GameWindow;

public class ChessGame {
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.setVisible(true);

        GameManager gameManager = new GameManager();

        // Move a white pawn from (1, 0) to (3, 0) (2 squares forward, initial move)
        boolean moved = gameManager.movePiece(1, 0, 3, 0);
        System.out.println("\nMove white pawn from (1, 0) to (3, 0): " + moved);
        gameManager.printBoard();

        // Try moving a black pawn from (6, 0) to (5, 0) (1 square forward)
        moved = gameManager.movePiece(6, 0, 5, 0);
        System.out.println("\nMove black pawn from (6, 0) to (5, 0): " + moved);
        gameManager.printBoard();
    }
}