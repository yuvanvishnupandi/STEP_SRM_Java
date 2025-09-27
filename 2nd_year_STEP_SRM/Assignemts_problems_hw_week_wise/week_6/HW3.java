// 🧪 HW PROBLEM 3: Game and Card Game Objects
// Topic: Overriding Object Methods

class Game {
    String name;

    Game(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Game: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Game)) return false;
        Game g = (Game) obj;
        return this.name.equals(g.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

class CardGame extends Game {
    int players;

    CardGame(String name, int players) {
        super(name);
        this.players = players;
    }

    @Override
    public String toString() {
        return super.toString() + ", Players: " + players;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof CardGame)) return false;
        CardGame cg = (CardGame) obj;
        return this.players == cg.players;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + players;
    }
}

public class HW3 {
    public static void main(String[] args) {
        CardGame c1 = new CardGame("Poker", 4);
        CardGame c2 = new CardGame("Poker", 4);

        System.out.println(c1);
        System.out.println("c1 equals c2? " + c1.equals(c2));
    }
}
