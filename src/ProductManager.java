import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager extends Product {
    private ArrayList<Product> productList = new ArrayList<Product>();
    private Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        System.out.println("Input product name: ");
        String name = scanner.nextLine();
        double price;
        while (true) {
            try {
                System.out.println("Enter product price:");
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric price");
            }
        }
        Product product = new Product(name, price);
        productList.add(product);
    }

    public void updateProduct() {
        System.out.println("Enter product id to update product");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Product product : productList) {
            if (product.getId() == id) {
                System.out.println("Enter new product name");
                String newName = scanner.nextLine();
                System.out.println("Enter new product price");
                double newPrice = scanner.nextDouble();
                product.setName(newName);
                product.setPrice(newPrice);
                break;
            }
        }
    }

    public void deleteProduct() {
        System.out.println("Enter product id to delete product:");
        int id = scanner.nextInt();
        productList.removeIf(product -> product.getId() == id);
    }

    public void showProduct() {
        System.out.println(productList);
    }

    public void searchProductByName() {
        System.out.println("Please enter product name you want to search:");
        String name = scanner.nextLine();
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
