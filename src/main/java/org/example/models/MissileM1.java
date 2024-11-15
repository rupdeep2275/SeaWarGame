package org.example.models;

import org.example.factories.MissileBehaviourFactory;

public class MissileM1 extends Missile {
    public MissileM1() {
        super("M1", 20, MissileBehaviourFactory.getInstance());
    }
}
