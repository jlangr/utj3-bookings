package units;

public record FLocation(int x, int y, FLocation.Heading heading) {
   enum Heading {
      North {
         @Override public FLocation move(FLocation location, int distance) {
            return new FLocation(location.x, location.y + distance, North);
         }
      },
      East {
         @Override public FLocation move(FLocation location, int distance) {
            return new FLocation(location.x + distance, location.y, East);
         }
      },
      South {
         @Override public FLocation move(FLocation location, int distance) {
            return new FLocation(location.x, location.y - distance, South);
         }
      },
      West {
         @Override public FLocation move(FLocation location, int distance) {
            return new FLocation(location.x - distance, location.y, West);
         }
      };
      public abstract FLocation move(FLocation location, int distance);
   }

   FLocation move(int distance) {
      return heading.move(this, distance);
   }
}
