package units.validations;

import units.Booking;
import units.Validation;

public class ItinerarySize implements Validation {
   private final Booking booking;

   public ItinerarySize(Booking booking) {
      this.booking = booking;
   }

   @Override
   public boolean isInvalid() {
      return booking.itinerary().size() < 2;
   }

   @Override
   public String errorMessage() {
      return "Itinerary needs 2+ airport codes";
   }
}
