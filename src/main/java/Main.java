import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // create an executor
        ExecutorService executor = Executors.newSingleThreadExecutor();

        while (scanner.hasNext()) {
            System.out.println("Enter a number to check if it is prime, enter 0 to exit");
            int num = scanner.nextInt();
            executor.submit(new PrimeLogger(num));
            if (num == 0) break;
        }
        executor.shutdown();
    }
}

class PrimeLogger implements Runnable {
    private final int num;

    public PrimeLogger(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        boolean isPrime = num > 1;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) System.out.println(num + " is prime");
    }
}