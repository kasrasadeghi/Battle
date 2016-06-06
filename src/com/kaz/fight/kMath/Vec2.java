package com.kaz.fight.kMath;

/**
 * Created by kasra on 6/3/2016.
 */
public class Vec2 {
    protected double X;
    protected double Y;

    public Vec2() {
        X = 0;
        Y = 0;
    }

    public Vec2(double inX, double inY) {
        this.X = inX;
        this.Y = inY;
    }

    public void set(double setX, double setY) {
        this.X = setX;
        this.Y = setY;
    }

    public Vec2 add(Vec2 v) {
        this.X += v.X;
        this.Y += v.Y;
        return this;
    }

    public Vec2 scale(double scalor) {
        this.X *= scalor;
        this.Y *= scalor;
        return this;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vec2 vec2 = (Vec2) o;

        if (Double.compare(vec2.X, X) != 0) return false;
        return Double.compare(vec2.Y, Y) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(X);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(Y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
