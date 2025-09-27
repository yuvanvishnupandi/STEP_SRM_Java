// File: StreamingPlatform.java
// PROBLEM 5: Movie Streaming Platform - Downcasting

class Content {
    protected String title;
    public Content(String title) { this.title = title; }
    public void play() { System.out.println("Playing: " + title); }
}

class MovieContent extends Content {
    private double rating;
    private int durationMin;
    private boolean subtitlesAvailable;
    public MovieContent(String title, double rating, int durationMin, boolean subs) {
        super(title); this.rating = rating; this.durationMin = durationMin; this.subtitlesAvailable = subs;
    }
    public void showDetails() {
        System.out.println("Movie: " + title + " | Rating: " + rating + " | Duration: " + durationMin + "min | Subtitles: " + subtitlesAvailable);
    }
}

class TVSeries extends Content {
    private int seasons;
    private int episodes;
    public TVSeries(String title, int seasons, int episodes) {
        super(title); this.seasons = seasons; this.episodes = episodes;
    }
    public void suggestNextEpisode() {
        System.out.println("Next episode of " + title + " suggested.");
    }
}

class Documentary extends Content {
    private String[] tags;
    public Documentary(String title, String[] tags) {
        super(title); this.tags = tags;
    }
    public void showRelated() {
        System.out.println("Related docs for " + title + ": " + String.join(", ", tags));
    }
}

public class StreamingPlatform {
    public static void main(String[] args) {
        Content cur = new MovieContent("Inception", 8.8, 148, true);
        cur.play();

        // downcast to access movie-specific features
        if (cur instanceof MovieContent) {
            MovieContent m = (MovieContent) cur;
            m.showDetails();
        }

        cur = new TVSeries("Space Saga", 3, 24);
        cur.play();
        if (cur instanceof TVSeries) {
            TVSeries t = (TVSeries) cur;
            t.suggestNextEpisode();
        }

        cur = new Documentary("Planet Earth", new String[]{"Nature", "Wildlife"});
        cur.play();
        if (cur instanceof Documentary) {
            Documentary d = (Documentary) cur;
            d.showRelated();
        }

        // wrong downcast example (guarded by instanceof in real code)
        // if (cur instanceof MovieContent) { MovieContent bad = (MovieContent) cur; bad.showDetails(); }
    }
}
