import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProductManager productManager = new ProductManager();

        int option;
        int id;
        String name;
        do {
            System.out.println("\n---------Menu------------ ");

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

        scanner.close();
    }
}