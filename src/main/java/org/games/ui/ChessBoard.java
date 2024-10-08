package org.games.ui;

import org.games.logic.GameManager;
import org.games.pieces.*;

import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JPanel {
    private final int SIZE = 8;
    private final int TILE_SIZE = 70;
    private final GameManager gameManager;

    public ChessBoard(GameManager gm) {
        this.gameManager = gm;
        setPreferredSize(new Dimension(SIZE *TILE_SIZE, SIZE *TILE_SIZE));
        setBackground(Color.LIGHT_GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawPieces(g);
    }

    private void drawBoard(Graphics g) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(col*TILE_SIZE, row*TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    private void drawPieces(Graphics g) {
        Piece[][] board = gameManager.getBoard();

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                Piece piece = board[row][col];
                if (piece != null) {
                    if (piece instanceof Pawn) {
                        if (piece.isWhite()) {
                            drawPiece(g, "white_pawn", row, col);
                        } else {
                            drawPiece(g, "black_pawn", row, col);
                        }
                    } else if (piece instanceof Rook) {
                        if (piece.isWhite()) {
                            drawPiece(g, "white_rook", row, col);
                        } else {
                            drawPiece(g, "black_rook", row, col);
                        }
                    } else if (piece instanceof Knight) {
                        if (piece.isWhite()) {
                            drawPiece(g, "white_knight", row, col);
                        } else {
                            drawPiece(g, "black_knight", row, col);
                        }
                    } else if (piece instanceof Bishop) {
                        if (piece.isWhite()) {
                            drawPiece(g, "white_bishop", row, col);
                        } else {
                            drawPiece(g, "black_bishop", row, col);
                        }
                    } else if (piece instanceof Queen) {
                        if (piece.isWhite()) {
                            drawPiece(g, "white_queen", row, col);
                        } else {
                            drawPiece(g, "black_queen", row, col);
                        }
                    } else if (piece instanceof King) {
                        if (piece.isWhite()) {
                            drawPiece(g, "white_king", row, col);
                        } else {
                            drawPiece(g, "black_king", row, col);
                        }
                    }
                }
            }
        }
    }
    private void drawPiece(Graphics g, String pieceName, int row, int col) {
        Image pieceImage = loadPieceImage(pieceName);
        if (pieceImage != null) {
            g.drawImage(pieceImage, col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE, this);
        }
    }

    private Image loadPieceImage(String pieceName) {
        try {
            // Replace this with the actual path to your images
            String imagePath = "src/main/resources/images/" + pieceName + ".png";
            return new ImageIcon(imagePath).getImage();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
