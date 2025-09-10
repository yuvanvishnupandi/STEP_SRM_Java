// KingdomSystem.java

import java.util.*;

// Immutable KingdomConfig
final class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;
    private final String[] allowedStructureTypes;
    private final Map<String, Integer> resourceLimits;

    public KingdomConfig(String name, int year, String[] types, Map<String, Integer> limits) {
        if (name == null || types == null || limits == null) {
            throw new IllegalArgumentException("Invalid config");
        }
        this.kingdomName = name;
        this.foundingYear = year;
        this.allowedStructureTypes = types.clone();
        this.resourceLimits = new HashMap<>(limits);
    }

    public String getKingdomName() { return kingdomName; }
    public int getFoundingYear() { return foundingYear; }
    public String[] getAllowedStructureTypes() { return allowedStructureTypes.clone(); }
    public Map<String, Integer> getResourceLimits() { return new HashMap<>(resourceLimits); }

    public static KingdomConfig createDefaultKingdom() {
        return new KingdomConfig("Avalon", 1200, new String[]{"Tower","Castle"}, Map.of("Gold", 1000, "Food", 500));
    }

    @Override
    public String toString() {
        return "Kingdom: " + kingdomName + " (Founded " + foundingYear + ")";
    }
}

// Base MagicalStructure
class MagicalStructure {
    private final String structureId;
    private final long constructionTimestamp;
    private final String structureName;
    private final String location;

    private int magicPower;
    private boolean isActive;
    private String currentMaintainer;

    static final int MIN_MAGIC_POWER = 0, MAX_MAGIC_POWER = 1000;
    public static final String MAGIC_SYSTEM_VERSION = "3.0";

    // Constructor chaining
    public MagicalStructure(String name, String location) {
        this(name, location, 100, true);
    }

    public MagicalStructure(String name, String location, int power) {
        this(name, location, power, true);
    }

    public MagicalStructure(String name, String location, int power, boolean active) {
        if (power < MIN_MAGIC_POWER || power > MAX_MAGIC_POWER)
            throw new IllegalArgumentException("Invalid power");

        this.structureId = "STR-" + System.nanoTime();
        this.constructionTimestamp = System.currentTimeMillis();
        this.structureName = name;
        this.location = location;
        this.magicPower = power;
        this.isActive = active;
        this.currentMaintainer = "Unknown";
    }

    public int getMagicPower() { return magicPower; }
    public void setMagicPower(int power) {
        if (power >= MIN_MAGIC_POWER && power <= MAX_MAGIC_POWER) this.magicPower = power;
    }

    @Override
    public String toString() {
        return structureName + " at " + location + " | Power=" + magicPower;
    }
}

// Demo
public class KingdomSystem {
    public static void main(String[] args) {
        KingdomConfig config = KingdomConfig.createDefaultKingdom();
        MagicalStructure tower = new MagicalStructure("Wizard Tower", "North", 500);
        MagicalStructure castle = new MagicalStructure("Royal Castle", "Capital");

        System.out.println(config);
        System.out.println(tower);
        System.out.println(castle);
    }
}
