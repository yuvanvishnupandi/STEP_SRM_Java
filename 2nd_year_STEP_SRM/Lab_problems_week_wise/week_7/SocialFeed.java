// File: SocialFeed.java
// PROBLEM 2: Social Media Feed - Method Overriding

class Post {
    protected String author;
    protected String content;
    protected String time;

    public Post(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    public void display() {
        System.out.println(time + " | " + author + ": " + content);
    }
}

class InstagramPost2 extends Post {
    private int likes;
    private String[] hashtags;

    public InstagramPost2(String author, String content, String time, int likes, String[] hashtags) {
        super(author, content, time);
        this.likes = likes;
        this.hashtags = hashtags;
    }

    @Override
    public void display() {
        String tags = String.join(" ", hashtags);
        System.out.println(time + " | @" + author + " (IG) : " + content + " " + tags + " [" + likes + " likes]");
    }
}

class TwitterPost2 extends Post {
    private int retweets;

    public TwitterPost2(String author, String content, String time, int retweets) {
        super(author, content, time);
        this.retweets = retweets;
    }

    @Override
    public void display() {
        System.out.println(time + " | @" + author + " (TW) : " + content + " (" + content.length() + " chars) [" + retweets + " RTs]");
    }
}

class LinkedInPost2 extends Post {
    private int connections;

    public LinkedInPost2(String author, String content, String time, int connections) {
        super(author, content, time);
        this.connections = connections;
    }

    @Override
    public void display() {
        System.out.println(time + " | " + author + " (LI) - Connections: " + connections + "\n" + content);
    }
}

public class SocialFeed {
    public static void main(String[] args) {
        Post[] feed = new Post[3];
        feed[0] = new InstagramPost2("sara", "Sunset #beach", "10:00", 120, new String[]{"#sunset", "#beach"});
        feed[1] = new TwitterPost2("dev_guy", "Java polymorphism rocks!", "10:05", 40);
        feed[2] = new LinkedInPost2("prof.m", "New research published on AI.", "10:10", 500);

        for (Post p : feed) {
            p.display();
        }
    }
}
