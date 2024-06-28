package units.validations;

import units.Booking;
import units.Validation;
import java.util.Set;

public class ItineraryAirports implements Validation {
   private static final Set<String> AIRPORT_CODES = Set.of(
      "COS", "DEN", "DUB", "PRG");
   private final Booking booking;

   public ItineraryAirports(Booking booking) {
      this.booking = booking;
   }

   @Override
   public boolean isInvalid() {
      return !booking.itinerary().stream().allMatch(
         airportCode -> AIRPORT_CODES.contains(airportCode));
   }

   @Override
   public String errorMessage() {
      return "Itinerary contains invalid airport code";
   }
}
