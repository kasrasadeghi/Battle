package com.kaz.fight.kMath;

/**
 * Created by kasra on 6/5/2016.
 */
public class dRect {
    public Vec2 p1, p2, p3, p4;

    public dRect(Vec2 p1, Vec2 p2, Vec2 p3, Vec2 p4) {
        this.p1 = p1.copy();
        this.p2 = p2.copy();
        this.p3 = p3.copy();
        this.p4 = p4.copy();
    }

    public dRect(double tlx, double tly, double width, double height) {
        this(tlx, tly, width, height, 0);
    }

    public dRect(double tlx, double tly, double width, double height, double angle) {
        p1 = new Vec2(tlx, tly);
        p2 = new Vec2(tlx + width, tly);
        p3 = new Vec2(tlx + width, tly + height);
        p4 = new Vec2(tlx, tly + height);
        rotate(angle);
    }

    public dRect rotate(double angle) {
        if (angle == 0) return this;
//        Vec2 o = new Vec2();
//        Vec2 diff = o.diff(p1);
//        translate(diff);
        p1.rotate(angle);
        p2.rotate(angle);
        p3.rotate(angle);
        p4.rotate(angle);
//        translate(diff.scale(-1));
        return this;
    }

    public dRect translate(Vec2 v) {
        p1.add(v);
        p2.add(v);
        p3.add(v);
        p4.add(v);
        return this;
    }

    public dRect copy() {
        return new dRect(p1, p2, p3, p4);
    }

    @Override
    public String toString() {
        return "dRect{ p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + " }";
    }
}
