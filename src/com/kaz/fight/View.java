package com.kaz.fight;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kasra on 5/31/2016.
 */
public class View extends JPanel{
    private Game game;
    public View(Dimension size, Game game) {
        setPreferredSize(size);
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        Double time = game.getTime();
        g.setColor(Color.YELLOW);
        g.drawString(time + "", 50, 50);

        //paint arena

        Arena arena = game.getArena();
        Grid grid = arena.getGrid();
        int scale = Fight.scale;

        for (int i = 0; i < Fight.height; ++i) {
            for (int j = 0; j < Fight.width; ++j) {
                g.setColor(grid.get(j, i).getColor());
                g.fillRect(j * scale, i * scale, scale, scale);
            }
        }
    }

    public void render() {
        repaint();
    }
}
