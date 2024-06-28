package units.validations;

import units.Booking;
import units.Validation;

public class AgeMinimum implements Validation {
   private final Booking booking;

   public AgeMinimum(Booking booking) {
      this.booking = booking;
   }

   @Override
   public boolean isInvalid() {
      return booking.age() < 18;
   }

   @Override
   public String errorMessage() {
      return "Minor cannot fly unaccompanied";
   }
}
