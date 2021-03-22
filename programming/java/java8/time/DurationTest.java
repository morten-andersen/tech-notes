import java.time.*;

/**
 * Measuring the duration of an operation
 */
class DurationTest {
  public static void main(String[] args) {
    Instant start = Instant.now();
    // do something
    for (int i = 0; i < 1_000_000; i++) {
      // noop
    }
    Duration elapsed = Duration.between(start, Instant.now());
    System.out.println("Elapsed time " + elapsed.toMillis() + " ms");
  }
}
