package org.bukkit.potions;

/**
 * Represents a type of potion and its effect on an entity.
 */
public abstract class PotionType {
    /**
     * Increases movement speed.
     */
    public static PotionType FASTER_MOVEMENT = new PotionTypeWrapper(1);

    /**
     * Decreases movement speed.
     */
    public static PotionType SLOWER_MOVEMENT = new PotionTypeWrapper(2);

    /**
     * Increases dig speed.
     */
    public static PotionType FASTER_DIG = new PotionTypeWrapper(3);

    /**
     * Decreases dig speed.
     */
    public static PotionType SLOWER_DIG = new PotionTypeWrapper(4);

    /**
     * Increases damage dealt.
     */
    public static PotionType INCREASE_DAMAGE = new PotionTypeWrapper(5);

    /**
     * Heals an entity.
     */
    public static PotionType HEAL = new PotionTypeWrapper(6);

    /**
     * Hurts an entity.
     */
    public static PotionType HARM = new PotionTypeWrapper(7);

    /**
     * Increases jump height.
     */
    public static PotionType JUMP = new PotionTypeWrapper(8);

    /**
     * Warps vision on the client.
     */
    public static PotionType CONFUSION = new PotionTypeWrapper(9);

    /**
     * Regenerates health.
     */
    public static PotionType REGENERATION = new PotionTypeWrapper(10);

    /**
     * Decreases damage dealt to an entity.
     */
    public static PotionType RESISTANCE = new PotionTypeWrapper(11);

    /**
     * Stops fire damage.
     */
    public static PotionType FIRE_RESISTANCE = new PotionTypeWrapper(12);

    /**
     * Allows breathing underwater.
     */
    public static PotionType WATER_BREATHING = new PotionTypeWrapper(13);


    /**
     * Grants invisibility.
     */
    // public static PotionType INVISIBILITY = new PotionTypeWrapper(14); unimplemented

    /**
     * Blinds an entity.
     */
    public static PotionType BLINDNESS = new PotionTypeWrapper(15);

    /**
     * Allows an entity to see in the dark.
     */
    // public static PotionType NIGHT_VISION = new PotionTypeWrapper(16); unimplemented

    /**
     * Increases hunger.
     */
    public static PotionType HUNGER = new PotionTypeWrapper(17);

    /**
     * Decreases damage dealt by an entity.
     */
    public static PotionType WEAKNESS = new PotionTypeWrapper(18);

    /**
     * Deals damage to an entity over time.
     */
    public static PotionType POISON = new PotionTypeWrapper(19);

    private final int id;

    protected PotionType(int id) {
        this.id = id;
    }

    public PotionEffect createEffect(int duration, int amplifier) {
        return brewer.createEffect(this, duration, amplifier);
    }

    /**
     * Returns the unique ID of this type.
     * 
     * @return Unique ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns whether the effect of this type happens once, immediately.
     * 
     * @return whether this type is normally instant
     */
    public abstract boolean isInstant();

    /**
     * Returns the duration modifier applied to effects of this type.
     * 
     * @return duration modifier
     */
    public abstract double getDurationModifier();

    private static final PotionType[] byId = new PotionType[19]; // will break on updates.
    private static boolean acceptingNew = true;

    /**
     * Gets the PotionType specified by the unique id.
     * 
     * @param id unique ID to fetch
     * @return Resulting PotionType, or null if not found.
     */
    public static PotionType getById(int id) {
        if(id > byId.length)
            return null;
        return byId[id];
    }

    /**
     * Registers a potion type with the given object.
     * <p>
     * Generally not to be used from within a plugin.
     *
     * @param potionType PotionType to register
     */
    public static void registerPotionType(PotionType potionType) {
        if (byId[potionType.id] != null) {
            throw new IllegalArgumentException("Cannot set already-set potion type");
        } else if (!acceptingNew) {
            throw new IllegalStateException("No longer accepting new potion types (can only be done by the server implementation)");
        }

        byId[potionType.id] = potionType;
    }

    /**
     * Stops accepting any potion type registrations.
     */
    public static void stopAcceptingRegistrations() {
        acceptingNew = false;
    }

    /**
     * Returns an array of all the registered {@link PotionType}s.
     * 
     * @return Array of PotionTypes.
     */
    public static PotionType[] values() {
        return byId.clone();
    }

    private static PotionBrewer brewer;

    /**
     * Returns an instance of {@link PotionBrewer}.
     * 
     * @return An instance of PotionBrewer
     */
    public static PotionBrewer getPotionBrewer() {
        return brewer;
    }

    /**
     * Sets the current instance of {@link PotionBrewer}.
     * Generally not to be used from within a plugin.
     * 
     * @param other The new PotionBrewer
     */
    public static void setPotionBrewer(PotionBrewer other) {
        if (brewer == null)
            throw new IllegalArgumentException("brewer can only be set internally");
        brewer = other;
    }
}
