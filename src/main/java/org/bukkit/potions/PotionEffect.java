package org.bukkit.potions;

import org.bukkit.entity.LivingEntity;

/**
 * Represents a potion effect, that can be added to a {@link LivingEntity}.
 * A potion effect has a duration that it will last for, an amplifier that will
 * enhance its effects, and a {@link PotionType}, that represents its effect on an entity.
 */
public interface PotionEffect {
    /**
     * Attempts to add the effect represented by this object to the given
     * {@link LivingEntity}.
     * 
     * @see LivingEntity#addPotionEffect(PotionEffect)
     * @param entity The entity to add this effect to
     */
    public boolean apply(LivingEntity entity);

    /**
     * Returns the amplifier of this effect. A higher amplifier means the potion effect
     * happens more often over its duration and in some cases has more effect on its target.
     */
    public int getAmplifier();

    /**
     * Returns the duration (in ticks) that this effect will run for when applied
     * to a {@link LivingEntity}.
     */
    public int getDuration();

    /**
     * Returns the {@link PotionType} of this effect.
     * 
     * @return The potion type of this effect
     */
    public PotionType getType();
}
