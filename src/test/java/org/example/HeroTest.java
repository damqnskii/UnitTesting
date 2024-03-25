package org.example;

import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void testHeroAttackWhenTargetDiesHeroGetsXP() {
        Target facade = mock(Target.class);
        Weapon weapon = mock(Weapon.class);
        Hero hero = new Hero("Pesho", weapon);

        when(facade.isDead()).thenReturn(true);
        when(facade.giveExperience()).thenReturn(10);
        hero.attack(facade);

        assertEquals(10, hero.getExperience());

    }
}