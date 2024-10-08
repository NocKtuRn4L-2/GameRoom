package org.games.ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.ProcessBuilder;

public class StockfishAI {
    private final Process stockfishProcess;
    private final BufferedReader inputReader;
    private final OutputStream outputStream;

    public StockfishAI(String stockfishPath) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(stockfishPath);
        stockfishProcess = processBuilder.start();
        inputReader = new BufferedReader(new InputStreamReader(stockfishProcess.getInputStream()));
        outputStream = stockfishProcess.getOutputStream();
        outputStream.write("uci\n".getBytes());
        outputStream.flush();
        System.out.println("Stockfish started");
        close();
    }

    public void close() throws IOException {
        stockfishProcess.destroy();
    }
}
