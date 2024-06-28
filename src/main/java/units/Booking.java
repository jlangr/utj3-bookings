package units;

import units.validations.*;
import java.time.LocalDateTime;
import java.util.List;
import static java.util.Arrays.asList;

public record Booking(
        String name,
        int age,
        LocalDateTime departureDate,
        List<String> itinerary) {

   // START:validate
   public List<String> validate(Validator validator) {
      return validator.validate(validations());
   }

   List<Validation> validations() {
      return asList(
              new NameRequired(this),
              new AgeMinimum(this),
              new FutureDate(this),
              new ItinerarySize(this),
              new ItineraryAirports(this));
   }
   // END:validate
}
