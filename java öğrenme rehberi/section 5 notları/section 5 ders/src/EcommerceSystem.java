class Product {
    int id;
    String name;
    double price;
    int stock;
    String category;

    public Product(int id, String name, double price, int stock, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public void display() {
        System.out.printf("%-20s | Fiyat: %8.2f TL | Stok: %3d | %s\n",
                name, price, stock, category);
    }

    public double getTotalValue() {
        return price * stock;
    }
}

public class EcommerceSystem {

    public static void example4_ProductCatalog() {
        System.out.println("=== ÜRÜN KATALOĞU SİSTEMİ ===\n");

        // Ürün dizisi oluştur
        Product[] products = {
                new Product(1, "Laptop", 15000.00, 10, "Elektronik"),
                new Product(2, "Mouse", 250.00, 50, "Elektronik"),
                new Product(3, "Klavye", 500.00, 30, "Elektronik"),
                new Product(4, "Monitor", 3000.00, 15, "Elektronik"),
                new Product(5, "Masa", 2500.00, 8, "Mobilya"),
                new Product(6, "Sandalye", 1800.00, 12, "Mobilya"),
                new Product(7, "Kitap", 45.00, 100, "Kırtasiye"),
                new Product(8, "Kalem", 5.00, 500, "Kırtasiye")
        };

        System.out.println("TÜM ÜRÜNLER:");
        System.out.println("=".repeat(70));
        for(Product product : products) {
            product.display();
        }

        // Kategoriye göre filtreleme
        System.out.println("\nELEKTRONİK KATEGORİSİ:");
        System.out.println("=".repeat(70));
        for(Product product : products) {
            if(product.category.equals("Elektronik")) {
                product.display();
            }
        }

        // Fiyat aralığına göre filtreleme
        System.out.println("\n1000 TL'nin altındaki ürünler:");
        System.out.println("=".repeat(70));
        for(Product product : products) {
            if(product.price < 1000) {
                product.display();
            }
        }

        // Toplam stok değeri
        double totalInventoryValue = 0.0;
        for(Product product : products) {
            totalInventoryValue += product.getTotalValue();
        }

        System.out.println("\n" + "=".repeat(70));
        System.out.printf("Toplam Stok Değeri: %.2f TL\n", totalInventoryValue);

        // En pahalı ürün
        Product mostExpensive = products[0];
        for(Product product : products) {
            if(product.price > mostExpensive.price) {
                mostExpensive = product;
            }
        }

        System.out.println("\nEn Pahalı Ürün:");
        mostExpensive.display();

        // Düşük stoklu ürünler (10'dan az)
        System.out.println("\nDÜŞÜK STOKLU ÜRÜNLER (Stok < 15):");
        System.out.println("=".repeat(70));
        for(Product product : products) {
            if(product.stock < 15) {
                product.display();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        example4_ProductCatalog();
    }
}