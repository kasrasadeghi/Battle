package com.kaz.fight;

import javax.swing.*;
import java.awt.*;

public class Fight {

    public static int
            width = 160,
            height = 90,
            scale = 8;

    private Game game;
    private Control control;
    private View view;
    private JFrame frame;
    private Thread gameThread;

    private boolean looping = false;

    public Fight() {
        (
            gameThread = new Thread(() -> {
            game = new Game();

            Dimension size = new Dimension(width * scale, height * scale);
            view = new View(size, game);

            control = new Control(game, view);

            frame = new JFrame() {{
                setResizable(false);
                setTitle("Fight");
                add(view);
                pack();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
                setVisible(true);
            }};

            gameLoop();
        })
        ).start();
    }

    private void gameLoop() {
        //TODO: redesign game loop

        looping = true;
        long lastTime = System.currentTimeMillis();
        while (looping) {
            long delta = System.currentTimeMillis() - lastTime;
            if (delta >= 1000/60d) {
                view.render();
                game.update(delta);
                lastTime = System.currentTimeMillis();
            }
        }
    }

    public synchronized void end() {
        looping = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Fight();
    }
}