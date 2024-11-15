package org.example.models;

import org.example.factories.MissileBehaviourFactory;

public class MissileM3 extends Missile {
    public MissileM3() {
        super("M3", 15, MissileBehaviourFactory.getInstance());
    }
}
