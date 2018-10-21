package com.epam.jwt.task1.action;

import com.epam.jwt.task1.action.impl.CorrelatorVolumeImpl;
import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.entity.Point;
import com.epam.jwt.task1.exception.ValidationException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CorrelatorVolumeTest extends Assert {

    private CorrelatorVolume correlator;

    @BeforeTest
    public void init() {
        correlator = CorrelatorVolumeImpl.getCorrelatorVolume();
    }

    @Test
    public void correlateSegmentVolumeTest() throws ValidationException {
        Ball ball = new Ball(0, 5, new Point(0, 0, 0));

        double expectedCorrelation = 1;

        double actualCorrelationXoy = correlator.correlateSegmentVolumeXoy(ball);
        double actualCorrelationXoz = correlator.correlateSegmentVolumeXoz(ball);
        double actualCorrelationYoz = correlator.correlateSegmentVolumeYoz(ball);

        assertEquals(expectedCorrelation, actualCorrelationXoy);
        assertEquals(expectedCorrelation, actualCorrelationXoz);
        assertEquals(expectedCorrelation, actualCorrelationYoz);
    }

}
