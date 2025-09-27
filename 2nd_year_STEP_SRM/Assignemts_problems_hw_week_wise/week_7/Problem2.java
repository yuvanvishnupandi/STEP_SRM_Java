// 🧪 PROBLEM 2: Social Media Feed
// Concept: Method Overriding

class SocialMediaPost {
    String author;
    String content;
    String time;

    SocialMediaPost(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    void display() {
        System.out.println(author + ": " + content + " at " + time);
    }
}

class InstagramPost extends SocialMediaPost {
    int likes;
    InstagramPost(String author, String content, String time, int likes) {
        super(author, content, time);
        this.likes = likes;
    }

    @Override
    void display() {
        System.out.println("Instagram: " + content + " by @" + author + " - " + likes + " likes");
    }
}

class TwitterPost extends SocialMediaPost {
    int retweets;
    TwitterPost(String author, String content, String time, int retweets) {
        super(author, content, time);
        this.retweets = retweets;
    }

    @Override
    void display() {
        System.out.println("Twitter: " + content + " by @" + author + " - " + retweets + " retweets");
    }
}

class LinkedInPost extends SocialMediaPost {
    int connections;
    LinkedInPost(String author, String content, String time, int connections) {
        super(author, content, time);
        this.connections = connections;
    }

    @Override
    void display() {
        System.out.println("LinkedIn: " + content + " by " + author + " - " + connections + " connections");
    }
}

public class Problem2 {
    public static void main(String[] args) {
        SocialMediaPost[] feed = {
            new InstagramPost("alice", "Sunset pics!", "10:00AM", 150),
            new TwitterPost("bob", "Java rocks!", "11:00AM", 30),
            new LinkedInPost("carol", "Career tips", "12:00PM", 500)
        };

        for(SocialMediaPost post : feed) {
            post.display();
        }
    }
}
