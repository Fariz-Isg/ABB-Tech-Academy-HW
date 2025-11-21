package HW12.Task12;

import java.util.ArrayList;
import java.util.List;

public class NewsPublisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String latestNews;
    private boolean hasNews = false;

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public synchronized void publishNews(String news) {
        this.latestNews = news;
        this.hasNews = true;
        System.out.println("Publisher: Yeni xəbər yayımlandı -> " + news);
        notifyAll();
    }

    public synchronized String waitForNews() throws InterruptedException {
        while (!hasNews) {
            wait();
        }
        hasNews = false;
        return latestNews;
    }
}
