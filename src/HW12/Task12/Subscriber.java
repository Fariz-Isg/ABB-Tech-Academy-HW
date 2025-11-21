package HW12.Task12;

public class Subscriber implements Runnable {
    private String name;
    private NewsPublisher publisher;

    public Subscriber(String name, NewsPublisher publisher) {
        this.name = name;
        this.publisher = publisher;
    }

    public void update(String news) {
        System.out.println(name + " xəbər aldı: " + news);
    }

    @Override
    public void run() {
        while (true) {
            try {
                String news = publisher.waitForNews();
                update(news);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
