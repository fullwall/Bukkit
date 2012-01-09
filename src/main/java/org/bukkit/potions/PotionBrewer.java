package org.bukkit.potions;

import java.util.Collection;

/**
 * Represents a brewer that can create {@link PotionEffect}s. 
 */
public interface PotionBrewer {
    /**
     * Returns a collection of {@link PotionEffect} that would be applied from a potion
     * with the given data value.
     *
     * @param damage The data value of the potion
     * @return
     */
    public Collection<PotionEffect> getEffectsFromDamage(int damage);

    /**
     * Creates a {@link PotionEffect} from the given {@link PotionType}, applying
     * duration modifiers and checks.
     * 
     * @param potion The type of potion
     * @param duration The duration in ticks
     * @param amplifier The amplifier of the effect
     */
    public PotionEffect createEffect(PotionType potion, int duration, int amplifier);

    /**
     * Creates a {@link PotionEffect} from the given {@link PotionType} without applying
     * duration modifiers and checks.
     * 
     * @param type The type of the effect
     * @param duration The duration in ticks of the desired effect
     * @param amplifier The amplifier of the effect
     */
    public PotionEffect createEffectRaw(PotionType type, int duration, int amplifier);
}
