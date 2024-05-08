package src;

import java.util.HashMap;

public interface ThirdPartyTVLib {

    HashMap<String, Video> listVideos();

    Video getVideo(String id);
}
