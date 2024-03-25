package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 100;
    private static final int AXE_ATTACK = 100;
    private static final int AXE_DURABILITY = 100;
    private Axe axe;
    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        deadDummy = new Dummy(0, 15);
    }

    @Test
    public void testDummyLosesHealthAfterAttack() {
        int dmgToTake = 50;
        dummy.takeAttack(50);
        assertEquals(DUMMY_HEALTH - dmgToTake, dummy.getHealth());
    }

    @Test (expected = IllegalStateException.class)
    public void testIfAnExceptionThrownAfterAttackingDeadDummy() {
        deadDummy.takeAttack(AXE_ATTACK);
    }
    @Test
    public void testDeadDummyGivesExperience() {
        assertEquals(15, deadDummy.giveExperience());
    }
    @Test (expected = IllegalStateException.class)
    public void testDeadDummyGivesExceptionIfAlive() {
        dummy.giveExperience();
    }

}