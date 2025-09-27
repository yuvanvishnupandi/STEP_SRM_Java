// 🧪 PROBLEM 5: Movie Streaming Platform
// Concept: Downcasting

class Content {
    String title;
    Content(String title){ this.title = title; }
    void play() { System.out.println("Playing " + title); }
}

class Movie extends Content {
    int duration;
    Movie(String title, int duration){ super(title); this.duration = duration; }
    void subtitles() { System.out.println("Showing subtitles for " + title); }
}

class TVSeries extends Content {
    int episodes;
    TVSeries(String title, int episodes){ super(title); this.episodes = episodes; }
    void nextEpisode() { System.out.println("Next episode available for " + title); }
}

public class Problem5 {
    public static void main(String[] args) {
        Content c = new Movie("Avengers", 120);
        c.play();

        // Downcasting to access Movie specific feature
        if(c instanceof Movie){
            Movie m = (Movie)c;
            m.subtitles();
        }
    }
}
