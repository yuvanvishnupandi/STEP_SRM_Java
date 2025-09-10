// VirtualPetSystem.java

import java.util.*;

// Immutable PetSpecies class
final class PetSpecies {
    private final String speciesName;
    private final String[] evolutionStages;
    private final int maxLifespan;
    private final String habitat;

    public PetSpecies(String speciesName, String[] evolutionStages, int maxLifespan, String habitat) {
        if (speciesName == null || speciesName.isEmpty() || maxLifespan <= 0 || evolutionStages == null) {
            throw new IllegalArgumentException("Invalid species data");
        }
        this.speciesName = speciesName;
        this.evolutionStages = evolutionStages.clone(); // defensive copy
        this.maxLifespan = maxLifespan;
        this.habitat = habitat;
    }

    public String getSpeciesName() { return speciesName; }
    public String[] getEvolutionStages() { return evolutionStages.clone(); }
    public int getMaxLifespan() { return maxLifespan; }
    public String getHabitat() { return habitat; }

    @Override
    public String toString() {
        return "Species: " + speciesName + ", Habitat: " + habitat + ", Max Age: " + maxLifespan;
    }
}

// VirtualPet class
class VirtualPet {
    // Immutable core
    private final String petId;
    private final PetSpecies species;
    private final long birthTimestamp;

    // Mutable state
    private String petName;
    private int age, happiness, health;

    // Constants
    protected static final String[] DEFAULT_EVOLUTION_STAGES = {"Egg", "Young", "Adult"};
    static final int MAX_HAPPINESS = 100, MAX_HEALTH = 100;
    public static final String PET_SYSTEM_VERSION = "2.0";

    // Constructor chaining
    public VirtualPet() {
        this("Unnamed", new PetSpecies("Default", DEFAULT_EVOLUTION_STAGES, 10, "Land"), 0, 50, 50);
    }

    public VirtualPet(String name) {
        this(name, new PetSpecies("Default", DEFAULT_EVOLUTION_STAGES, 10, "Land"), 0, 60, 60);
    }

    public VirtualPet(String name, PetSpecies species) {
        this(name, species, 0, 70, 70);
    }

    public VirtualPet(String name, PetSpecies species, int age, int happiness, int health) {
        this.petId = generatePetId();
        this.birthTimestamp = System.currentTimeMillis();
        this.species = species;
        this.petName = name;
        setAge(age);
        setHappiness(happiness);
        setHealth(health);
    }

    // Getters & Setters with validation
    public String getPetName() { return petName; }
    public void setPetName(String name) { this.petName = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = Math.max(0, age); }

    public int getHappiness() { return happiness; }
    public void setHappiness(int happiness) { this.happiness = validateStat(happiness); }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = validateStat(health); }

    // Public actions
    public void feedPet(String foodType) { modifyHealth(10); }
    public void playWithPet(String gameType) { modifyHappiness(15); }

    // Private helpers
    private int validateStat(int value) {
        return Math.min(Math.max(value, 0), 100);
    }
    private void modifyHappiness(int delta) { setHappiness(happiness + delta); }
    private void modifyHealth(int delta) { setHealth(health + delta); }
    private String generatePetId() { return "PET-" + System.nanoTime(); }

    @Override
    public String toString() {
        return petName + " (" + species.getSpeciesName() + ") | Health=" + health + ", Happiness=" + happiness;
    }
}

// Demo
public class VirtualPetSystem {
    public static void main(String[] args) {
        PetSpecies dragon = new PetSpecies("Dragon", new String[]{"Egg","Hatchling","Adult"}, 300, "Cave");
        VirtualPet pet = new VirtualPet("Smoky", dragon);
        System.out.println(pet);

        pet.feedPet("Meat");
        pet.playWithPet("Flying");
        System.out.println("After care: " + pet);
    }
}
