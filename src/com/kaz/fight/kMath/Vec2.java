package com.kaz.fight.kMath;
import java.awt.*;
import java.awt.geom.*;

import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

/**
 * Created by kasra on 6/3/2016.
 */
public class Vec2 {
    public double x;
    public double y;
    public static double PI = StrictMath.PI;

    public Vec2() {
        x = 0;
        y = 0;
    }

    public Vec2(double _x, double _y) {
        this.x = _x;
        this.y = _y;
    }

    public Vec2 copy() {
        return new Vec2(this.x, this.y);
    }

    public Vec2 set(double setX, double setY) {
        this.x = setX;
        this.y = setY;
        return this;
    }

    public Vec2 add(Vec2 v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }

    public Vec2 scale(double scalor) {
        this.x *= scalor;
        this.y *= scalor;
        return this;
    }

    public Vec2 rotate(double theta) {
        return affine(new double[][] {
                {cos(theta), -sin(theta)},
                {sin(theta),  cos(theta)}
        });
    }

    public Vec2 affine(double[][] matrix) {
        double tempx = x;
        double tempy = y;
        x = tempx*matrix[0][0] + tempy*matrix[0][1];
        y = tempx*matrix[1][0] + tempy*matrix[1][1];
        return this;
    }

    public Vec2 diff(Vec2 vec) {
        return new Vec2(x - vec.x, y - vec.y);
    }

    public int intx() {
        return (int)this.x;
    }

    public int inty() {
        return (int)this.y;
    }

    public Point point() {
        return new Point(intx(), inty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vec2 vec2 = (Vec2) o;

        if (Double.compare(vec2.x, x) != 0) return false;
        return Double.compare(vec2.y, y) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("< %d, %d>", intx(), inty());
    }
}
