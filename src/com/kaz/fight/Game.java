package com.kaz.fight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kasra on 5/31/2016.
 */
public class Game {
    private List<Player> players;
    private List<Long> times;
    private Arena arena;

    public Game() {
        arena = new Arena();
        times = new ArrayList<>();
        players = new ArrayList<>();
    }

    public void update(long delta) {
        players.forEach(Player::tick);
        times.add(delta);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public double getTime() {
        double average = 0;
        for (int i = 0; i < times.size(); ++i)
            average += times.get(i);
        average /= (double)times.size();
        return average;
    }

    public Arena getArena() {
        return arena;
    }
}
