package units;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ABooking {
   Booking booking;

   static final int VALID_AGE = 18;
   static final LocalDateTime VALID_DEPARTURE_DATE =
      LocalDateTime.now().plus(1, DAYS);
   static final String INVALID_AIRPORT_CODE = "YYZ";
   static final String VALID_AIRPORT_CODE1 = "COS";
   static final String VALID_AIRPORT_CODE2 = "PRG";
   static final List<String> VALID_ITINERARY = List.of(VALID_AIRPORT_CODE1, VALID_AIRPORT_CODE2);
   static final String VALID_NAME = "Aslan";

   @Nested
   class validateReturnsNoErrorMessageWhen {
      @Test
      void allFieldsAreValid() {
         var booking = new Booking(VALID_NAME, VALID_AGE, VALID_DEPARTURE_DATE, VALID_ITINERARY);

         var results = booking.validate();

         assertTrue(results.isEmpty());
      }
   }

   @Nested
   class validateReturnsErrorMessageWhen {
      @Test
      void nameIsNull() {
         String name = null;
         var booking = new Booking(name, VALID_AGE, VALID_DEPARTURE_DATE, VALID_ITINERARY);

         var results = booking.validate();

         assertEquals(List.of("Name is empty"), results);
      }

      @Test
      void nameIsEmpty() {
         String name = " ";
         var booking = new Booking(name, VALID_AGE, VALID_DEPARTURE_DATE, VALID_ITINERARY);

         var results = booking.validate();

         assertEquals(List.of("Name is empty"), results);
      }

      @Test
      void departureDateBeforeNow() {
         var pastDateTime = LocalDateTime.now().minus(1, SECONDS);
         var booking = new Booking(VALID_NAME, VALID_AGE, pastDateTime, VALID_ITINERARY);

         var results = booking.validate();

         assertEquals(List.of("Too late!"), results);
      }

      @Test
      void ageTooYoung() {
         var minorAge = 17;
         var booking = new Booking(VALID_NAME, minorAge, VALID_DEPARTURE_DATE, VALID_ITINERARY);

         var results = booking.validate();

         assertEquals(List.of("Minor cannot fly unaccompanied"), results);
      }

      @Test
      void itineraryTooShort() {
         var incompleteItinerary = List.of("COS");
         var booking = new Booking(VALID_NAME, VALID_AGE, VALID_DEPARTURE_DATE, incompleteItinerary);

         var results = booking.validate();

         assertEquals(List.of("Itinerary needs 2+ segments"), results);
      }

      @Test
      void itineraryContainsInvalidSegment() {
         var invalidAirportInItinerary = List.of(VALID_AIRPORT_CODE1, INVALID_AIRPORT_CODE);
         System.out.println(invalidAirportInItinerary);
         var booking = new Booking(VALID_NAME, VALID_AGE, VALID_DEPARTURE_DATE, invalidAirportInItinerary);

         var results = booking.validate();

         assertEquals(List.of("Itinerary contains invalid airport"), results);
      }
   }
}
