package src;

public class Client {

    public static void main(String[] args) {

        Downloader downloaderA = new Downloader(new ThirdPartyTVClass());
        Downloader downloaderB = new Downloader(new TVClassProxy());

        long latencyA = test(downloaderA);
        System.out.println("==========================");
        long latencyB = test(downloaderB);

        long result = latencyA - latencyB;

        System.out.println("Time difference: " + result + "ms");
    }

    public static long test(Downloader downloader) {

        long before = System.currentTimeMillis();

        downloader.renderVideoPage("First");
        downloader.renderAllVideos();
        downloader.renderAllVideos();
        downloader.renderVideoPage("First");

        long after = System.currentTimeMillis();

        return after - before;
    }
}
