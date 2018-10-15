package entity;

import action.BallInfoHelper;
import exception.ValidationException;

public class RegisterBall {

    private Ball ball;

    private boolean isBall;
    private boolean isTangentXoy;
    private boolean isTangentXoz;
    private boolean isTangentYoz;

    private double segmentVolumeXoy;
    private double segmentVolumeXoz;
    private double segmentVolumeYoz;

    private double ballSquare;

    private double segmentVolume;
    private double ballVolume;

    public void setBall(Ball ball) throws ValidationException {
        this.ball = ball;
        update();
    }

    private void update() throws ValidationException {
        BallInfoHelper ballInfoHelper = BallInfoHelper.getBallInfoHelper();
        isBall = ballInfoHelper.isBall(ball);
        isTangentXoy = ballInfoHelper.isTangentXoy(ball);
        isTangentXoz = ballInfoHelper.isTangentXoz(ball);
        isTangentYoz = ballInfoHelper.isTangentYoz(ball);
    }

    public Ball getBall() {
        return ball;
    }

    public boolean isBall() {
        return isBall;
    }

    public boolean isTangentXoy() {
        return isTangentXoy;
    }

    public boolean isTangentXoz() {
        return isTangentXoz;
    }

    public boolean isTangentYoz() {
        return isTangentYoz;
    }

    public double getSegmentVolumeXoy() {
        return segmentVolumeXoy;
    }

    public double getSegmentVolumeXoz() {
        return segmentVolumeXoz;
    }

    public double getSegmentVolumeYoz() {
        return segmentVolumeYoz;
    }

    public double getBallSquare() {
        return ballSquare;
    }

    public double getSegmentVolume() {
        return segmentVolume;
    }

    public double getBallVolume() {
        return ballVolume;
    }
}
