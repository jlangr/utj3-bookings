// START:zero
package units;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static units.StringUtils.capitalize;

public class StringUtilsTest {
   @Nested
   class Capitalize {
      @Test
      void returnsEmptyStringWhenEmpty() {
         assertEquals("", capitalize(""));
      }
      // END:zero

      // START:one
      @Test
      void returnsUppercasedLetterWhenSingleLetter() {
         assertEquals("A", capitalize("a"));
      }
      // END:one

      // START:many
      @Test
      void returnsCamelCasedWord() {
         assertEquals("Alpha", capitalize("alpha"));
      }
      // END:many
      // START:zero
   }
}
// END:zero
