public abstract class Products {
    private int id;
    private String name;
    private double price;
    private double discountRate;
    private int stock;
    private String brandName;
    private double screenSize;
    private int ram;
    private int memory;

    public Products(int id, String name, double price, double discountRate, int stock, String brandName, double screenSize, int ram, int memory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.brandName = brandName;
        this.screenSize = screenSize;
        this.ram = ram;
        this.memory = memory;
    }

    public Products() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
