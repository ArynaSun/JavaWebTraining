package com.epam.jwt.task1.repository.impl;

import com.epam.jwt.task1.comparator.BallComparator;
import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.exception.DataReaderException;
import com.epam.jwt.task1.repository.BallRepository;
import com.epam.jwt.task1.repository.parser.StringParser;
import com.epam.jwt.task1.repository.reader.Impl.DataReaderImpl;
import com.epam.jwt.task1.specification.BallSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BallRepositoryImpl implements BallRepository {

    private List<Ball> ballList;
    private BallComparator comparator;

    public BallRepositoryImpl(String fileName) throws DataReaderException {
        DataReaderImpl dataReader = new DataReaderImpl(fileName);
        List<String> lines = dataReader.readData();
        ballList = StringParser.parseBall(lines);
    }

    public void setComparator(BallComparator comparator) {
        this.comparator = comparator;
    }

    public BallComparator getComparator() {
        return comparator;
    }

    @Override
    public void create(Ball ball) {
        ballList.add(ball);
    }

    @Override
    public void update(Ball ball) {
        delete(ball);
        create(ball);
    }

    @Override
    public void delete(Ball ball) {
        ballList.remove(ball);
    }

    @Override
    public List<Ball> findBy(BallSpecification ballSpecification) {
        List<Ball> isFitBySpecBallList = new ArrayList<>();
        for (Ball ball : ballList) {
            if (ballSpecification.isFit(ball)) {
                isFitBySpecBallList.add(ball);
            }
        }
        sort(isFitBySpecBallList);
        return isFitBySpecBallList;
    }

    private void sort(List<Ball> isFitBySpecBallList) {

        for (int i = 0; i < isFitBySpecBallList.size(); i++) {
            for (int j = 0; j < isFitBySpecBallList.size() - i - 1; j++) {
                if (comparator.compare(isFitBySpecBallList.get(j), isFitBySpecBallList.get(j + 1)) > 0) {
                    Ball temp = isFitBySpecBallList.get(j + 1);
                    isFitBySpecBallList.set(j + 1, isFitBySpecBallList.get(j));
                    isFitBySpecBallList.set(j, temp);
                }
            }

        }
    }
}
