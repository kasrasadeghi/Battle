package com.kaz.fight;

import com.kaz.fight.kMath.Vec2;
import com.kaz.fight.kMath.Velocity;

/**
 * Created by kasra on 6/3/2016.
 */
public class Projectile extends Actor {

    public Projectile(Vec2 pos, double mass, Velocity v) {
        super(pos, mass, v);
    }
}
