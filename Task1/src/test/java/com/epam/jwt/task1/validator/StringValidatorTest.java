package com.epam.jwt.task1.validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringValidatorTest extends Assert {

    @Test
    public void validateTest() {
        String line = "5.3 2525.2 2.3 2.3";

        boolean actual = StringValidator.validate(line);

        assertTrue(actual);

    }
}
