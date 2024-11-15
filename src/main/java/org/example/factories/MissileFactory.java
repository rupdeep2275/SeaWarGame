package org.example.factories;

import org.example.models.Missile;
import org.example.models.MissileM1;
import org.example.models.MissileM2;
import org.example.models.MissileM3;

public class MissileFactory {
    public static Missile createMissile(String type) {
        switch (type) {
            case "M1":
                return new MissileM1();
            case "M2":
                return new MissileM2();
            case "M3":
                return new MissileM3();
            default:
                throw new IllegalArgumentException("Invalid missile type");
        }
    }
}

