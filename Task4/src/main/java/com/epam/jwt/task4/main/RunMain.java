package com.epam.jwt.task4.main;

import com.epam.jwt.task4.entitty.Car;
import com.epam.jwt.task4.entitty.Truck;

import java.util.Random;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class RunMain {
    private static final int TIMEOUT = 1;

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                while (true) {
                    try {
                        if (random.nextInt() % 2 == 0) {
                            new Thread(new FutureTask<>(new Car())).start();
                        } else {
                            new Thread(new FutureTask<>(new Truck())).start();
                        }
                        TimeUnit.SECONDS.sleep(TIMEOUT);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
