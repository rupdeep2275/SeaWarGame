package org.example.models;

public class ShipA extends Ship {
    private static final int MAX_MISSILE_M1 = 5;
    private static final int MAX_MISSILE_M2 = 10;

    private int missileM1Count = 0;
    private int missileM2Count = 0;

    public ShipA() {
        super("Ship A", 100, 2, 2); //health: 100, Dimensions: 2x2
    }

    @Override
    public boolean addMissile(Missile missile) {
        if (missile instanceof MissileM1 && missileM1Count < MAX_MISSILE_M1) {
            getArmory().add(missile);
            missileM1Count++;
            return true;
        } else if (missile instanceof MissileM2 && missileM2Count < MAX_MISSILE_M2) {
            getArmory().add(missile);
            missileM2Count++;
            return true;
        }
        System.out.println("Cannot add missile. Limit reached or invalid missile type for Ship A.");
        return false;
    }
}

