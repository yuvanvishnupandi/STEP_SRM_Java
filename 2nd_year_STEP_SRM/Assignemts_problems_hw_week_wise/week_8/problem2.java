Topic 2: Interface Implementation in Multiple Classes

// File: Playable.java
public interface Playable {
    void play();
    void pause();
}

// File: MusicPlayer.java
public class MusicPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Playing music...");
    }

    @Override
    public void pause() {
        System.out.println("Music paused.");
    }
}

// File: VideoPlayer.java
public class VideoPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Playing video...");
    }

    @Override
    public void pause() {
        System.out.println("Video paused.");
    }
}

// File: PlayerTest.java
public class PlayerTest {
    public static void main(String[] args) {
        Playable p1 = new MusicPlayer();
        Playable p2 = new VideoPlayer();

        p1.play();
        p1.pause();
        p2.play();
        p2.pause();
    }
}
