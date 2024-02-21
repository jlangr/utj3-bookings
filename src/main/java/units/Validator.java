package units;

// START:Validator
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Validator {
    public List<String> validate(List<Validation> validations) {
       return validations.stream()
               .filter(Validation::isInvalid)
               .map(Validation::errorMessage)
               .collect(toList());
    }
}
// END:Validator
