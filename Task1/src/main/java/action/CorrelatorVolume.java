package action;

import entity.Ball;
import exception.ValidationException;
import validator.BallValidator;

public class CorrelatorVolume {

    VolumeCalculator volumeCalculator = new VolumeCalculator();

    public double correlateSegmentVolumeXoy(Ball ball) throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        if (Math.abs(ball.getCenter().getZ()) >= ball.getRadius()) {
            return 0;
        }
        double heightSegment = ball.getCenter().getZ()!= 0? 2 * ball.getRadius() - Math.abs(ball.getCenter().getZ()):ball.getRadius();
        double ballVolume = volumeCalculator.calculateBallVolume(ball);
        double segmentVolume = volumeCalculator.calculateSegmentVolume(ball, heightSegment);
        double remainingVolume = ballVolume - segmentVolume;

        return segmentVolume / remainingVolume;
    }

    public double correlateSegmentVolumeXoz(Ball ball) throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        if (Math.abs(ball.getCenter().getY()) >= ball.getRadius()) {
            return 0;
        }
        double heightSegment = ball.getCenter().getY() !=0 ? 2 * ball.getRadius() - Math.abs(ball.getCenter().getY()):ball.getRadius();
        double ballVolume = volumeCalculator.calculateBallVolume(ball);
        double segmentVolume = volumeCalculator.calculateSegmentVolume(ball, heightSegment);
        double remainingVolume = ballVolume - segmentVolume;
        return segmentVolume / remainingVolume;
    }

    public double correlateSegmentVolumeYoz(Ball ball) throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        if (Math.abs(ball.getCenter().getX()) >= ball.getRadius()) {
            return 0;
        }
        double heightSegment = ball.getCenter().getY()!=0 ? 2 * ball.getRadius() - Math.abs(ball.getCenter().getX()):ball.getRadius();
        double ballVolume = volumeCalculator.calculateBallVolume(ball);
        double segmentVolume = volumeCalculator.calculateSegmentVolume(ball, heightSegment);
        double remainingVolume = ballVolume - segmentVolume;

        return segmentVolume / remainingVolume;
    }
}
