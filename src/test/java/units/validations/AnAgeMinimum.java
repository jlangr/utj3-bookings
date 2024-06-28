package units.validations;

import org.junit.jupiter.api.Test;
import units.Booking;
import static org.junit.jupiter.api.Assertions.*;

public class AnAgeMinimum {
   @Test
   void isInvalidWhenAgeBelow18() {
      var booking = new Booking("", 17, null, null);

      var isInvalid = new AgeMinimum(booking).isInvalid();

      assertTrue(isInvalid);
   }

   @Test
   void isNotInvalidWhenAgeAtLeast18() {
      var booking = new Booking("", 18, null, null);

      var isInvalid = new AgeMinimum(booking).isInvalid();

      assertFalse(isInvalid);
   }
}
