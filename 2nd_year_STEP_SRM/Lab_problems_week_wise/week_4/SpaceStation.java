import java.util.*;

enum CrewRank {
    CADET(1), OFFICER(2), COMMANDER(3), CAPTAIN(4), ADMIRAL(5);
    private final int level;
    CrewRank(int level) { this.level = level; }
    public int getLevel() { return level; }
}

class SpaceCrew {
    final String crewId;
    final String homeplanet;
    final CrewRank initialRank;
    String name;
    CrewRank currentRank;
    int skillLevel;
    int missionCount;
    int spaceHours;
    static final String STATION_NAME = "Stellar Odyssey";
    static final int MAX_CREW_CAPACITY = 50;

    SpaceCrew(String name) {
        this(name, getRandomPlanet(), CrewRank.CADET, 0, 0, 0);
    }

    SpaceCrew(String name, String homeplanet, CrewRank rank) {
        this(name, homeplanet, rank, 0, 0, 0);
    }

    SpaceCrew(String name, String homeplanet, CrewRank rank, int missionCount, int skillLevel) {
        this(name, homeplanet, rank, missionCount, skillLevel, missionCount * 100);
    }

    SpaceCrew(String name, String homeplanet, CrewRank rank, int missionCount, int skillLevel, int spaceHours) {
        this.crewId = generateCrewId();
        this.name = name;
        this.homeplanet = homeplanet;
        this.initialRank = rank;
        this.currentRank = rank;
        this.missionCount = missionCount;
        this.skillLevel = skillLevel;
        this.spaceHours = spaceHours;
    }

    final String getCrewIdentification() {
        return crewId + " | " + name + " | " + homeplanet + " | " + initialRank;
    }

    final boolean canBePromoted() {
        return currentRank.getLevel() < CrewRank.ADMIRAL.getLevel() && skillLevel > 50 && missionCount > 5;
    }

    final int calculateSpaceExperience() {
        return skillLevel * 10 + missionCount * 20 + spaceHours / 10;
    }

    static String generateCrewId() {
        return UUID.randomUUID().toString();
    }

    static String getRandomPlanet() {
        String[] planets = {"Earth", "Mars", "Venus", "Jupiter", "Neptune"};
        return planets[new Random().nextInt(planets.length)];
    }

    @Override
    public String toString() {
        return name + " [" + currentRank + "] | Home: " + homeplanet + " | Skill: " + skillLevel + " | Missions: " + missionCount + " | Hours: " + spaceHours;
    }
}

class PilotCrew extends SpaceCrew {
    final String flightCertification;
    PilotCrew(String name, String cert) {
        super(name, getRandomPlanet(), CrewRank.CADET);
        this.flightCertification = cert;
    }
    @Override
    public String toString() {
        return super.toString() + " | Cert: " + flightCertification;
    }
}

class ScienceCrew extends SpaceCrew {
    final String specialization;
    ScienceCrew(String name, String spec) {
        super(name, getRandomPlanet(), CrewRank.OFFICER);
        this.specialization = spec;
    }
    @Override
    public String toString() {
        return super.toString() + " | Spec: " + specialization;
    }
}

class EngineerCrew extends SpaceCrew {
    final String engineeringType;
    EngineerCrew(String name, String type) {
        super(name, getRandomPlanet(), CrewRank.COMMANDER);
        this.engineeringType = type;
    }
    @Override
    public String toString() {
        return super.toString() + " | Eng: " + engineeringType;
    }
}

final class SpaceStationRegistry {
    private static List<SpaceCrew> crewList = new ArrayList<>();

    static void addCrew(SpaceCrew crew) {
        if (crewList.size() < SpaceCrew.MAX_CREW_CAPACITY) {
            crewList.add(crew);
        }
    }

    static void showAllCrew() {
        for (SpaceCrew c : crewList) System.out.println(c);
    }

    static int calculateTotalExperience() {
        int total = 0;
        for (SpaceCrew c : crewList) total += c.calculateSpaceExperience();
        return total;
    }
}

public class SpaceStation {
    public static void main(String[] args) {
        SpaceCrew c1 = new SpaceCrew("Alice");
        SpaceCrew c2 = new SpaceCrew("Bob", "Mars", CrewRank.OFFICER);
        SpaceCrew c3 = new SpaceCrew("Cara", "Venus", CrewRank.COMMANDER, 6, 70);
        PilotCrew p1 = new PilotCrew("David", "X-Wing Cert");
        ScienceCrew s1 = new ScienceCrew("Eva", "Astrobiology");
        EngineerCrew e1 = new EngineerCrew("Frank", "Warp Systems");

        SpaceStationRegistry.addCrew(c1);
        SpaceStationRegistry.addCrew(c2);
        SpaceStationRegistry.addCrew(c3);
        SpaceStationRegistry.addCrew(p1);
        SpaceStationRegistry.addCrew(s1);
        SpaceStationRegistry.addCrew(e1);

        SpaceStationRegistry.showAllCrew();
        System.out.println("Total Experience: " + SpaceStationRegistry.calculateTotalExperience());
    }
}
