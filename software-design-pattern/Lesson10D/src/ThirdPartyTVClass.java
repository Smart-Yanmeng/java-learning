package src;

import java.util.HashMap;

public class ThirdPartyTVClass implements ThirdPartyTVLib {

    public ThirdPartyTVClass() {
    }

    @Override
    public HashMap<String, Video> listVideos() {

        this.connectToServer("https://www.youtube.com");

        return this.getRandomVideos();
    }

    @Override
    public Video getVideo(String id) {

        this.connectToServer("https://www.youtube.com/" + id);

        return this.getSomeVideos(id);
    }

    private Video getSomeVideos(String id) {

        System.out.println("Downloading video...");
        this.experienceNetworkLatency();
        Video video = new Video(id, "Some video title");
        System.out.println("Done!");

        return video;
    }

    private void connectToServer(String server) {

        System.out.println("Connecting to " + server);

        System.out.println("Connected!");
    }

    private HashMap<String, Video> getRandomVideos() {

        System.out.println("Downloading populars... ");

        this.experienceNetworkLatency();

        HashMap<String, Video> hmap = new HashMap<String, Video>();
        hmap.put("First", new Video("First", "First.avi"));
        hmap.put("Second", new Video("Second", "Second.mp4"));
        hmap.put("Third", new Video("Third", "Third.mpq"));
        hmap.put("Fourth", new Video("Fourth", "Fourth.mov"));
        hmap.put("Fifth", new Video("Fifth", "Fifth.avi"));

        System.out.println("Done!");

        return hmap;
    }

    private void experienceNetworkLatency() {

        int randomLatency = this.random(5, 10);
        System.out.println("Network latency: " + randomLatency * 10 + "ms");

        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int random(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
