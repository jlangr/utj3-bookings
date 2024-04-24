package units;

// START:Validator
import java.util.List;

public class Validator {
    public List<String> validate(List<Validation> validations) {
       return validations.stream()
               .filter(Validation::isInvalid)
               .map(Validation::errorMessage)
               .toList();
    }
}
// END:Validator
