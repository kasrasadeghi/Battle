package com.kaz.fight;

import com.kaz.fight.kMath.Acceleration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kasra on 6/2/2016.
 */
public class Arena {
    private Acceleration gravity;
    List<Entity> entities;

    public Arena() {
        gravity = Acceleration.GRAVITY;
        entities = new ArrayList<>();
    }




}
