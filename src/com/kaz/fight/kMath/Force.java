package com.kaz.fight.kMath;

/**
 * Created by kasra on 6/3/2016.
 */
public class Force extends Vec2 {
    public static final int UNENDING = -1;

    protected int duration;

    public Force() {
        super();
        duration = UNENDING;
    }

    public Force(double X, double Y) {
        super(X, Y);
        duration = UNENDING;
    }

    public void tick() {
        if (duration == UNENDING) {

        } else {

        }
    }
}
