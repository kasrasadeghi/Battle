package com.kaz.fight;

import com.kaz.fight.kMath.Force;
import com.kaz.fight.kMath.Vec2;

import java.util.ArrayList;

/**
 * Created by kasra on 6/3/2016.
 */
public class Entity {
    protected Vec2 position;
    protected double mass;

    public Entity() {
        this(new Vec2(), 10);
    }

    public Entity(Vec2 pos, double mass) {
        this.position = pos;//maybe make copy constructor?
        this.mass = mass;
    }


    public void tick() {
        //TODO: holy animation batman
    }
}
