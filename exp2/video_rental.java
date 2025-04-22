import java.util.ArrayList;

class Video {
    private String title;
    private boolean checkedOut;
    private double rating;
    private int ratingCount;

    public Video(String title) {
        this.title = title;
        this.checkedOut = false;
        this.rating = 0.0;
        this.ratingCount = 0;
    }

    public void rentOut() {
        if (!checkedOut) {
            checkedOut = true;
            System.out.println("Video '" + title + "' rented out.");
        } else {
            System.out.println("Video '" + title + "' is already rented.");
        }
    }

    public void returnVideo() {
        if (checkedOut) {
            checkedOut = false;
            System.out.println("Video '" + title + "' returned successfully.");
        } else {
            System.out.println("Video '" + title + "' was not rented.");
        }
    }

    public void rateVideo(double newRating) {
        if (newRating >= 0 && newRating <= 5) {
            rating = ((rating * ratingCount) + newRating) / (++ratingCount);
            System.out.println("New rating added for '" + title + "'. Updated Rating: " + rating);
        } else {
            System.out.println("Invalid rating! Please provide a rating between 0 and 5.");
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Checked Out: " + checkedOut + ", Rating: " + rating + " (" + ratingCount + " ratings)";
    }
}

class VideoStore {
    private ArrayList<Video> videos = new ArrayList<>();

    public void addVideo(String title) {
        videos.add(new Video(title));
        System.out.println("Video '" + title + "' added to the store.");
    }

    public void rentVideo(String title) {
        for (Video v : videos) {
            if (v.toString().contains(title)) {
                v.rentOut();
                return;
            }
        }
        System.out.println("Video '" + title + "' not found in the store.");
    }

    public void returnVideo(String title) {
        for (Video v : videos) {
            if (v.toString().contains(title)) {
                v.returnVideo();
                return;
            }
        }
        System.out.println("Video '" + title + "' not found in the store.");
    }

    public void rateVideo(String title, double rating) {
        for (Video v : videos) {
            if (v.toString().contains(title)) {
                v.rateVideo(rating);
                return;
            }
        }
        System.out.println("Video '" + title + "' not found in the store.");
    }

    public void displayVideos() {
        if (videos.isEmpty()) {
            System.out.println("No videos available in the store.");
        } else {
            for (Video v : videos) {
                System.out.println(v);
            }
        }
    }
}

public class VideoRentalShop {
    public static void main(String[] args) {
        VideoStore store = new VideoStore();

        // Adding Videos
        store.addVideo("Inception");
        store.addVideo("Interstellar");
        store.addVideo("The Matrix");

        // Renting out videos
        store.rentVideo("Inception");
        store.returnVideo("Inception");

        // Rating videos
        store.rateVideo("Inception", 4.5);
        store.rateVideo("Interstellar", 5.0);

        // Displaying all videos
        store.displayVideos();
    }
}
