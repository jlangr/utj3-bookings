package units.validations;

import units.Booking;
import units.Validation;

import static java.time.LocalDateTime.now;

public class FutureDate implements Validation {
   private final Booking booking;

   public FutureDate(Booking booking) {
      this.booking = booking;
   }

   @Override
   public boolean isInvalid() {
      return !booking.departureDate().isAfter(now());
   }

   @Override
   public String errorMessage() {
      return "Too late!";
   }
}
