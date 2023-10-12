package units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static units.Location.Heading.*;

class LocationTest {
   @Test
   void moveEastIncreasesX() {
      var point = new Location(2, 3, East);
      point.move(3);
      assertEquals(new Location(5, 3, East), point);
   }

   @Test
   void moveSouthDecreasesY() {
      var point = new Location(2, 3, South);
      point.move(5);
      assertEquals(new Location(2, -2, South), point);
   }

   @Test
   void moveWestDecreasesX() {
      var point = new Location(1, 3, West);
      point.move(5);
      assertEquals(new Location(-4, 3, West), point);
   }

   @Test
   void moveNorthIncreasesY() {
      var point = new Location(1, -2, North);
      point.move(8);
      assertEquals(new Location(1, 6, North), point);
   }
}