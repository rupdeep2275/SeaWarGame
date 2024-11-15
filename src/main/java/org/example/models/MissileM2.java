package org.example.models;

import org.example.strategies.M2Behaviour;

public class MissileM2 extends Missile {
    public MissileM2() {
        super("Missile M2", 10, new M2Behaviour());
    }
}
