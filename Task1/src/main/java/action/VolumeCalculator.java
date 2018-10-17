package action;

import entity.Ball;
import exception.ValidationException;
import validator.BallValidator;

public class VolumeCalculator {
    public static final double PI = Math.PI;
    private static VolumeCalculator volumeCalculator;

    public static VolumeCalculator getVolumeCalculator(){
        if(volumeCalculator == null){
            volumeCalculator = new VolumeCalculator();
        }
        return volumeCalculator;
    }

    private VolumeCalculator(){}

    public double calculateBallVolume(Ball ball) throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        double ballVolume;
        ballVolume = (4.0 / 3.0) * PI * Math.pow(ball.getRadius(), 3);
        return ballVolume;
    }

    public double calculateSegmentVolume(Ball ball, double height) throws ValidationException {
        if (!BallValidator.validate(ball)) {
            throw new ValidationException("Radius is negative!");
        }
        double segmentVolume;
        segmentVolume = PI * Math.pow(height, 2) * (ball.getRadius() - (1.0 / 3.0) * height);
        return segmentVolume;
    }
}
