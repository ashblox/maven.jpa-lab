package services;

import entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("sales");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public Product createProduct(String name, String type, Double price) {

        Product product = new Product();
        product.setName(name);
        product.setType(type);
        product.setPrice(price);

        tx.begin();
            em.persist(product);
        tx.commit();

        return product;
    }

    public Product createProduct(Product product){
        tx.begin();
        em.persist(product);
        tx.commit();
        return product;
    }

    public Product findProduct(Long id) {
        return em.find(Product.class, id);
    }

    public void removeProduct(Product product) {
        Product productToBeDeleted = em.merge(product);
        em.remove(productToBeDeleted);
    }

    public Product changePrice(Product product, Double newPrice) {
        Product productToBeUpdated = em.merge(product);

        tx.begin();
        productToBeUpdated.setPrice(newPrice);
        tx.commit();
        return product;
    }
}
