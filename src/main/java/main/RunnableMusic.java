package main;

import entities.Good;
import entities.Status;
import store.MusicStoreFactory;
import store.StoreInterace;

import java.util.List;
import java.util.stream.IntStream;

public class RunnableMusic implements Runnable {
    @Override
    public void run() {
        StoreInterace music = new MusicStoreFactory().buildStore();

        //add 3-4 goods per category
        music.addGoodToCategory("instruments", "horn", 50, Status.AVAILABLE);
        music.addGoodToCategory("instruments", "tambourine", 10, Status.AVAILABLE);
        music.addGoodToCategory("instruments", "triangle", 50, Status.AVAILABLE);
        music.addGoodToCategory("instruments", "violin", 10, Status.AVAILABLE);
        music.addGoodToCategory("headphones", "coss", 40, Status.AVAILABLE);
        music.addGoodToCategory("headphones", "beats", 200, Status.AVAILABLE);
        music.addGoodToCategory("headphones", "panasonic", 40, Status.AVAILABLE);
        music.addGoodToCategory("headphones", "sony", 200, Status.AVAILABLE);

        // in some category change statuses to «Absent»
        List<Good> absentGood = music.getGoodsByCategory("instruments");
        absentGood.stream().forEach(a ->{
            a.setStatus(Status.ABSENT);
            music.save(a);
        });

        //половине товаров,
// из оставшихся категорий, изменить статус на «Expected»
        List<Good> good = music.getGoodsByCategory("headphones");

        IntStream.range(0, good.size()/2).forEach(i -> {
            good.get(i).setStatus(Status.EXPECTED);
            music.save(good.get(i));
        });
        // • По товарам, что доступны увеличить цену на 20%;
        music.increasePriceForAvailableGoods();

        System.out.println("Music Store Fulllfilled!!!");

    }
}
