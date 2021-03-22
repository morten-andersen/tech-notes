import java.time.*;
import static java.time.temporal.TemporalAdjusters.*;

class TemporalTest {
  public static void main(String[] args) {
    LocalDate now = LocalDate.now();
    // using TemporalAdjuster
    LocalDate nextTuesday = now.with(next(DayOfWeek.TUESDAY));
    System.out.println("Next Tuesday " + nextTuesday);
    LocalDate lastInMonth = now.with(lastDayOfMonth());
    System.out.println("Last day in this month " + lastInMonth);
  }
}
