import java.time.*;
import java.time.chrono.*;
import java.util.Set;

/**
 * Enumerate the list of available calendars and print todays date for each.
 */
class ChronologyTest {
  public static void main(String[] args) {
    Set<Chronology> chronos = Chronology.getAvailableChronologies();
    for (Chronology chrono : chronos) {
       ChronoLocalDate date = chrono.dateNow();
       System.out.printf("   %20s: %s%n", chrono.getId(), date.toString());
    }
  }
}
