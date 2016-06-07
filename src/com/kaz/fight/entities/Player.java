package com.kaz.fight.entities;

import com.kaz.fight.entities.Actor;
import com.kaz.fight.kMath.Vec2;
import com.kaz.fight.kMath.Velocity;

/**
 * Created by kasra on 5/31/2016.
 */
public class Player extends Actor {

    public Player(Vec2 pos) {
        super(pos, new Velocity(), 10);
    }

    public void jump() {

    }

}
