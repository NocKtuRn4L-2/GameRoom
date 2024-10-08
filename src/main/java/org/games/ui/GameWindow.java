package org.games.ui;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow() {
        setTitle("2D Chess Game");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChessBoard chessBoard = new ChessBoard();
        add(chessBoard);
    }
}
