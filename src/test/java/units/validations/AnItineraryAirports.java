package units.validations;

import org.junit.jupiter.api.Test;
import units.Booking;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnItineraryAirports {
   @Test
   void isInvalidWithAnyInvalidAirportCode() {
      var booking = new Booking("", 21, null, List.of("DUB", "XXX"));

      var isInvalid = new ItineraryAirports(booking).isInvalid();

      assertTrue(isInvalid);
   }

   @Test
   void isNotInvalidWhenAllAirportCodesValid() {
      var booking = new Booking("", 21, null, List.of("COS", "DEN"));

      var isInvalid = new ItineraryAirports(booking).isInvalid();

      assertFalse(isInvalid);
   }
}
