package thread;

/**
 * 实现 Runnable 接口实现多线程
 */
public class RunnableDownload extends Thread {

    private String url; //远程路径
    private String name; //存储名字

    public RunnableDownload(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader downloader = new WebDownloader();
        downloader.download(url, name);
    }

    public static void main(String[] args) {

        RunnableDownload td1 = new RunnableDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568208083116&di=783c18e986b8824ca428b6aa7c02c0de&imgtype=0&src=http%3A%2F%2Fwww.cnplugins.com%2Fuploads%2Fcrximage%2F201502%2Fwww.cnplugins.com_bkgheafjpigbhblaobcdfobilcmpjglb_3.jpg", "img1.jpg");
        RunnableDownload td2 = new RunnableDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568208083113&di=179753fd166b9225224d2a7b644b5faf&imgtype=0&src=http%3A%2F%2Fwww.wuzhicms.com%2Fuploadfile%2F2014%2F11%2F26%2F1416985930741863.png", "img2.png");
        RunnableDownload td3 = new RunnableDownload("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1568208083113&di=4edf00c518d57234db9f385b936d13cf&imgtype=0&src=http%3A%2F%2Ft7.baidu.com%2Fit%2Fu%3D2255952963%2C1761374034%26fm%3D191%26app%3D48%26wm%3D1%2C13%2C90%2C45%2C0%2C7%26wmo%3D10%2C10%26n%3D0%26g%3D0n%26f%3DJPEG%3Fsec%3D1853310920%26t%3Dc5d2925a294251bd1f2686675395ebdd", "img3.jpg");

        //启动三个线程
        new Thread(td1).start();
        new Thread(td2).start();
        new Thread(td3).start();
    }
}
