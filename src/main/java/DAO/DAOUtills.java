package DAO;

import entities.Category;
import entities.Good;
import entities.Status;
import entities.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DAOUtills {

    private static SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Store.class)
            .addAnnotatedClass(Category.class)
            .addAnnotatedClass(Good.class)
            .buildSessionFactory();

    //private constructor: all methods of class DAOUtills are static
    //so no need in creating it's instance
    private DAOUtills(){}

    public static List<Good> getGoods(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Query theQuery = session.createQuery("from Good", Good.class);
        List<Good> goods =theQuery.getResultList();
        session.getTransaction().commit();
        session.close();

        return goods;
    }

    public static Good getGoodById(int id){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Good good = session.get(Good.class, id);
        session.getTransaction().commit();
        session.close();

        return good;
    }


    public static void setGoodStatus(int goodId, Status status){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Good good = session.get(Good.class, goodId);
        good.setStatus(status);
        session.getTransaction().commit();
        session.close();

    }

    public static void setGoodPrice(int goodId, int price){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Good good = session.get(Good.class, goodId);
        good.setPrice(price);
        session.getTransaction().commit();
        session.close();

    }

    public static void save (Good good){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(good);
        session.getTransaction().commit();
        session.close();

    }

    public static List<Good> getGoodsByCategory(String storeName, String categoryName){
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Query<Good> query = session.createQuery("select g from " +
                "Store s inner join s.categories c"+
                " inner join " +
                "c.goods g where s.storeName =:storeName and c.categoryName =:categoryName", Good.class);
        query.setParameter("storeName", storeName);
        query.setParameter("categoryName", categoryName);

        List<Good> goods =query.getResultList();

        session.getTransaction().commit();
        session.close();
        return goods;
    }

    public static List<Good> getGoodsByStatus(String storeName, Status status){
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Query<Good> query = session.createQuery("select g from " +
                "Store s inner join s.categories c"+
                " inner join " +
                "c.goods g where s.storeName =:storeName and g.status =:status", Good.class);
        query.setParameter("storeName", storeName);
        query.setParameter("status", status);

        List<Good> goods = query.getResultList();

        session.getTransaction().commit();
        session.close();
        return goods;
    }


    public static void saveGoodToCategory(String store, String category, String goodTitle, double goodPrice, Status status){
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Query<Category> query = session.createQuery("select c from " +
                "Store s inner join s.categories c"+
                " where s.storeName =:storeName and c.categoryName=:categoryName", Category.class);
        query.setParameter("storeName", store);
        query.setParameter("categoryName", category);

        Category cat = query.getSingleResult();

        Good temp = new Good(goodTitle, goodPrice, status);
        cat.add(temp);
        session.save(temp);

        session.getTransaction().commit();
        session.close();
    }

    public static void closeConnections(){
        factory.close();
    }
}
