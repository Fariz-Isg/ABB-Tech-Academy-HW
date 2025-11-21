package HW11;

import java.time.Duration;
import java.time.LocalDateTime;

public class main {
    static void main() throws InterruptedException {
        LocalDateTime startTime = LocalDateTime.now();

        Pizza[] pizzas = new Pizza[5];

        for (int i = 0; i < pizzas.length; i++) {
            pizzas[i] = new Pizza();
            pizzas[i].start();
        }

        try {
            for (Pizza pizza : pizzas) {
                pizza.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Duration duration = Duration.between(startTime, LocalDateTime.now());
        int totalTime = (int) duration.toSeconds();

        System.out.println("=======================================");
        System.out.println("All orders completed!");
        System.out.println("Total simulation time: " + totalTime + " seconds");
        System.out.println("Fastest order: " + Pizza.getFastest());
        System.out.println("=======================================");
    }


}
