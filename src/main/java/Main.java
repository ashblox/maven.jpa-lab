import entities.Product;
import services.ProductService;

public class Main {

    public static void main(String[] args) {
        ProductService ps = new ProductService();
        Product product = ps.findProduct(10l);
        ps.changePrice(product, 4.25);
    }
}
