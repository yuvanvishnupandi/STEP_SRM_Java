// File: Camera.java
public interface Camera {
    void takePhoto();
}

// File: MusicPlayer.java
public interface MusicPlayer {
    void playMusic();
}

// File: SmartPhone.java
public class SmartPhone implements Camera, MusicPlayer {
    @Override
    public void takePhoto() {
        System.out.println("Taking photo with smartphone");
    }
    @Override
    public void playMusic() {
        System.out.println("Playing music on smartphone");
    }
}

// File: DeviceTest.java
public class DeviceTest {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone();
        sp.takePhoto();
        sp.playMusic();
    }
}
