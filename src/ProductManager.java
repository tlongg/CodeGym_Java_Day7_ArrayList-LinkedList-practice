import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager extends Product {
    private ArrayList<Product> productList;
    private Scanner scanner = new Scanner(System.in);

    public ProductManager() {
        productList = new ArrayList<>();
    }

    public void addProduct(String name, double price) {
        Product product = new Product(name, price);
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

    public void menu() {
        ProductManager productManager = new ProductManager();
        int option;
        do {
            System.out.println("\n---------Menu---------");
            System.out.println("1. Add product");
            System.out.println("2. Edit product");
            System.out.println("3. Delete product");
            System.out.println("4. Show product");
            System.out.println("5. Search product by name");
            System.out.println("6. Sort product by price ascending");
            System.out.println("7. Sort product by price descending");
            System.out.println("8. Exit");
            System.out.println("Product list:");
            productManager.showProduct();
            System.out.println("Choose any options above: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter product price:");
                    double price = scanner.nextDouble();
                    productManager.addProduct(name, price);
                    break;
                case 2:
                    System.out.println("Enter product id to update product");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new product name");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new product price");
                    double newPrice = scanner.nextDouble();
                    productManager.updateProduct(id, newName, newPrice);
                    break;
                case 3:
                    System.out.println("Enter product id to delete product:");
                    id = scanner.nextInt();
                    productManager.deleteProduct(id);
                    break;
                case 4:
                    productManager.showProduct();
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Please enter product name you want to search:");
                    name = scanner.nextLine();
                    productManager.searchProductByName(name);
                    break;
                case 6:
                    productManager.sortProductsByPriceAscending();
                    break;
                case 7:
                    productManager.sortProductsByPriceDescending();
                    break;
            }
        } while (option != 8);
    }
}