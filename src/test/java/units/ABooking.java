package units;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ABooking {
   @Test
   void passesAllValidationsToTheValidator() {
      var booking = new Booking("", 21, null, null);
      final var passedInValidations = new ArrayList<>();
      final var returnedResults = List.of("a");

      var results = booking.validate(new Validator() {
         @Override
         public List<String> validate(List<Validation> validations) {
            passedInValidations.addAll(validations);
            return returnedResults;
         }
      });

      assertEquals(returnedResults, results);
   }
   
   @Nested
   class AllTheThings {
      @Test
      void x() {
         
      }
      
   }
}
