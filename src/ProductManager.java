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
                    productManager.addProduct();
                    break;
                case 2:

                    productManager.updateProduct();
                    break;
                case 3:
                    productManager.deleteProduct();
                    break;
                case 4:
                    productManager.showProduct();
                    break;
                case 5:
                    ;
                    productManager.searchProductByName();
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
