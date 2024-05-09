package src;

import java.util.HashMap;

public class Downloader {

    private final ThirdPartyTVLib api;

    public Downloader(ThirdPartyTVLib api) {
        this.api = api;
    }

    void renderVideoPage(String id) {

        System.out.println("--------------------------");

        Video video = api.getVideo(id);

        System.out.println("src.Video page (imagine fancy HTML)");
        System.out.println("ID: " + video.id);
        System.out.println("Title: " + video.title);
        System.out.println("Video: " + video.data);
        System.out.println("--------------------------");
    }

    void renderAllVideos() {

        HashMap<String, Video> list = this.api.listVideos();

        for (Video video : list.values()) {
            this.renderVideoPage(video.id);
        }
    }
}
