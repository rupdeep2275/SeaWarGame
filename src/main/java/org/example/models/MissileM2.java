package org.example.models;

import org.example.factories.MissileBehaviourFactory;

public class MissileM2 extends Missile {
    public MissileM2() {
        super("M2", 10  , MissileBehaviourFactory.getInstance());
    }
}
