package entity;

import action.BallInfoHelper;
import action.CorrelatorVolume;
import action.SquareCalculator;
import action.VolumeCalculator;
import exception.ValidationException;

public class RegisterBall implements Observer{

   // private Ball ball;

    private boolean isBall;
    private boolean isTangentXoy;
    private boolean isTangentXoz;
    private boolean isTangentYoz;

    private double segmentVolumeXoy;
    private double segmentVolumeXoz;
    private double segmentVolumeYoz;

    private double ballSquare;

    private double ballVolume;

//    public void setBall(Ball ball) throws ValidationException {
//        this.ball = ball;
//        update();
//    }

    public void update(Ball ball) throws ValidationException {

        BallInfoHelper ballInfoHelper = BallInfoHelper.getBallInfoHelper();
        CorrelatorVolume correlatorVolume = CorrelatorVolume.getCorrelatorVolume();
        SquareCalculator squareCalculator = SquareCalculator.getSquareCalculator();
        VolumeCalculator volumeCalculator = VolumeCalculator.getVolumeCalculator();

        isBall = ballInfoHelper.isBall(ball);

        isTangentXoy = ballInfoHelper.isTangentXoy(ball);
        isTangentXoz = ballInfoHelper.isTangentXoz(ball);
        isTangentYoz = ballInfoHelper.isTangentYoz(ball);

        segmentVolumeXoy = correlatorVolume.correlateSegmentVolumeXoy(ball);
        segmentVolumeXoz = correlatorVolume.correlateSegmentVolumeXoz(ball);
        segmentVolumeYoz = correlatorVolume.correlateSegmentVolumeYoz(ball);

        ballSquare = squareCalculator.calculateBallSquare(ball);

        ballVolume = volumeCalculator.calculateBallVolume(ball);

    }

//    public Ball getBall() {
//        return ball;
//    }

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

    public double getBallVolume() {
        return ballVolume;
    }
}
