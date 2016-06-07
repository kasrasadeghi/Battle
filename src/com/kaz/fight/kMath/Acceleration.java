package com.kaz.fight.kMath;

/**
 * Created by kasra on 6/3/2016.
 */
public class Acceleration extends Vec2 {
    public static Acceleration GRAVITY = new Acceleration(0, -10);

    public Acceleration(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
