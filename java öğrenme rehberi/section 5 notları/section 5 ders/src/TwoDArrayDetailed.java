// Dosya: src/main/java/TwoDArrayDetailed.java
public class TwoDArrayDetailed {
    public static void main(String[] args) {

        // ============================================
        // YÖNTEM 1: Boyut belirterek oluşturma
        // ============================================
        int[][] matrix1 = new int[3][4]; // 3 satır, 4 sütun

        // Değer atama
        matrix1[0][0] = 10;
        matrix1[0][1] = 20;
        matrix1[0][2] = 30;
        matrix1[0][3] = 40;

        matrix1[1][0] = 50;
        matrix1[1][1] = 60;
        matrix1[1][2] = 70;
        matrix1[1][3] = 80;

        matrix1[2][0] = 90;
        matrix1[2][1] = 100;
        matrix1[2][2] = 110;
        matrix1[2][3] = 120;

        System.out.println("=== YÖNTEM 1: Manuel Atama ===");
        System.out.println("matrix1[0][0] = " + matrix1[0][0]); // 10
        System.out.println("matrix1[1][2] = " + matrix1[1][2]); // 70
        System.out.println("matrix1[2][3] = " + matrix1[2][3]); // 120


        // ============================================
        // YÖNTEM 2: Değerlerle birlikte oluşturma
        // ============================================
        int[][] matrix2 = {
                {1, 2, 3, 4},      // Satır 0
                {5, 6, 7, 8},      // Satır 1
                {9, 10, 11, 12}    // Satır 2
        };

        System.out.println("\n=== YÖNTEM 2: Değerlerle Oluşturma ===");
        System.out.println("matrix2[0][0] = " + matrix2[0][0]); // 1
        System.out.println("matrix2[1][2] = " + matrix2[1][2]); // 7
        System.out.println("matrix2[2][3] = " + matrix2[2][3]); // 12


        // ============================================
        // YAZDIRMA - FOR LOOP (İndex Kontrolü)
        // ============================================
        System.out.println("\n=== FOR LOOP İLE YAZDIRMA ===");

        // Dış loop: satırları dolaş
        for(int i = 0; i < matrix2.length; i++) {
            // İç loop: sütunları dolaş
            for(int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + "\t"); // \t = tab boşluk
            }
            System.out.println(); // Satır bitince alt satıra geç
        }


        // ============================================
        // YAZDIRMA - FOREACH (Daha Temiz)
        // ============================================
        System.out.println("\n=== FOREACH İLE YAZDIRMA ===");

        // Dış foreach: her satırı al
        for(int[] row : matrix2) {
            // İç foreach: satırdaki her elemanı al
            for(int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }


        // ============================================
        // BOYUT BİLGİLERİ
        // ============================================
        System.out.println("\n=== BOYUT BİLGİLERİ ===");
        System.out.println("Satır sayısı: " + matrix2.length); // 3
        System.out.println("Sütun sayısı (1. satır): " + matrix2[0].length); // 4
        System.out.println("Sütun sayısı (2. satır): " + matrix2[1].length); // 4
        System.out.println("Sütun sayısı (3. satır): " + matrix2[2].length); // 4


        // ============================================
        // İNDEX NUMARALARI İLE YAZDIRMA
        // ============================================
        System.out.println("\n=== INDEX NUMARALARI İLE ===");
        for(int i = 0; i < matrix2.length; i++) {
            for(int j = 0; j < matrix2[i].length; j++) {
                System.out.print("matrix2[" + i + "][" + j + "]=" + matrix2[i][j] + "  ");
            }
            System.out.println();
        }


        // ============================================
        // GERÇEK HAYAT ÖRNEĞİ: HAFTALIK SATIŞ TABLOSu
        // ============================================
        System.out.println("\n=== HAFTALIK SATIŞ TABLOSU ===");

        // 3 gün, 4 ürün
        int[][] sales = {
                {100, 150, 200, 120}, // Pazartesi satışları
                {110, 140, 190, 130}, // Salı satışları
                {120, 160, 210, 140}  // Çarşamba satışları
        };

        String[] days = {"Pazartesi", "Salı", "Çarşamba"};
        String[] products = {"Ürün A", "Ürün B", "Ürün C", "Ürün D"};

        // Başlık yazdır
        System.out.print("Gün\t\t");
        for(String product : products) {
            System.out.print(product + "\t");
        }
        System.out.println("Toplam");

        // Satırları yazdır - FOR LOOP kullanarak
        for(int i = 0; i < sales.length; i++) {
            System.out.print(days[i] + "\t");
            int dailyTotal = 0;

            for(int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + "\t");
                dailyTotal += sales[i][j];
            }
            System.out.println(dailyTotal);
        }

        // Ürün bazında toplam - FOREACH kullanarak
        System.out.println("\n=== ÜRÜN BAZLI TOPLAM (FOREACH) ===");
        for(int productIndex = 0; productIndex < products.length; productIndex++) {
            int productTotal = 0;

            for(int[] daySales : sales) {
                productTotal += daySales[productIndex];
            }

            System.out.println(products[productIndex] + " toplam satış: " + productTotal);
        }
    }
}
