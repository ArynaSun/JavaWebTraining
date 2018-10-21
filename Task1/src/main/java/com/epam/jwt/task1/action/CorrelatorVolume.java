package com.epam.jwt.task1.action;

import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.exception.ValidationException;

public interface CorrelatorVolume {

    double correlateSegmentVolumeXoy(Ball ball) throws ValidationException;

    double correlateSegmentVolumeXoz(Ball ball) throws ValidationException;

    double correlateSegmentVolumeYoz(Ball ball) throws ValidationException;
}
