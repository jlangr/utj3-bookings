package units.validations;

import org.junit.jupiter.api.Test;
import units.Booking;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ANameRequired {
   @Test
   void isInvalidWhenNameNotProvided() {
      var booking = new Booking(" ", 0, null, null);

      var isInvalid = new NameRequired(booking).isInvalid();

      assertTrue(isInvalid);
   }

   @Test
   void isInvalidWhenNameIsNull() {
      var booking = new Booking(null, 0, null, null);

      var isInvalid = new NameRequired(booking).isInvalid();

      assertTrue(isInvalid);
   }

   @Test
   void isNotInvalidWhenNameProvided() {
      var booking = new Booking("Sidonia", 0, null, null);

      var isInvalid = new NameRequired(booking).isInvalid();

      assertFalse(isInvalid);
   }
}
