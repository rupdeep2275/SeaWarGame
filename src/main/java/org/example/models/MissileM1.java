package org.example.models;

import org.example.strategies.M1Behaviour;

public class MissileM1 extends Missile {
    public MissileM1() {
        super("Missile M1", 20, new M1Behaviour());
    }
}
