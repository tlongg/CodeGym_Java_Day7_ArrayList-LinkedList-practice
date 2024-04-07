import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProductManager productManager = new ProductManager();
        productManager.addProduct(new Product(1, "Laptop", 1000.0));
        productManager.addProduct(new Product(2, "Phone", 500.0));
        productManager.addProduct(new Product(3, "Tablet", 300.0));

        System.out.println("Product list:");
        productManager.showProduct();

        System.out.println("\nSearch product by name (e.g., 'Laptop'): ");
        String searchName = scanner.nextLine();
        productManager.searchProductByName(searchName);

        System.out.println("\nSort products by price (ascending):");
        productManager.sortProductsByPriceAscending();
        productManager.showProduct();

        System.out.println("\nSort products by price (descending):");
        productManager.sortProductsByPriceDescending();
        productManager.showProduct();

        scanner.close();
    }
}