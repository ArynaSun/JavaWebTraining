package com.epam.jwt.task1.repository.parser;

import com.epam.jwt.task1.entity.Ball;
import com.epam.jwt.task1.entity.Point;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StringParserTest extends Assert {

    @DataProvider(name = "dataProvider")
    public Object[][] provideData() {
        List<String> lines = new ArrayList<>();
        lines.add("5.0 8.0 6.5 8.1 0.0");
        lines.add("-15.0 0.2 0.3 0.5 0.0");
        lines.add("15.0 0.f2 0.3 0.5 0.0");
        lines.add("1.0 0.2 0.3 0.0");
        lines.add("15.0 0.2 0.3 0.9595 0.0");
        ArrayList<Ball> balls = new ArrayList<>();
        balls.add(new Ball(0, 5.0, new Point(8.0, 6.5, 8.1)));
        balls.add(new Ball(0, 15.0, new Point(0.2, 0.3, 0.9595)));
        return new Object[][]{
                {lines, balls}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void parseBallTest(List<String> lines, List<Ball> expectedBalls) {
        List<Ball> actualBalls = StringParser.parseBall(lines);

        assertEquals(expectedBalls, actualBalls);

    }

}
