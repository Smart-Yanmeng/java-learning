package src;

import java.util.HashMap;

public class TVClassProxy implements ThirdPartyTVLib {

    private final ThirdPartyTVLib servers = new ThirdPartyTVClass();

//    HashMap<String, Video> cachePopular = new HashMap<>();
    HashMap<String, Video> cacheAll = new HashMap<>();

    @Override
    public HashMap<String, Video> listVideos() {

        if (this.cacheAll.isEmpty()) {
            this.cacheAll = this.servers.listVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }

        return this.cacheAll;
    }

    @Override
    public Video getVideo(String id) {

        Video video = this.cacheAll.get(id);

        if (video == null) {
            video = this.servers.getVideo(id);
            this.cacheAll.put(id, video);
        } else {
            System.out.println("Retrieved video " + id + " from cache.");
        }

        return video;
    }
}
