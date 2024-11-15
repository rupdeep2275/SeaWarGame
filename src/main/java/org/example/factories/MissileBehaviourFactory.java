package org.example.factories;

import org.example.strategies.M1Behaviour;
import org.example.strategies.M2Behaviour;
import org.example.strategies.M3Behaviour;
import org.example.strategies.MissileBehavior;

public class MissileBehaviourFactory {
    private MissileBehaviourFactory() {
    }

    private static class LazyHolder {
        private static final MissileBehaviourFactory INSTANCE = new MissileBehaviourFactory();
    }

    public static MissileBehaviourFactory getInstance() {
        return LazyHolder.INSTANCE;
    }
    public MissileBehavior createMissileBehaviour(String type) {
        switch (type) {
            case "M1":
                return new M1Behaviour();
            case "M2":
                return new M2Behaviour();
            case "M3":
                return new M3Behaviour();
            default:
                throw new IllegalArgumentException("Invalid missile type");
        }
    }
}

