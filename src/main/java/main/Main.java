package main;

import DAO.DAOUtills;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        RunnableMusic music = new RunnableMusic();
        RunnableSports sports = new RunnableSports();
        executor.execute(music);
        executor.execute(sports);

        executor.shutdown();
        System.out.println("MISSION ACCOMPLISHED");

    }

}
