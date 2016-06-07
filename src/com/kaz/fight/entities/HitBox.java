package com.kaz.fight.entities;

import com.kaz.fight.kMath.Vec2;
import com.kaz.fight.kMath.dRect;

/**
 * Created by kasra on 6/4/2016.
 */
public class HitBox extends dRect {
    public HitBox(Vec2 pos) {
        super(pos.x, pos.y, 5, 10);
    }
}
