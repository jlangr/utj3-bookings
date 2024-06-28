package units.validations;

import org.junit.jupiter.api.Test;
import units.Booking;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnItinerarySize {
   @Test
   void isInvalidWhenItineraryHasFewerThanTwoAirportCodes() {
      var booking = new Booking("", 0, null, List.of("COS"));

      var isInvalid = new ItinerarySize(booking).isInvalid();

      assertTrue(isInvalid);
   }

   @Test
   void isNotInvalidWhenItineraryHasAtLeastTwoAirportCodes() {
      var booking = new Booking("", 0, null, List.of("COS", "DUB"));

      var isInvalid = new ItinerarySize(booking).isInvalid();

      assertFalse(isInvalid);
   }
}
