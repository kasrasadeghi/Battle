package com.kaz.fight;

import com.kaz.fight.kMath.Acceleration;
import com.kaz.fight.Grid.GridBlock;
import com.kaz.fight.kMath.Vec2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kasra on 6/2/2016.
 */
public class Arena {
    private Grid grid;
    private Acceleration gravity;
    private List<Platform> platforms;
    public Arena() {
        //maybe the Arena doesn't even have a grid behind it? maybe it just has objects made of materials, and then the View draws every object.
        //      this would be slower, but also more versatile.
        //      this would allow us to put entities into the world more easily. so there would be some kind of Entity::put
        this.gravity = Acceleration.GRAVITY;
        this.grid = new Grid();
        this.platforms = new ArrayList<>();
        generatePlatforms();
    }

    private void generatePlatforms() {
        for (int x = 10; x < grid.width(); x += 40) {
            for (int y = 15; y < grid.height(); y += 20) {
                try {
                    platforms.add(new Platform(x, y));
                } catch (IndexOutOfBoundsException ignored) {}
            }
        }
    }

    public Grid getGrid() {
        return grid;
    }

    private class Platform {
        int x, y;
        int width;
        int height;
        GridBlock block;

        public Platform(int x, int y) throws IndexOutOfBoundsException {
            this(x, y, 20, 2, GridBlock.SOLID);
        }

        public Platform(int x, int y, int width, int height, GridBlock block) throws IndexOutOfBoundsException{
            if (x < 0 || y < 0 || x + width > grid.width() || y + height > grid.height()) throw new IndexOutOfBoundsException("Platform does not fit");
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.block = block;

            placePlatform();
        }

        private void placePlatform() {
            for (int i = x; i < x + width; ++i)
                for (int j = y; j < y + height; ++j)
                    grid.set(i, j, block);
        }
    }
}
