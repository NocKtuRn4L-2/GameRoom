package org.games.ui;

import org.games.logic.GameManager;

import javax.swing.*;

public class GameWindow extends JFrame {

    public GameWindow(GameManager gm) {
        setTitle("2D Chess Game");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChessBoard chessBoard = new ChessBoard(gm);
        add(chessBoard);
    }
}
