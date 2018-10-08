package validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidatorTest extends Assert {

    @Test
    public void validateTest() {
        String line = "5.3 2525.2 2.3 2.3";

        boolean actual = Validator.validate(line);

        assertTrue(actual);

    }
}
