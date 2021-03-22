// https://blogs.oracle.com/javamagazine/epsilon-the-jdks-do-nothing-garbage-collector

/**
 * Demo of the no-op epsilon Garbage Collector.
 *
 * Invoke as {@code java -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC EpsilonDemo}
 */
public class EpsilonDemo {

    public static void main(String[] args) {

        final int GIGABYTE = 1024 * 1024 * 1024;
        final int ITERATIONS = 100;

        System.out.println("Starting allocations...");

        // allocate memory 1GB at a time
        for (int i = 0; i < ITERATIONS; i++) {
            var array = new byte[GIGABYTE];
        }

        System.out.println("Completed successfully");
    }
}
