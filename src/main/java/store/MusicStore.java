package store;


import DAO.DAOUtills;
import entities.Good;
import entities.Status;

import java.util.List;


public class MusicStore implements StoreInterace {

    private static final String STORE_NAME = "music_store";

    private static MusicStore ourInstance = new MusicStore();


    public static MusicStore getInstance() {
        return ourInstance;
    }

    private MusicStore() {
    }

    @Override
    public List<Good> getGoodsByCategory(String catName) {
        return DAOUtills.getGoodsByCategory(MusicStore.STORE_NAME, catName);
    }

    @Override
    public void increasePriceForAvailableGoods() {
        List<Good> availableGoods = DAOUtills.getGoodsByStatus(MusicStore.STORE_NAME, Status.AVAILABLE);
        availableGoods.stream().forEach(g -> {
            g.setPrice(g.getPrice()*1.2);
            DAOUtills.save(g);
        });
    }

    @Override
    public void addGoodToCategory(String category, String goodTitle, double goodPrice, Status status){
        DAOUtills.saveGoodToCategory(MusicStore.STORE_NAME, category, goodTitle, goodPrice, status);
    }

}
