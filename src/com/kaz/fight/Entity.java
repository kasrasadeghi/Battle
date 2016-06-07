package com.kaz.fight;
import com.kaz.fight.kMath.Force;
import com.kaz.fight.kMath.Vec2;
import com.kaz.fight.kMath.Velocity;

import java.util.List;

/**
 * Created by kasra on 6/3/2016.
 *
 * Entities have a position, a mass, and they can interact with gravity.
 *
 * //TODO: animation
 * //TODO: interaction with gravity
 */
public class Entity {
    protected Vec2 pos;
    protected Velocity velocity;

    public Entity(Vec2 pos, Velocity v, double mass) {
        this.pos = pos.copy();
        this.velocity = v;
    }

    public void tick() {
        //TODO: holy animation batman
    }
}
