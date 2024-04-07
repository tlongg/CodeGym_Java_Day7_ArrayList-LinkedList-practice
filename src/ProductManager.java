import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductManager extends Product {
    private ArrayList<Product> productList = new ArrayList<Product>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void updateProduct(int id, String newName, double newPrice) {
        for (Product product : productList) {
            if (product.getId() == id) {
                product.setName(newName);
                product.setPrice(newPrice);
                break;
            }
        }
    }

    public void deleteProduct(int id) {
        productList.removeIf(product -> product.getId() == id);
    }

    public void showProduct() {
        System.out.println(productList);
    }

    public void searchProductByName(String name) {
        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println(product);
            }
        }
    }
    public void sortProductsByPriceAscending() {
        productList.sort(Comparator.comparingDouble(Product::getPrice));
    }

    public void sortProductsByPriceDescending() {
        productList.sort(Comparator.comparingDouble(Product::getPrice).reversed());
    }
}
