package units.validations;

import org.junit.jupiter.api.Test;
import units.Booking;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.*;

public class AFutureDate {
   @Test
   void isInvalidWhenDepartureDateAtOrBeforeNow() {
      var booking = new Booking("", 0, LocalDateTime.now(), null);

      var isInvalid = new FutureDate(booking).isInvalid();

      assertTrue(isInvalid);
   }

   @Test
   void isNotInvalidWhenDepartureDateAfterNow() {
      var futureTime = LocalDateTime.now().plus(1, SECONDS);
      var booking = new Booking("", 0, futureTime, null);

      var isInvalid = new FutureDate(booking).isInvalid();

      assertFalse(isInvalid);
   }
}
