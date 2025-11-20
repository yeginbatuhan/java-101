public class ArrayExercises {

    /**
     * Egzersiz 1: Öğrenci Not Yönetim Sistemi
     *
     * Gereksinimler:
     * - 5 öğrencinin 3 sınav notunu tut
     * - Her öğrencinin ortalamasını hesapla
     * - Sınıf ortalamasını bul
     * - En başarılı ve en başarısız öğrenciyi bul
     * - Geçen/kalan öğrenci sayısını say (50 altı kaldı)
     */
    public static void exercise1_StudentGradeSystem() {
        System.out.println("=== EGZERSİZ 1: ÖĞRENCİ NOT SİSTEMİ ===\n");

        // Öğrenci isimleri
        String[] studentNames = {"Ali", "Veli", "Ayşe", "Mehmet", "Zeynep"};

        // Her öğrencinin 3 sınav notu (2D array)
        int[][] examScores = {
                {85, 90, 78},  // Ali
                {65, 70, 60},  // Veli
                {95, 92, 88},  // Ayşe
                {45, 50, 48},  // Mehmet
                {88, 85, 90}   // Zeynep
        };

        // Her öğrencinin ortalamasını sakla
        double[] studentAverages = new double[studentNames.length];

        System.out.println("ÖĞRENCİ NOT LİSTESİ:");
        System.out.println("=".repeat(70));

        // Sınıf toplamı için değişken
        double classTotal = 0.0;

        // Her öğrenci için işlemler
        for(int i = 0; i < studentNames.length; i++) {
            System.out.print(studentNames[i] + ": ");

            // Öğrencinin notlarını topla
            int studentTotal = 0;
            for(int j = 0; j < examScores[i].length; j++) {
                System.out.print(examScores[i][j] + " ");
                studentTotal += examScores[i][j];
            }

            // Öğrenci ortalamasını hesapla
            double average = studentTotal / (double) examScores[i].length;
            studentAverages[i] = average;
            classTotal += average;

            // Geçti/Kaldı durumu
            String status = average >= 50 ? "GEÇTİ ✓" : "KALDI ✗";

            System.out.printf("| Ort: %.2f | %s\n", average, status);
        }

        // Sınıf ortalaması
        double classAverage = classTotal / studentNames.length;
        System.out.println("=".repeat(70));
        System.out.printf("SINIF ORTALAMASI: %.2f\n", classAverage);

        // En başarılı öğrenci
        int topStudentIndex = 0;
        for(int i = 1; i < studentAverages.length; i++) {
            if(studentAverages[i] > studentAverages[topStudentIndex]) {
                topStudentIndex = i;
            }
        }

        System.out.printf("\nEN BAŞARILI: %s (%.2f)\n",
                studentNames[topStudentIndex],
                studentAverages[topStudentIndex]);

        // En başarısız öğrenci
        int worstStudentIndex = 0;
        for(int i = 1; i < studentAverages.length; i++) {
            if(studentAverages[i] < studentAverages[worstStudentIndex]) {
                worstStudentIndex = i;
            }
        }

        System.out.printf("EN BAŞARISIZ: %s (%.2f)\n",
                studentNames[worstStudentIndex],
                studentAverages[worstStudentIndex]);

        // Geçen/Kalan sayısı
        int passedCount = 0;
        for(double average : studentAverages) {
            if(average >= 50) {
                passedCount++;
            }
        }

        System.out.println("\nGEÇEN ÖĞRENCİ: " + passedCount);
        System.out.println("KALAN ÖĞRENCİ: " + (studentNames.length - passedCount));

        System.out.println();
    }

    /**
     * Egzersiz 2: Mağaza Envanter Sistemi
     *
     * Gereksinimler:
     * - Ürün adı, fiyat, stok miktarını tut
     * - Toplam envanter değerini hesapla
     * - Stok uyarısı ver (10'dan az)
     * - En pahalı ve en ucuz ürünü bul
     * - Ortalama ürün fiyatını hesapla
     */
    public static void exercise2_InventorySystem() {
        System.out.println("=== EGZERSİZ 2: ENVANTER SİSTEMİ ===\n");

        // Ürün bilgileri
        String[] productNames = {
                "Laptop", "Mouse", "Klavye", "Monitor", "Kulaklık",
                "Webcam", "USB Kablo", "HDMI Kablo"
        };

        double[] prices = {
                15000.00, 250.00, 500.00, 3000.00,
                800.00, 1200.00, 50.00, 80.00
        };

        int[] stock = {
                5, 25, 15, 8, 12, 6, 50, 30
        };

        // Envanter listesi
        System.out.println("ENVANTER LİSTESİ:");
        System.out.println("=".repeat(80));
        System.out.printf("%-15s | %10s | %5s | %15s\n",
                "Ürün", "Fiyat", "Stok", "Toplam Değer");
        System.out.println("=".repeat(80));

        double totalInventoryValue = 0.0;
        double totalPrice = 0.0;

        for(int i = 0; i < productNames.length; i++) {
            double itemValue = prices[i] * stock[i];
            totalInventoryValue += itemValue;
            totalPrice += prices[i];

            // Stok uyarısı
            String warning = stock[i] < 10 ? " ⚠️ DÜŞÜK STOK" : "";

            System.out.printf("%-15s | %10.2f | %5d | %15.2f%s\n",
                    productNames[i], prices[i], stock[i],
                    itemValue, warning);
        }

        System.out.println("=".repeat(80));
        System.out.printf("TOPLAM ENVANTER DEĞERİ: %.2f TL\n", totalInventoryValue);

        // Ortalama fiyat
        double averagePrice = totalPrice / productNames.length;
        System.out.printf("ORTALAMA ÜRÜN FİYATI: %.2f TL\n", averagePrice);

        // En pahalı ürün
        int mostExpensiveIndex = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[mostExpensiveIndex]) {
                mostExpensiveIndex = i;
            }
        }

        System.out.printf("\nEN PAHALI ÜRÜN: %s (%.2f TL)\n",
                productNames[mostExpensiveIndex],
                prices[mostExpensiveIndex]);

        // En ucuz ürün
        int cheapestIndex = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < prices[cheapestIndex]) {
                cheapestIndex = i;
            }
        }

        System.out.printf("EN UCUZ ÜRÜN: %s (%.2f TL)\n",
                productNames[cheapestIndex],
                prices[cheapestIndex]);

        // Düşük stoklu ürünler
        System.out.println("\nDÜŞÜK STOKLU ÜRÜNLER (< 10):");
        System.out.println("-".repeat(80));
        boolean foundLowStock = false;

        for(int i = 0; i < stock.length; i++) {
            if(stock[i] < 10) {
                System.out.printf("%s: %d adet kaldı - Sipariş verin!\n",
                        productNames[i], stock[i]);
                foundLowStock = true;
            }
        }

        if(!foundLowStock) {
            System.out.println("Tüm ürünlerde yeterli stok var.");
        }

        System.out.println();
    }

    /**
     * Egzersiz 3: Çalışan Maaş Sistemi
     *
     * Gereksinimler:
     * - Çalışan adı, departman, maaş bilgisi
     * - Departman bazında toplam maaş
     * - En yüksek ve en düşük maaş
     * - Ortalama maaş
     * - Maaş artışı simülasyonu (%10)
     */
    public static void exercise3_EmployeeSalarySystem() {
        System.out.println("=== EGZERSİZ 3: ÇALIŞAN MAAŞ SİSTEMİ ===\n");

        String[] employeeNames = {
                "Ali Yılmaz", "Veli Kaya", "Ayşe Demir",
                "Mehmet Şahin", "Zeynep Aydın", "Can Öztürk",
                "Elif Çelik", "Ahmet Yıldız"
        };

        String[] departments = {
                "IT", "IT", "HR", "HR", "Sales", "Sales", "IT", "HR"
        };

        double[] salaries = {
                15000, 18000, 12000, 13000, 14000, 16000, 17000, 11000
        };

        // Çalışan listesi
        System.out.println("ÇALIŞAN LİSTESİ:");
        System.out.println("=".repeat(70));
        System.out.printf("%-20s | %-10s | %12s\n", "Ad Soyad", "Departman", "Maaş");
        System.out.println("=".repeat(70));

        double totalSalary = 0.0;

        for(int i = 0; i < employeeNames.length; i++) {
            System.out.printf("%-20s | %-10s | %12.2f TL\n",
                    employeeNames[i], departments[i], salaries[i]);
            totalSalary += salaries[i];
        }

        System.out.println("=".repeat(70));
        System.out.printf("TOPLAM MAAŞ ÖDEMESİ: %.2f TL\n", totalSalary);

        // Ortalama maaş
        double averageSalary = totalSalary / employeeNames.length;
        System.out.printf("ORTALAMA MAAŞ: %.2f TL\n", averageSalary);

        // Departman bazında analiz
        System.out.println("\nDEPARTMAN BAZLI ANALİZ:");
        System.out.println("-".repeat(70));

        String[] uniqueDepartments = {"IT", "HR", "Sales"};

        for(String dept : uniqueDepartments) {
            double deptTotal = 0.0;
            int deptCount = 0;

            for(int i = 0; i < departments.length; i++) {
                if(departments[i].equals(dept)) {
                    deptTotal += salaries[i];
                    deptCount++;
                }
            }

            double deptAverage = deptTotal / deptCount;
            System.out.printf("%s: %d çalışan | Toplam: %.2f TL | Ortalama: %.2f TL\n",
                    dept, deptCount, deptTotal, deptAverage);
        }

        // En yüksek maaş
        int highestIndex = 0;
        for(int i = 1; i < salaries.length; i++) {
            if(salaries[i] > salaries[highestIndex]) {
                highestIndex = i;
            }
        }

        System.out.printf("\nEN YÜKSEK MAAŞ: %s - %.2f TL (%s)\n",
                employeeNames[highestIndex],
                salaries[highestIndex],
                departments[highestIndex]);

        // En düşük maaş
        int lowestIndex = 0;
        for(int i = 1; i < salaries.length; i++) {
            if(salaries[i] < salaries[lowestIndex]) {
                lowestIndex = i;
            }
        }

        System.out.printf("EN DÜŞÜK MAAŞ: %s - %.2f TL (%s)\n",
                employeeNames[lowestIndex],
                salaries[lowestIndex],
                departments[lowestIndex]);

        // %10 Maaş artışı simülasyonu
        System.out.println("\n%10 MAAŞ ARTIŞI SİMÜLASYONU:");
        System.out.println("-".repeat(70));

        double newTotalSalary = 0.0;

        for(int i = 0; i < employeeNames.length; i++) {
            double newSalary = salaries[i] * 1.10;
            double increase = newSalary - salaries[i];
            newTotalSalary += newSalary;

            System.out.printf("%s: %.2f → %.2f TL (+%.2f)\n",
                    employeeNames[i], salaries[i], newSalary, increase);
        }

        double totalIncrease = newTotalSalary - totalSalary;
        System.out.println("-".repeat(70));
        System.out.printf("Yeni Toplam Maaş: %.2f TL\n", newTotalSalary);
        System.out.printf("Toplam Artış: %.2f TL\n", totalIncrease);

        System.out.println();
    }

    /**
     * Egzersiz 4: Haftalık Satış Analizi
     *
     * Gereksinimler:
     * - 7 günlük satış verisi (4 ürün için)
     * - Her günün toplam satışı
     * - Her ürünün haftalık toplam satışı
     * - En çok satan gün
     * - En çok satan ürün
     * - Haftalık ortalama
     */
    public static void exercise4_WeeklySalesAnalysis() {
        System.out.println("=== EGZERSİZ 4: HAFTALIK SATIŞ ANALİZİ ===\n");

        String[] days = {"Pazartesi", "Salı", "Çarşamba", "Perşembe",
                "Cuma", "Cumartesi", "Pazar"};

        String[] products = {"Laptop", "Telefon", "Tablet", "Kulaklık"};

        // 7 gün x 4 ürün satış matrisi
        int[][] sales = {
                {5, 8, 3, 12},   // Pazartesi
                {6, 10, 4, 15},  // Salı
                {8, 12, 5, 18},  // Çarşamba
                {7, 9, 6, 14},   // Perşembe
                {10, 15, 8, 20}, // Cuma
                {12, 18, 10, 25},// Cumartesi
                {9, 14, 7, 22}   // Pazar
        };

        // Haftalık satış tablosu
        System.out.println("HAFTALIK SATIŞ TABLOSU:");
        System.out.println("=".repeat(80));
        System.out.printf("%-12s | ", "Gün");
        for(String product : products) {
            System.out.printf("%-10s | ", product);
        }
        System.out.println("Toplam");
        System.out.println("=".repeat(80));

        int[] dailyTotals = new int[days.length];
        int weeklyTotal = 0;

        // Her gün için
        for(int i = 0; i < days.length; i++) {
            System.out.printf("%-12s | ", days[i]);

            int dayTotal = 0;
            for(int j = 0; j < products.length; j++) {
                System.out.printf("%-10d | ", sales[i][j]);
                dayTotal += sales[i][j];
            }

            dailyTotals[i] = dayTotal;
            weeklyTotal += dayTotal;
            System.out.println(dayTotal);
        }

        System.out.println("=".repeat(80));

        // Ürün bazında toplam
        System.out.printf("%-12s | ", "TOPLAM");
        int[] productTotals = new int[products.length];

        for(int j = 0; j < products.length; j++) {
            int productTotal = 0;
            for(int i = 0; i < days.length; i++) {
                productTotal += sales[i][j];
            }
            productTotals[j] = productTotal;
            System.out.printf("%-10d | ", productTotal);
        }
        System.out.println(weeklyTotal);

        // Analizler
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ANALİZ SONUÇLARI:");
        System.out.println("=".repeat(80));

        // Haftalık toplam
        System.out.printf("Haftalık Toplam Satış: %d adet\n", weeklyTotal);

        // Günlük ortalama
        double dailyAverage = weeklyTotal / (double) days.length;
        System.out.printf("Günlük Ortalama: %.2f adet\n", dailyAverage);

        // En çok satan gün
        int bestDayIndex = 0;
        for(int i = 1; i < dailyTotals.length; i++) {
            if(dailyTotals[i] > dailyTotals[bestDayIndex]) {
                bestDayIndex = i;
            }
        }
        System.out.printf("\nEn Çok Satan Gün: %s (%d adet)\n",
                days[bestDayIndex], dailyTotals[bestDayIndex]);

        // En az satan gün
        int worstDayIndex = 0;
        for(int i = 1; i < dailyTotals.length; i++) {
            if(dailyTotals[i] < dailyTotals[worstDayIndex]) {
                worstDayIndex = i;
            }
        }
        System.out.printf("En Az Satan Gün: %s (%d adet)\n",
                days[worstDayIndex], dailyTotals[worstDayIndex]);

        // En çok satan ürün
        int bestProductIndex = 0;
        for(int i = 1; i < productTotals.length; i++) {
            if(productTotals[i] > productTotals[bestProductIndex]) {
                bestProductIndex = i;
            }
        }
        System.out.printf("\nEn Çok Satan Ürün: %s (%d adet)\n",
                products[bestProductIndex], productTotals[bestProductIndex]);

        // En az satan ürün
        int worstProductIndex = 0;
        for(int i = 1; i < productTotals.length; i++) {
            if(productTotals[i] < productTotals[worstProductIndex]) {
                worstProductIndex = i;
            }
        }
        System.out.printf("En Az Satan Ürün: %s (%d adet)\n",
                products[worstProductIndex], productTotals[worstProductIndex]);

        // Hafta sonu vs hafta içi
        int weekdayTotal = 0;
        int weekendTotal = 0;

        for(int i = 0; i < 5; i++) { // Pazartesi-Cuma
            weekdayTotal += dailyTotals[i];
        }
        for(int i = 5; i < 7; i++) { // Cumartesi-Pazar
            weekendTotal += dailyTotals[i];
        }

        System.out.printf("\nHafta İçi Toplam (Pzt-Cum): %d adet\n", weekdayTotal);
        System.out.printf("Hafta Sonu Toplam (Cmt-Paz): %d adet\n", weekendTotal);
        System.out.printf("Hafta Sonu Oranı: %%%.2f\n",
                (weekendTotal * 100.0) / weeklyTotal);

        System.out.println();
    }

    public static void main(String[] args) {
        // Her egzersizi ayrı çalıştır

        exercise1_StudentGradeSystem();
        // exercise2_InventorySystem();
        // exercise3_EmployeeSalarySystem();
        // exercise4_WeeklySalesAnalysis();

        System.out.println("\n✅ Tüm egzersizler tamamlandı!");
    }
}