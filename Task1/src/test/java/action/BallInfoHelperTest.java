package action;

import entity.Ball;
import entity.Point;
import exception.ValidationException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BallInfoHelperTest extends Assert {

    private BallInfoHelper helper;

    @BeforeTest
    public void init() {
        helper = new BallInfoHelper();
    }

    @Test
    public void isBallTest() {
        Ball ball = new Ball(id);

        boolean isBall = helper.isBall(ball);

        assertTrue(isBall);
    }

    @Test
    public void isTangentXoyTest() throws ValidationException {
        Ball ball = new Ball(id, 5, new Point(0, 0, 5));

        boolean isTangent = helper.isTangentXoy(ball);

        assertTrue(isTangent);
    }

    @Test
    public void isTangentXozTest() throws ValidationException {
        Ball ball = new Ball(id, 5, new Point(0, 5, 0));

        boolean isTangent = helper.isTangentXoz(ball);

        assertTrue(isTangent);
    }

    @Test
    public void isTangentYozTest() throws ValidationException {
        Ball ball = new Ball(id, 5, new Point(5, 0, 0));

        boolean isTangent = helper.isTangentYoz(ball);

        assertTrue(isTangent);
    }
}
