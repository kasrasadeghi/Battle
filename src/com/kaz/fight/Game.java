package com.kaz.fight;

import com.kaz.fight.entities.Player;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kasra on 5/31/2016.
 */
public class Game {
    private List<Player> players;
    private LinkedList<Long> times;
    private Arena arena;

    public Game() {
        arena = new Arena();
        times = new LinkedList<>();
        players = new ArrayList<>();
    }

    public void update(long delta) {
        players.forEach(Player::tick);
        times.push(delta);
        if (times.size() > 10) times.removeLast();
    }

    public void addPlayer(String name) {

    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public double getTime() {
        double average = 0;
        if (times.isEmpty()) return -1;
        try {
            for (long time : times) {
                average += time;
            }
        } catch (NullPointerException | ConcurrentModificationException e) {
            System.err.println("Weird error with linked list.");
        }
        average /= times.size();
        return average;
    }

    public Arena getArena() {
        return arena;
    }
}
