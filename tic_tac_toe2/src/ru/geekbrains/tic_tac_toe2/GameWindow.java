package ru.geekbrains.tic_tac_toe2;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame implements ActionListener {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameWindow();
            }
        });
    }


    private final JButton btnExit = new JButton("Exit");
    private final JButton btnNewGame = new JButton("New Game");

    private GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 550);
        setLocationRelativeTo(null);
        setTitle("Крестики-нолики");

        btnNewGame.addActionListener(this);
        btnExit.addActionListener(this);

        JPanel bottomPanel = new JPanel(new GridLayout());
        bottomPanel.add(btnNewGame);
        bottomPanel.add(btnExit);
        add(bottomPanel, BorderLayout.SOUTH);

        Map map = new Map();
        add(map, BorderLayout.CENTER);

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == btnNewGame) {
            System.out.println("Нажали New Game");
            Map.startNewGame();
        } else if (src == btnExit) {
            System.out.println("Нажали Exit");
            System.exit(0);
        }
    }
}
