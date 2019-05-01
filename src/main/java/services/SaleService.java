package services;

import entities.Sale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaleService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("sales");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public Sale createSale(Long userId, Long productId, Long quantity) {

        Sale sale = new Sale();
        sale.setUserId(userId);
        sale.setProductId(productId);
        sale.setQuantity(quantity);

        tx.begin();
        em.persist(sale);
        tx.commit();

        return sale;
    }

    public Sale createSale(Sale sale){
        tx.begin();
        em.persist(sale);
        tx.commit();
        return sale;
    }

    public Sale findSale(Long id) {
        return em.find(Sale.class, id);
    }

    public void removeSale(Sale sale) {
        Sale saleToBeDeleted = em.merge(sale);
        tx.begin();
        em.remove(saleToBeDeleted);
        tx.commit();
    }

    public Sale changeQuantity(Sale sale, Long quantity) {
        Sale saleToBeUpdated = em.merge(sale);

        tx.begin();
        saleToBeUpdated.setQuantity(quantity);
        tx.commit();
        return sale;
    }
}
