package com.kaz.fight;

import java.awt.*;

/**
 * Created by kasra on 6/2/2016.
 */
public class Grid {
    private GridBlock[][] gridBlockGrid;

    public Grid() {
        gridBlockGrid = new GridBlock[Fight.width][Fight.height];
        for (int i = 0; i < Fight.width; ++i)
            for (int j = 0; j < Fight.height; ++j) {
                if (i == 0 || j == 0 || i == Fight.width - 1 || j == Fight.height - 1)
                    gridBlockGrid[i][j] = GridBlock.SOLID;
                else gridBlockGrid[i][j] = GridBlock.AIR;
            }
    }

    public GridBlock get(int i, int j) {
        return gridBlockGrid[i][j];
    }

    public void set(int i, int j, GridBlock gb) {
        gridBlockGrid[i][j] = gb;
    }

    public int width() {
        return Fight.width;
    }

    public int height() {
        return Fight.height;
    }


    /**
     * GridBlock of which the Grid is composed of.
     *
     * There are many types of GridBlock:
     *      SOLID GridBlocks are not passable in any direction.
     *      AIR GridBlocks are passable in every direction.
     *      HOLD GridBlocks are only solid on top.
     */
    enum GridBlock {
        AIR(true, true, true, true),
        SOLID(false, false, false, false),
        HOLD(false, true, false, false);

        private boolean right, top, left, bottom;

        GridBlock(boolean r, boolean t, boolean l, boolean b) {
            this.right = r;
            this.top = t;
            this.left = l;
            this.bottom = b;
        }

        public boolean canRight() {
            return right;
        }
        public boolean canLeft() {
            return left;
        }
        public boolean canTop() {
            return top;
        }
        public boolean canBottom() {
            return bottom;
        }

        public Color getColor() {
            switch(this) {
                case SOLID:
                    return Color.GRAY;
                case AIR:
                    return new Color(163, 250, 255);
                case HOLD:
                    return new Color(139, 69, 19);
                default: return Color.RED;
            }
        }
    }
}
