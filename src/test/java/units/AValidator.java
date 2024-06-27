package units;

// START:test
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AValidator {
   Validation passingValidation = new Validation() {
      @Override public boolean isInvalid() { return false; }
      @Override public String errorMessage() { return ""; }
   };

   Validation failingValidation = new Validation() {
      @Override public boolean isInvalid() { return true; }
      @Override public String errorMessage() { return "fail"; }
   };

   @Test
   void returnsEmptyListWhenAllValidationsPass() {
      assertEquals(Collections.emptyList(),
         new Validator().validate(List.of(passingValidation)));
   }

   @Test
   void returnsListOfFailingValidationMessages() {
      assertEquals(List.of(failingValidation.errorMessage()),
         new Validator().validate(List.of(
            failingValidation,
            passingValidation)));
   }
}
// END:test
