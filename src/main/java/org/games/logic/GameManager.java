package org.games.logic;

import org.games.pieces.Pawn;
import org.games.pieces.Piece;

public class GameManager {
    private boolean isWhiteTurn = true;
    private final Piece[][] board;

    public GameManager() {
        board = new Piece[8][8];
        setupPieces();
        printBoard();
    }

    private void setupPieces() {
        // Place white pawns on the second row (index 1)
        for (int col = 0; col < 8; col++) {
            board[1][col] = new Pawn(true); // White pawns
        }

        // Place black pawns on the seventh row (index 6)
        for (int col = 0; col < 8; col++) {
            board[6][col] = new Pawn(false); // Black pawns
        }
    }

    public boolean movePiece(int startX, int startY, int endX, int endY) {
        Piece piece = board[startX][startY];
        // Ensure the right piece color is moving according to the turn
        if (piece != null && piece.isValidMove(startX, startY, endX, endY, board)) {
            board[endX][endY] = piece;
            board[startX][startY] = null;
            isWhiteTurn = !isWhiteTurn;
            return true;
        }
        return false;
    }

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }

    public void printBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] != null) {
                    if (board[row][col] instanceof Pawn) {
                        System.out.print(board[row][col].isWhite() ? "P " : "p " );
                    }
                }else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
