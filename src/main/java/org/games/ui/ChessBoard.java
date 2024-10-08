package org.games.ui;

import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JPanel {
    private final int Size = 8;
    private final int TILE_SIZE = 70;

    public ChessBoard() {
        setPreferredSize(new Dimension(Size*TILE_SIZE, Size*TILE_SIZE));
        setBackground(Color.LIGHT_GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
    }

    private void drawBoard(Graphics g) {
        for (int row = 0; row < Size; row++) {
            for (int col = 0; col < Size; col++) {
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(col*TILE_SIZE, row*TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}
