package com.epam.jwt.task1.entity;

import com.epam.jwt.task1.action.impl.BallInfoHelperImpl;
import com.epam.jwt.task1.action.impl.CorrelatorVolumeImpl;
import com.epam.jwt.task1.action.impl.SquareCalculatorImpl;
import com.epam.jwt.task1.action.impl.VolumeCalculatorImpl;
import com.epam.jwt.task1.exception.ValidationException;

public class RegisterBall implements Observer {

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

        BallInfoHelperImpl ballInfoHelper = BallInfoHelperImpl.getBallInfoHelper();
        CorrelatorVolumeImpl correlatorVolume = CorrelatorVolumeImpl.getCorrelatorVolume();
        SquareCalculatorImpl squareCalculator = SquareCalculatorImpl.getSquareCalculator();
        VolumeCalculatorImpl volumeCalculator = VolumeCalculatorImpl.getVolumeCalculator();

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

    @Override
    public boolean equals(Object obj) {
        if (this == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        RegisterBall object = (RegisterBall) obj;

        if (object.isBall != this.isBall) {
            return false;
        }
        if (object.isTangentXoy != this.isTangentXoy) {
            return false;
        }
        if (object.isTangentXoz != this.isTangentXoz) {
            return false;
        }
        if (object.isTangentYoz != this.isTangentYoz) {
            return false;
        }
        if (object.segmentVolumeXoy != this.segmentVolumeXoy) {
            return false;
        }
        if (object.segmentVolumeXoz != this.segmentVolumeXoz) {
            return false;
        }
        if (object.segmentVolumeYoz != this.segmentVolumeYoz) {
            return false;
        }
        if (object.ballSquare != this.ballSquare) {
            return false;
        }
        if (object.ballVolume != this.ballVolume) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 5;

        hash = 37 * hash + (this.isBall ? 5 : 0);
        hash = 37 * hash + (this.isTangentXoy ? 13 : 0);
        hash = 37 * hash + (this.isTangentYoz ? 7 : 0);
        hash = 37 * hash + (this.isTangentXoz ? 11 : 0);

        hash = 13 * hash + (int) this.segmentVolumeXoy;
        hash = 13 * hash + (int) this.segmentVolumeXoz;
        hash = 13 * hash + (int) this.segmentVolumeYoz;

        hash = 17 * hash + (int) (this.ballSquare);
        hash = 17 * hash + (int) (this.ballVolume);

        return hash;
    }
}
