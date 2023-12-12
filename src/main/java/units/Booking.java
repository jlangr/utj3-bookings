package units;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public record Booking(
        String name, int age, LocalDateTime departureDate, List<String> itinerary) {
   private static final Set<String> AIRPORT_CODES = Set.of(
      "COS", "DEN", "DUB", "PRG");

   public List<String> validate() {
      var errorMessages = new ArrayList<String>();
      if (name == null || name.trim().isEmpty())
         errorMessages.add("Name is empty");
      if (age < 18)
         errorMessages.add("Minor cannot fly unaccompanied");
      if (!departureDate.isAfter(LocalDateTime.now()))
         errorMessages.add("Too late!");
      if (itinerary.size() < 2)
         errorMessages.add("Itinerary needs 2+ segments");
      if (!itinerary.stream().allMatch(
              airportCode -> AIRPORT_CODES.contains(airportCode)))
         errorMessages.add("Itinerary contains invalid airport");
      return errorMessages;
   }
}
