package HW12.Task12;

public class Main {
    static void main() {
        NewsPublisher publisher = new NewsPublisher();

        Subscriber subscriber1 = new Subscriber("Subscriber-1", publisher);
        Subscriber subscriber2 = new Subscriber("Subscriber-2", publisher);
        Subscriber subscriber3 = new Subscriber("Subscriber-3", publisher);

        publisher.addSubscriber(subscriber1);
        publisher.addSubscriber(subscriber2);
        publisher.addSubscriber(subscriber3);

        Thread t1 = new Thread(subscriber1);
        Thread t2 = new Thread(subscriber2);
        Thread t3 = new Thread(subscriber3);

        t1.start();
        t2.start();
        t3.start();

        int newsCounter = 1;
        while (true) {
            try {
                Thread.sleep(2000); // 2 saniyə gözlə
                publisher.publishNews("Xəbər #" + newsCounter);
                newsCounter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}