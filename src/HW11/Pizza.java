package HW11;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class Pizza extends Thread {
    private static final Object lock = new Object();
    private final int orderId;
    private final Random rand = new Random();
    private static int counter;
    private static Integer fastestTime = Integer.MAX_VALUE;
    private static String fastest;
    private static int totalTime;

    public Pizza() {
        counter++;
        this.orderId = counter;
    }

    @Override
    public void run() {
        LocalDateTime startTime = LocalDateTime.now();

        try {
            printLog("Started.");
            printLog("Preparing...");
            int preparingTime = 1 + rand.nextInt(3);
            Thread.sleep(preparingTime * 1000);
            printLog("Preparation complete.");

            printLog("Baking pizza...");
            int bakeTime = 3 + rand.nextInt(4);
            Thread.sleep(bakeTime * 1000);
            printLog("Baking complete.");

            printLog("Delivering pizza to customer...");
            int deliveringTime = 2 + rand.nextInt(4);
            Thread.sleep(deliveringTime * 1000);
            printLog("Pizza delivered!");

            Duration duration = Duration.between(startTime, LocalDateTime.now());
            totalTime = (int) duration.getSeconds();
            printLog("Total time: " + totalTime + " seconds\n");

            if (totalTime < fastestTime) {
                fastestTime = totalTime;
                fastest = "Order #" + getName() + " --> " + totalTime + " sec";
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printLog(String message) {
        synchronized (lock) {
            System.out.println("[Order #" + orderId + "] " + message);
        }
    }
    public static String getFastest() {
        return fastest;
    }
}