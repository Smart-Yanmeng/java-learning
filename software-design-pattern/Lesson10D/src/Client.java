package src;

public class Client {

    public static void main(String[] args) {

        Downloader downloaderA = new Downloader(new ThirdPartyTVClass());
        Downloader downloaderB = new Downloader(new TVClassProxy());

        long result = test(downloaderA) - test(downloaderB);

        System.out.println("Time difference: " + result + "ms");
    }

    public static long test(Downloader downloader) {

        long before = System.currentTimeMillis();

        downloader.renderAllVideos();
        downloader.renderVideoPage("catzzzzzzzzz");

        long after = System.currentTimeMillis();

        return after - before;
    }
}
