package ru.geekbrains.tic_tac_toe2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    Map() {
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Map.this.mouseReleased(e);
            }
        });
    }

    private void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int xCell;
        int yCell;
        int a = getWidth();
        if (x <= a) {
            if (x < a / 3) xCell = 1;
            else if (x < a / 1.5) xCell = 2;
            else xCell = 3;
        } else xCell = 0;
        if (y <= a) {
            if (y < a / 3) yCell = 1;
            else if (y < a / 1.5) yCell = 2;
            else yCell = 3;
        } else yCell = 0;

        System.out.println("x = " + xCell + " y = " + yCell);
    }

    public static void startNewGame() {
        System.out.println("Вызывается метод startNewGame");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.ORANGE);
        int a = getWidth();
        g.drawLine(a / 3, 0, a / 3, a);
        g.drawLine((int) (a / 1.5), 0, (int) (a / 1.5), a);
        g.drawLine(0, a / 3, a, a / 3);
        g.drawLine(0, (int) (a / 1.5), a, (int) (a / 1.5));
    }

}
