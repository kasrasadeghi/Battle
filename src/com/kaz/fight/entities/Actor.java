package com.kaz.fight.entities;

import com.kaz.fight.Entity;
import com.kaz.fight.kMath.Force;
import com.kaz.fight.kMath.Vec2;
import com.kaz.fight.kMath.Velocity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kasra on 6/3/2016.
 */
public class Actor extends Entity {

    private HitBox hitBox;
    protected List<Force> forces;

    protected double mass;

    public Actor(Vec2 pos, Velocity v, double mass) {
        super(pos, v, mass);
        this.hitBox = new HitBox(pos);
        this.forces = new ArrayList<>();
    }

    public void apply(Force f) {
        forces.add(f);
    }

    public void tick() {
        super.tick();
        //TODO: holy physics batman
    }
}
