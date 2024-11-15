package org.example.models;

import org.example.strategies.M3Behaviour;

public class MissileM3 extends Missile {
    public MissileM3() {
        super("Missile M3", 15, new M3Behaviour());
    }
}
