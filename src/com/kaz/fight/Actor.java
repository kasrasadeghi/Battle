package com.kaz.fight;

import com.kaz.fight.kMath.Force;
import com.kaz.fight.kMath.Vec2;
import com.kaz.fight.kMath.Velocity;

import java.util.List;

/**
 * Created by kasra on 6/3/2016.
 */
public class Actor extends Entity {
    private HitBox hitBox;
    protected Velocity velocity;
    protected List<Force> forces;

    public Actor(Vec2 pos, double mass, Velocity v) {
        super(pos, mass);
        this.velocity = v;
        this.hitBox = new HitBox();
    }

    public void apply(Force f) {
        forces.add(f);
    }

    public void tick() {
        super.tick();
        //TODO: holy physics batman
    }
}
