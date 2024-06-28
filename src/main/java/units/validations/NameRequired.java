package units.validations;

import units.Booking;
import units.Validation;

public class NameRequired implements Validation {
   private final Booking booking;

   public NameRequired(Booking booking) {
      this.booking = booking;
   }

   @Override
   public boolean isInvalid() {
      return booking.name() == null || booking.name().trim().isEmpty();
   }

   @Override
   public String errorMessage() {
      return "Name is empty";
   }
}
