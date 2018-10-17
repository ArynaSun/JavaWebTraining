package action;

import entity.Ball;
import entity.Point;
import exception.ValidationException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CorrelatorVolumeTest extends Assert {

    private CorrelatorVolume correlator;

    @BeforeTest
    public void init() {
        correlator = new CorrelatorVolume();
    }

    @Test
    public void correlateSegmentVolumeTest() throws ValidationException {
        Ball ball = new Ball(id, 5, new Point(0, 0, 0));

        double expectedCorrelation = 1;

        double actualCorrelationXoy = correlator.correlateSegmentVolumeXoy(ball);
        double actualCorrelationXoz = correlator.correlateSegmentVolumeXoz(ball);
        double actualCorrelationYoz = correlator.correlateSegmentVolumeYoz(ball);

        assertEquals(expectedCorrelation, actualCorrelationXoy);
        assertEquals(expectedCorrelation, actualCorrelationXoz);
        assertEquals(expectedCorrelation, actualCorrelationYoz);
    }

}
