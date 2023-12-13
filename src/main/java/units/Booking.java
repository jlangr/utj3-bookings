package units;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public record Booking(
        String name,
        int age,
        LocalDateTime departureDate,
        List<String> itinerary) {
   private static final Set<String> AIRPORT_CODES = Set.of(
      "COS", "DEN", "DUB", "PRG");

   interface Validation {
      boolean isInvalid();
      String errorMessage();
   }

   class NameRequired implements Validation {
      @Override
      public boolean isInvalid() {
         return name == null || name.trim().isEmpty();
      }

      @Override
      public String errorMessage() {
         return "Name is empty";
      }
   }

   // START:AgeMinimum
   class AgeMinimum implements Validation {
      @Override
      public boolean isInvalid() {
         return age < 18;
      }

      @Override
      public String errorMessage() {
         return "Minor cannot fly unaccompanied";
      }
   }
   // END:AgeMinimum

   class FutureDate implements Validation {
      @Override
      public boolean isInvalid() {
         return !departureDate.isAfter(LocalDateTime.now());
      }

      @Override
      public String errorMessage() {
         return "Too late!";
      }
   }

   class ItinerarySize implements Validation {
      @Override
      public boolean isInvalid() {
         return itinerary.size() < 2;
      }

      @Override
      public String errorMessage() {
         return "Itinerary needs 2+ segments";
      }
   }

   class ItineraryAirports implements Validation {
      @Override
      public boolean isInvalid() {
         return !itinerary.stream().allMatch(
                 airportCode -> AIRPORT_CODES.contains(airportCode));
      }

      @Override
      public String errorMessage() {
         return "Itinerary contains invalid airport";
      }
   }

   // START:validate
   public List<String> validate() {
      return asList(
         new NameRequired(),
         new AgeMinimum(),
         new FutureDate(),
         new ItinerarySize(),
         new ItineraryAirports()).stream()
            .filter(Validation::isInvalid)
            .map(Validation::errorMessage)
            .collect(toList());
   }
   // END:validate
}
