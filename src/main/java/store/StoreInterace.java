package store;

import DAO.DAOUtills;
import entities.Category;
import entities.Good;
import entities.Status;

import java.util.List;

public interface StoreInterace {

    default public List<Good> getGoods() {
        return DAOUtills.getGoods();
    }

    default public Good getGoodById(int goodId) {
        return DAOUtills.getGoodById(goodId);
    }

    default public void setGoodStatus(int goodId, Status status) {
        DAOUtills.setGoodStatus(goodId, status);
    }

    default public void setGoodPrice(int goodId, int price) {
        DAOUtills.setGoodPrice(goodId, price);
    }

    default public void save(Good good){
        DAOUtills.save(good);
    }

    public List<Good> getGoodsByCategory(String catName);

    public void increasePriceForAvailableGoods();

    public void addGoodToCategory(String category, String goodTitle, double goodPrice, Status status);
}
