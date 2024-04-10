public class Product {
    private static int nextId = 1;
    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.id = nextId++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product " + id + " {" +
                "id = " + id +
                ", name = " + name +
                ", price = " + price +
                '}';
    }
}
