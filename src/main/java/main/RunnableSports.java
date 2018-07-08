package main;

import entities.Good;
import entities.Status;
import store.SportStoreFactory;
import store.StoreInterace;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class RunnableSports implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);

            StoreInterace sports = new SportStoreFactory().buildStore();
            sports.addGoodToCategory("inventory", "swimsuit", 500, Status.AVAILABLE);
            sports.addGoodToCategory("inventory", "t-short", 150, Status.AVAILABLE);
            sports.addGoodToCategory("inventory", "ball", 50, Status.AVAILABLE);
            sports.addGoodToCategory("inventory", "gi", 150, Status.AVAILABLE);
            sports.addGoodToCategory("supplies", "bandages", 40, Status.AVAILABLE);
            sports.addGoodToCategory("supplies", "weighters", 100, Status.AVAILABLE);
            sports.addGoodToCategory("supplies", "kettlebell", 40, Status.AVAILABLE);
            sports.addGoodToCategory("supplies", "dumbell", 100, Status.AVAILABLE);

            List<Good> absentGood = sports.getGoodsByCategory("inventory");
            absentGood.stream().forEach(a -> {
                a.setStatus(Status.ABSENT);
                sports.save(a);
            });

            List<Good> good = sports.getGoodsByCategory("supplies");

            IntStream.range(0, good.size() / 2).forEach(i -> {
                good.get(i).setStatus(Status.EXPECTED);
                sports.save(good.get(i));
            });
            sports.increasePriceForAvailableGoods();

            System.out.println("Sports Store Fulllfilled!!!");



        }catch(InterruptedException e){
            e.printStackTrace();;
        }

    }
}
