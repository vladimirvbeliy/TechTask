package store;

import DAO.DAOUtills;
import entities.Good;
import entities.Status;

import java.util.List;

public class SportsStore implements StoreInterace {

    private static final String STORE_NAME = "sports_store";

    private static SportsStore ourInstance = new SportsStore();


    public static SportsStore getInstance() {
        return ourInstance;
    }

    private SportsStore() {
    }

    @Override
    public List<Good> getGoodsByCategory(String catName) {
        return DAOUtills.getGoodsByCategory(SportsStore.STORE_NAME, catName);
    }

    @Override
    public void increasePriceForAvailableGoods() {
        List<Good> availableGoods = DAOUtills.getGoodsByStatus(SportsStore.STORE_NAME, Status.AVAILABLE);
        availableGoods.stream().forEach(g -> {
            g.setPrice(g.getPrice()*1.2);
            DAOUtills.save(g);
        });
    }

    @Override
    public void addGoodToCategory(String category, String goodTitle, double goodPrice, Status status) {
        DAOUtills.saveGoodToCategory(SportsStore.STORE_NAME, category, goodTitle, goodPrice, status);

    }

}
