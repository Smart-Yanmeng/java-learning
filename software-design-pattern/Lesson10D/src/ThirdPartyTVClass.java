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
        hmap.put("catzzzzzzzzz", new Video("catzzzzzzzzz", "Catzzzz.avi"));
        hmap.put("mkafksangasj", new Video("mkafksangasj", "Dog play with ball.mp4"));
        hmap.put("dancesvideoo", new Video("dancesvideoo", "Dancing video.mpq"));
        hmap.put("dlsdk5jfsljfl", new Video("dlsdk5jfsljfl", "Barcelona vs RealM.mov"));
        hmap.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Programing lesson#1.avi"));

        System.out.println("Done!");

        return hmap;
    }

    private void experienceNetworkLatency() {
        int randomLatency = this.random(5, 10);

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
