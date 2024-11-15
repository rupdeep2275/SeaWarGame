package org.example.models;

public class ShipB extends Ship {
    private static final int MAX_MISSILE_M3 = 15;

    private int missileM3Count = 0;

    public ShipB() {
        super("Ship B", 50); //health: 50, Dimensions: 1x2
    }

    @Override
    public boolean addMissile(Missile missile) {
        if (missile instanceof MissileM3 && missileM3Count < MAX_MISSILE_M3) {
            getArmory().add(missile);
            missileM3Count++;
            return true;
        }
        System.out.println("Cannot add missile. Limit reached or invalid missile type for Ship B.");
        return false;
    }
}

