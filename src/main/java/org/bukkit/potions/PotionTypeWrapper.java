package org.bukkit.potions;

public class PotionTypeWrapper extends PotionType {
    protected PotionTypeWrapper(int id) {
        super(id);
    }

    /**
     * Get the potion type bound to this wrapper.
     */
    public PotionType getType() {
        return PotionType.getById(getId());
    }

    @Override
    public double getDurationModifier() {
        return getType().getDurationModifier();
    }

    @Override
    public boolean isInstant() {
        return getType().isInstant();
    }
}
