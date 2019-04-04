import entities.Product;
import services.ProductService;

public class Main {

    public static void main(String[] args) {
        ProductService ps = new ProductService();
        Product product = ps.createProduct("travel mug", "kitchen", 5.99);
        System.out.println("Product Persisted: " + product.getName());
    }
}
