import java.util.*;

class VirtualPet {
    final String petId;
    String petName, species;
    int age, happiness, health, stageIndex;
    static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    static int totalPetsCreated = 0;
    boolean isGhost = false;

    VirtualPet() {
        this("Unknown", getRandomSpecies(), 0, 50, 50, 0);
    }

    VirtualPet(String name) {
        this(name, getRandomSpecies(), 0, 60, 60, 1);
    }

    VirtualPet(String name, String species) {
        this(name, species, 0, 70, 70, 2);
    }

    VirtualPet(String name, String species, int age, int happiness, int health, int stageIndex) {
        this.petId = generatePetId();
        this.petName = name;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stageIndex = stageIndex;
        totalPetsCreated++;
    }

    void evolvePet() {
        if (!isGhost && stageIndex < EVOLUTION_STAGES.length - 1 && age > stageIndex * 3 && health > 20) {
            stageIndex++;
        }
    }

    void feedPet() {
        if (!isGhost) {
            health = Math.min(100, health + 10);
        }
    }

    void playWithPet() {
        if (!isGhost) {
            happiness = Math.min(100, happiness + 10);
            health = Math.max(0, health - 5);
            checkDeath();
        }
    }

    void healPet() {
        if (!isGhost) {
            health = Math.min(100, health + 20);
        }
    }

    void simulateDay() {
        if (!isGhost) {
            age++;
            happiness = Math.max(0, happiness - new Random().nextInt(10));
            health = Math.max(0, health - new Random().nextInt(10));
            checkDeath();
            evolvePet();
        }
    }

    void checkDeath() {
        if (health <= 0) {
            isGhost = true;
            species = "Ghost";
        }
    }

    String getPetStatus() {
        return isGhost ? "Ghost" : EVOLUTION_STAGES[stageIndex];
    }

    static String generatePetId() {
        return UUID.randomUUID().toString();
    }

    static String getRandomSpecies() {
        String[] s = {"Dragon", "Wolf", "Cat", "Dog", "Phoenix"};
        return s[new Random().nextInt(s.length)];
    }

    @Override
    public String toString() {
        return petName + " (" + species + ") | Stage: " + getPetStatus() + " | Age: " + age + " | Happiness: " + happiness + " | Health: " + health;
    }
}

public class PetDaycare {
    public static void main(String[] args) {
        List<VirtualPet> pets = new ArrayList<>();
        pets.add(new VirtualPet());
        pets.add(new VirtualPet("Fluffy"));
        pets.add(new VirtualPet("Sparky", "Dragon"));
        pets.add(new VirtualPet("Max", "Wolf", 5, 80, 90, 3));

        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day);
            for (VirtualPet pet : pets) {
                pet.simulateDay();
                System.out.println(pet);
            }
            System.out.println();
        }
    }
}
