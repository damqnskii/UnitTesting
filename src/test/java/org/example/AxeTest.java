package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;
    private Axe axe;
    private Axe brokenAxe;
    private Dummy dummy;

    @Before
    public void initializeObject() {
        this.axe = new Axe (AXE_ATTACK, AXE_DURABILITY);
        this.brokenAxe = new Axe(AXE_ATTACK, 0);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }
    @Test
    public void TestAxeIfLosesDurabilityAfterAttack () {
        axe.attack(dummy);
        assertEquals(0, axe.getDurabilityPoints());

    }
    @Test (expected = IllegalStateException.class)
    public void TestWithBrokenWeapon() {
        brokenAxe.attack(dummy);
    }



}