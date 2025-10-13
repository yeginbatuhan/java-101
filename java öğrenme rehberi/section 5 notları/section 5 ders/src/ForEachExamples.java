// Dosya: src/main/java/ForEachExamples.java
public class ForEachExamples {

    // ============================================
    // 1D ARRAY - FOREACH ÖRNEKLERİ
    // ============================================

    /**
     * Örnek 1: Basit integer array yazdırma
     */
    public static void example1D_Basic() {
        System.out.println("=== 1D ARRAY - BASIT ÖRNEK ===\n");

        // Integer array oluştur
        int[] numbers = {10, 20, 30, 40, 50};

        // Foreach ile array'i dolaş
        // Her iterasyonda 'number' değişkeni array'deki bir elemanı temsil eder
        for(int number : numbers) {
            // number değişkeni sırasıyla: 10, 20, 30, 40, 50 değerlerini alır
            System.out.println("Sayı: " + number);
        }

        System.out.println(); // Boş satır ekle
    }

    /**
     * Örnek 2: String array ile isim listesi yazdırma
     */
    public static void example1D_Strings() {
        System.out.println("=== 1D ARRAY - STRING ÖRNEK ===\n");

        // String array oluştur - öğrenci isimleri
        String[] students = {"Ali", "Veli", "Ayşe", "Mehmet", "Zeynep"};

        // Manuel sayaç ekleyelim (foreach'te otomatik index yok)
        int index = 1; // 1'den başlayacak sıra numarası

        // Foreach ile her öğrenci ismini al
        for(String student : students) {
            // student değişkeni her seferinde array'deki bir ismi alır
            // İlk turda: student = "Ali"
            // İkinci turda: student = "Veli" ... devam eder
            System.out.println(index + ". Öğrenci: " + student);

            // Sayacı bir artır
            index++;
        }

        System.out.println(); // Boş satır
    }

    /**
     * Örnek 3: Double array ile fiyat listesi ve toplam hesaplama
     */
    public static void example1D_Calculations() {
        System.out.println("=== 1D ARRAY - HESAPLAMA ÖRNEK ===\n");

        // Ürün fiyatları (double array)
        double[] prices = {19.99, 29.99, 49.99, 99.99, 149.99};

        // Toplam fiyatı tutacak değişken
        double total = 0.0;

        // Sayaç için değişken
        int productNumber = 1;

        // Foreach ile her fiyatı işle
        for(double price : prices) {
            // price değişkeni her seferinde bir fiyatı temsil eder
            System.out.println("Ürün " + productNumber + " fiyatı: " + price + " TL");

            // Bu fiyatı toplama ekle
            total += price; // total = total + price

            // Ürün numarasını artır
            productNumber++;
        }

        // Toplam fiyatı yazdır
        System.out.println("\nToplam tutar: " + total + " TL");

        // Ortalama fiyatı hesapla
        double average = total / prices.length;
        System.out.println("Ortalama fiyat: " + average + " TL");

        System.out.println(); // Boş satır
    }

    /**
     * Örnek 4: Boolean array ile durum kontrolü
     */
    public static void example1D_Boolean() {
        System.out.println("=== 1D ARRAY - BOOLEAN ÖRNEK ===\n");

        // Öğrencilerin sınav geçme durumları
        boolean[] passStatus = {true, false, true, true, false};
        String[] studentNames = {"Ali", "Veli", "Ayşe", "Mehmet", "Zeynep"};

        // Geçen öğrenci sayısını tutacak değişken
        int passedCount = 0;

        // Index için sayaç (çünkü iki array'i paralel kullanıyoruz)
        int index = 0;

        // Foreach ile durum array'ini dolaş
        for(boolean passed : passStatus) {
            // passed değişkeni her öğrencinin geçme durumunu temsil eder
            // true ise geçti, false ise kaldı

            // Öğrenci ismini index ile al
            String name = studentNames[index];

            // Durumu kontrol et ve yazdır
            if(passed) {
                // Eğer true ise (geçti ise)
                System.out.println(name + " - GEÇTİ ✓");
                passedCount++; // Geçen sayısını artır
            } else {
                // Eğer false ise (kaldı ise)
                System.out.println(name + " - KALDI ✗");
            }

            // Index'i artır
            index++;
        }

        // Özet bilgi yazdır
        System.out.println("\nGeçen öğrenci sayısı: " + passedCount);
        System.out.println("Kalan öğrenci sayısı: " + (passStatus.length - passedCount));

        System.out.println(); // Boş satır
    }


    // ============================================
    // 2D ARRAY - FOREACH ÖRNEKLERİ
    // ============================================

    /**
     * Örnek 1: Basit 2D array yazdırma
     */
    public static void example2D_Basic() {
        System.out.println("=== 2D ARRAY - BASIT ÖRNEK ===\n");

        // 3 satır, 4 sütun matris oluştur
        int[][] matrix = {
                {1, 2, 3, 4},      // Satır 0
                {5, 6, 7, 8},      // Satır 1
                {9, 10, 11, 12}    // Satır 2
        };

        // Satır numarası için sayaç
        int rowNumber = 0;

        // Dış foreach: Her satırı al
        for(int[] row : matrix) {
            // row değişkeni her seferinde bir satırı (1D array) temsil eder
            // İlk turda: row = {1, 2, 3, 4}
            // İkinci turda: row = {5, 6, 7, 8}
            // Üçüncü turda: row = {9, 10, 11, 12}

            System.out.print("Satır " + rowNumber + ": ");

            // İç foreach: Satırdaki her elemanı al
            for(int element : row) {
                // element değişkeni satırdaki her sayıyı temsil eder
                // Satır 0'da: 1, 2, 3, 4
                System.out.print(element + " ");
            }

            // Satır bitince alt satıra geç
            System.out.println();

            // Satır numarasını artır
            rowNumber++;
        }

        System.out.println(); // Boş satır
    }

    /**
     * Örnek 2: Öğrenci notları tablosu
     */
    public static void example2D_StudentGrades() {
        System.out.println("=== 2D ARRAY - ÖĞRENCİ NOTLARI ===\n");

        // Her satır bir öğrenci, her sütun bir ders notu
        int[][] grades = {
                {85, 90, 78, 92},  // Ali'nin notları
                {88, 85, 95, 89},  // Veli'nin notları
                {90, 87, 91, 94}   // Ayşe'nin notları
        };

        // Öğrenci isimleri
        String[] studentNames = {"Ali", "Veli", "Ayşe"};

        // Ders isimleri
        String[] subjects = {"Matematik", "Fizik", "Kimya", "Biyoloji"};

        // Öğrenci index'i için sayaç
        int studentIndex = 0;

        // Dış foreach: Her öğrencinin notlarını al
        for(int[] studentGrades : grades) {
            // studentGrades değişkeni bir öğrencinin tüm notlarını içerir
            // İlk turda: studentGrades = {85, 90, 78, 92} (Ali)

            // Öğrenci ismini yazdır
            System.out.println(studentNames[studentIndex] + "'nin notları:");

            // Not toplamı için değişken
            int total = 0;

            // Ders index'i için sayaç
            int subjectIndex = 0;

            // İç foreach: Her notu işle
            for(int grade : studentGrades) {
                // grade değişkeni bir ders notunu temsil eder
                // Ali için sırasıyla: 85, 90, 78, 92

                // Ders ismi ile notu yazdır
                System.out.println("  " + subjects[subjectIndex] + ": " + grade);

                // Toplama ekle
                total += grade;

                // Ders index'ini artır
                subjectIndex++;
            }

            // Ortalama hesapla
            double average = total / (double) studentGrades.length;

            // Ortalamayı yazdır
            System.out.printf("  Ortalama: %.2f\n", average);
            System.out.println(); // Boş satır

            // Öğrenci index'ini artır
            studentIndex++;
        }
    }

    /**
     * Örnek 3: Haftalık satış tablosu
     */
    public static void example2D_WeeklySales() {
        System.out.println("=== 2D ARRAY - HAFTALIK SATIŞ TABLOSU ===\n");

        // Her satır bir gün, her sütun bir ürün satışı
        int[][] weeklySales = {
                {100, 150, 200, 120},  // Pazartesi
                {110, 140, 190, 130},  // Salı
                {120, 160, 210, 140},  // Çarşamba
                {105, 145, 195, 125},  // Perşembe
                {130, 170, 220, 150}   // Cuma
        };

        // Gün isimleri
        String[] days = {"Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma"};

        // Ürün isimleri
        String[] products = {"Ürün A", "Ürün B", "Ürün C", "Ürün D"};

        // Gün index'i için sayaç
        int dayIndex = 0;

        // Haftalık genel toplam
        int weeklyTotal = 0;

        // Dış foreach: Her günün satışlarını al
        for(int[] dailySales : weeklySales) {
            // dailySales değişkeni bir günün tüm satışlarını içerir

            // Gün ismini yazdır
            System.out.print(days[dayIndex] + ": ");

            // Günlük toplam
            int dailyTotal = 0;

            // İç foreach: Her ürünün satışını işle
            for(int sale : dailySales) {
                // sale değişkeni bir ürünün o gün satış miktarını temsil eder

                // Satış miktarını yazdır
                System.out.print(sale + " ");

                // Günlük toplama ekle
                dailyTotal += sale;

                // Haftalık toplama ekle
                weeklyTotal += sale;
            }

            // Günlük toplam yazdır
            System.out.println("| Günlük Toplam: " + dailyTotal);

            // Gün index'ini artır
            dayIndex++;
        }

        // Haftalık toplam yazdır
        System.out.println("\nHaftalık Toplam Satış: " + weeklyTotal);

        // Ürün bazında toplam hesaplama
        System.out.println("\n--- Ürün Bazlı Toplam ---");

        // Her ürün için döngü
        for(int productIndex = 0; productIndex < products.length; productIndex++) {
            // Bu ürünün haftalık toplam satışı
            int productTotal = 0;

            // Foreach ile her günü dolaş
            for(int[] dailySales : weeklySales) {
                // dailySales bir günün satışları
                // productIndex ile istediğimiz ürünün satışını al
                productTotal += dailySales[productIndex];
            }

            // Ürün toplam satışını yazdır
            System.out.println(products[productIndex] + " toplam: " + productTotal);
        }

        System.out.println(); // Boş satır
    }

    /**
     * Örnek 4: Sınav sonuçları ve istatistik
     */
    public static void example2D_ExamStatistics() {
        System.out.println("=== 2D ARRAY - SINAV İSTATİSTİKLERİ ===\n");

        // 4 öğrenci, 3 sınav notu
        double[][] examResults = {
                {75.5, 82.0, 88.5},  // Öğrenci 1
                {90.0, 85.5, 92.0},  // Öğrenci 2
                {68.0, 72.5, 70.0},  // Öğrenci 3
                {95.5, 98.0, 96.5}   // Öğrenci 4
        };

        // Öğrenci numarası için sayaç
        int studentNumber = 1;

        // En yüksek ortalamayı ve öğrenciyi takip et
        double highestAverage = 0.0;
        int topStudentNumber = 0;

        // Dış foreach: Her öğrencinin notlarını al
        for(double[] studentScores : examResults) {
            // studentScores bir öğrencinin tüm sınav notlarını içerir

            System.out.print("Öğrenci " + studentNumber + " notları: ");

            // Not toplamı
            double total = 0.0;

            // Sınav sayacı
            int examNumber = 1;

            // İç foreach: Her sınav notunu işle
            for(double score : studentScores) {
                // score bir sınav notunu temsil eder

                // Notu yazdır
                System.out.print("Sınav" + examNumber + "=" + score + " ");

                // Toplama ekle
                total += score;

                // Sınav sayacını artır
                examNumber++;
            }

            // Ortalama hesapla
            double average = total / studentScores.length;

            // Ortalamayı yazdır
            System.out.printf("| Ort: %.2f\n", average);

            // En yüksek ortalama kontrolü
            if(average > highestAverage) {
                // Eğer bu ortalama daha yüksekse
                highestAverage = average; // Yeni en yüksek ortalama
                topStudentNumber = studentNumber; // Bu öğrenciyi kaydet
            }

            // Öğrenci numarasını artır
            studentNumber++;
        }

        // En başarılı öğrenciyi yazdır
        System.out.println("\nEn başarılı öğrenci: Öğrenci " + topStudentNumber);
        System.out.printf("Ortalama: %.2f\n", highestAverage);

        System.out.println(); // Boş satır
    }


    // ============================================
    // 3D ARRAY - FOREACH ÖRNEKLERİ
    // ============================================

    /**
     * Örnek 1: Basit 3D array yazdırma
     */
    public static void example3D_Basic() {
        System.out.println("=== 3D ARRAY - BASIT ÖRNEK ===\n");

        // 2 katman, her katmanda 2 satır, her satırda 3 eleman
        int[][][] cube = {
                { // Katman 0
                        {1, 2, 3},      // Satır 0
                        {4, 5, 6}       // Satır 1
                },
                { // Katman 1
                        {7, 8, 9},      // Satır 0
                        {10, 11, 12}    // Satır 1
                }
        };

        // Katman numarası için sayaç
        int layerNumber = 0;

        // En dış foreach: Her katmanı al
        for(int[][] layer : cube) {
            // layer değişkeni bir katmanı (2D array) temsil eder
            // İlk turda: layer = {{1,2,3}, {4,5,6}}
            // İkinci turda: layer = {{7,8,9}, {10,11,12}}

            System.out.println("Katman " + layerNumber + ":");

            // Satır numarası için sayaç
            int rowNumber = 0;

            // Orta foreach: Katmandaki her satırı al
            for(int[] row : layer) {
                // row değişkeni bir satırı (1D array) temsil eder
                // Katman 0, ilk turda: row = {1, 2, 3}

                System.out.print("  Satır " + rowNumber + ": ");

                // En iç foreach: Satırdaki her elemanı al
                for(int element : row) {
                    // element bir sayıyı temsil eder
                    System.out.print(element + " ");
                }

                // Satır bitince alt satıra geç
                System.out.println();

                // Satır numarasını artır
                rowNumber++;
            }

            // Katman bitince boş satır ekle
            System.out.println();

            // Katman numarasını artır
            layerNumber++;
        }
    }

    /**
     * Örnek 2: Okul - Sınıf - Öğrenci notları sistemi
     */
    public static void example3D_SchoolSystem() {
        System.out.println("=== 3D ARRAY - OKUL SİSTEMİ ===\n");

        // [Sınıf][Öğrenci][Dersler]
        int[][][] schoolGrades = {
                { // Sınıf 9A
                        {85, 90, 78},  // Ali
                        {88, 85, 92},  // Veli
                        {90, 88, 86}   // Ayşe
                },
                { // Sınıf 9B
                        {82, 87, 90},  // Mehmet
                        {85, 89, 84},  // Zeynep
                        {91, 86, 88}   // Can
                },
                { // Sınıf 9C
                        {88, 92, 85},  // Elif
                        {86, 84, 89},  // Ahmet
                        {93, 90, 91}   // Fatma
                }
        };

        // Sınıf isimleri
        String[] classNames = {"9A", "9B", "9C"};

        // Her sınıfın öğrenci isimleri
        String[][] studentNames = {
                {"Ali", "Veli", "Ayşe"},
                {"Mehmet", "Zeynep", "Can"},
                {"Elif", "Ahmet", "Fatma"}
        };

        // Ders isimleri
        String[] subjects = {"Matematik", "Fizik", "Kimya"};

        // Sınıf index'i için sayaç
        int classIndex = 0;

        // En dış foreach: Her sınıfı al
        for(int[][] classGrades : schoolGrades) {
            // classGrades bir sınıfın tüm öğrencilerinin notlarını içerir (2D array)

            // Sınıf başlığını yazdır
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║  " + classNames[classIndex] + " SINIFI NOT LİSTESİ       ║");
            System.out.println("╚══════════════════════════════════╝");

            // Öğrenci index'i için sayaç
            int studentIndex = 0;

            // Sınıf toplamı için değişken
            int classTotal = 0;

            // Orta foreach: Sınıftaki her öğrencinin notlarını al
            for(int[] studentGrades : classGrades) {
                // studentGrades bir öğrencinin tüm notlarını içerir (1D array)

                // Öğrenci ismini yazdır
                System.out.print(studentNames[classIndex][studentIndex] + ": ");

                // Öğrencinin not toplamı
                int studentTotal = 0;

                // Ders index'i için sayaç
                int subjectIndex = 0;

                // En iç foreach: Her ders notunu işle
                for(int grade : studentGrades) {
                    // grade bir ders notunu temsil eder

                    // Ders ve notu yazdır
                    System.out.print(subjects[subjectIndex] + "=" + grade + " ");

                    // Öğrenci toplamına ekle
                    studentTotal += grade;

                    // Ders index'ini artır
                    subjectIndex++;
                }

                // Öğrenci ortalamasını hesapla
                double studentAverage = studentTotal / (double) studentGrades.length;

                // Ortalamayı yazdır
                System.out.printf("| Ort: %.1f\n", studentAverage);

                // Sınıf toplamına ekle
                classTotal += studentTotal;

                // Öğrenci index'ini artır
                studentIndex++;
            }

            // Sınıf ortalamasını hesapla
            // Toplam not sayısı = öğrenci sayısı * ders sayısı
            int totalGradeCount = classGrades.length * classGrades[0].length;
            double classAverage = classTotal / (double) totalGradeCount;

            // Sınıf ortalamasını yazdır
            System.out.println("─────────────────────────────────");
            System.out.printf("%s Sınıf Ortalaması: %.2f\n\n",
                    classNames[classIndex], classAverage);

            // Sınıf index'ini artır
            classIndex++;
        }
    }

    /**
     * Örnek 3: Aylık - Haftalık - Günlük satış sistemi
     */
    public static void example3D_SalesSystem() {
        System.out.println("=== 3D ARRAY - SATIŞ SİSTEMİ ===\n");

        // [Ay][Hafta][Gün]
        int[][][] monthlySales = {
                { // Ocak ayı
                        {100, 120, 110, 130, 140},  // 1. hafta (5 gün)
                        {105, 125, 115, 135, 145},  // 2. hafta
                        {110, 130, 120, 140, 150},  // 3. hafta
                        {115, 135, 125, 145, 155}   // 4. hafta
                },
                { // Şubat ayı
                        {120, 140, 130, 150, 160},  // 1. hafta
                        {125, 145, 135, 155, 165},  // 2. hafta
                        {130, 150, 140, 160, 170},  // 3. hafta
                        {135, 155, 145, 165, 175}   // 4. hafta
                }
        };

        // Ay isimleri
        String[] monthNames = {"Ocak", "Şubat"};

        // Gün isimleri
        String[] dayNames = {"Pzt", "Sal", "Çar", "Per", "Cum"};

        // Ay index'i için sayaç
        int monthIndex = 0;

        // Toplam satış takibi
        int grandTotal = 0;

        // En dış foreach: Her ayı al
        for(int[][] monthData : monthlySales) {
            // monthData bir ayın tüm haftalarını içerir (2D array)

            System.out.println("╔════════════════════════════════╗");
            System.out.println("║  " + monthNames[monthIndex] + " AYI SATIŞ RAPORU    ║");
            System.out.println("╚════════════════════════════════╝");

            // Hafta numarası için sayaç
            int weekNumber = 1;

            // Aylık toplam
            int monthTotal = 0;

            // Orta foreach: Aydaki her haftayı al
            for(int[] weekSales : monthData) {
                // weekSales bir haftanın tüm günlerini içerir (1D array)

                System.out.print("Hafta " + weekNumber + ": ");

                // Haftalık toplam
                int weekTotal = 0;

                // Gün index'i için sayaç
                int dayIndex = 0;

                // En iç foreach: Haftadaki her günü işle
                for(int dailySale : weekSales) {
                    // dailySale bir günün satış miktarını temsil eder

                    // Gün ve satış miktarını yazdır
                    System.out.print(dayNames[dayIndex] + "=" + dailySale + " ");

                    // Haftalık toplama ekle
                    weekTotal += dailySale;

                    // Gün index'ini artır
                    dayIndex++;
                }

                // Haftalık toplam yazdır
                System.out.println("| Toplam: " + weekTotal);

                // Aylık toplama ekle
                monthTotal += weekTotal;

                // Hafta numarasını artır
                weekNumber++;
            }

            // Aylık toplam ve ortalama yazdır
            double monthAverage = monthTotal / (double) (monthData.length * monthData[0].length);
            System.out.println("─────────────────────────────────");
            System.out.println(monthNames[monthIndex] + " Aylık Toplam: " + monthTotal);
            System.out.printf(monthNames[monthIndex] + " Günlük Ortalama: %.2f\n\n", monthAverage);

            // Genel toplama ekle
            grandTotal += monthTotal;

            // Ay index'ini artır
            monthIndex++;
        }

        // Genel rapor
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║  GENEL SATIŞ RAPORU            ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.println("2 Aylık Toplam Satış: " + grandTotal);

        // Toplam gün sayısı
        int totalDays = monthlySales.length * monthlySales[0].length * monthlySales[0][0].length;
        double overallAverage = grandTotal / (double) totalDays;
        System.out.printf("Günlük Genel Ortalama: %.2f\n", overallAverage);

        System.out.println(); // Boş satır
    }

    /**
     * Örnek 4: Şehir - Mağaza - Ürün satış analizi
     */
    public static void example3D_CityStoreProduct() {
        System.out.println("=== 3D ARRAY - ŞEHİR/MAĞAZA/ÜRÜN ANALİZİ ===\n");

        // [Şehir][Mağaza][Ürün]
        double[][][] salesData = {
                { // İstanbul
                        {1500.50, 2300.75, 1800.25},  // 1. Mağaza
                        {1600.00, 2400.00, 1900.50},  // 2. Mağaza
                        {1550.25, 2350.50, 1850.75}   // 3. Mağaza
                },
                { // Ankara
                        {1200.00, 1800.50, 1500.25},  // 1. Mağaza
                        {1250.50, 1850.75, 1550.00},  // 2. Mağaza
                        {1225.25, 1825.25, 1525.50}   // 3. Mağaza
                },
                { // İzmir
                        {1400.75, 2100.25, 1700.50},  // 1. Mağaza
                        {1450.00, 2150.50, 1750.25},  // 2. Mağaza
                        {1425.50, 2125.75, 1725.75}   // 3. Mağaza
                }
        };

        // Şehir isimleri
        String[] cityNames = {"İstanbul", "Ankara", "İzmir"};

        // Ürün isimleri
        String[] productNames = {"Laptop", "Telefon", "Tablet"};

        // Şehir index'i için sayaç
        int cityIndex = 0;

        // Tüm şehirlerin toplam satışı
        double allCitiesTotal = 0.0;

        // En dış foreach: Her şehri al
        for(double[][] cityData : salesData) {
            // cityData bir şehrin tüm mağazalarını içerir (2D array)

            System.out.println("┌─────────────────────────────────────┐");
            System.out.println("│  " + cityNames[cityIndex] + " ŞEHRİ SATIŞ RAPORU      │");
            System.out.println("└─────────────────────────────────────┘");

            // Mağaza numarası için sayaç
            int storeNumber = 1;

            // Şehir toplam satışı
            double cityTotal = 0.0;

            // Orta foreach: Şehirdeki her mağazayı al
            for(double[] storeData : cityData) {
                // storeData bir mağazanın tüm ürün satışlarını içerir (1D array)

                System.out.println("  Mağaza " + storeNumber + ":");

                // Mağaza toplam satışı
                double storeTotal = 0.0;

                // Ürün index'i için sayaç
                int productIndex = 0;

                // En iç foreach: Mağazadaki her ürünü işle
                for(double productSale : storeData) {
                    // productSale bir ürünün satış tutarını temsil eder

                    // Ürün ve satış tutarını yazdır
                    System.out.printf("    %s: %.2f TL\n",
                            productNames[productIndex], productSale);

                    // Mağaza toplamına ekle
                    storeTotal += productSale;

                    // Ürün index'ini artır
                    productIndex++;
                }

                // Mağaza toplam satışını yazdır
                System.out.printf("    Mağaza %d Toplam: %.2f TL\n\n",
                        storeNumber, storeTotal);

                // Şehir toplamına ekle
                cityTotal += storeTotal;

                // Mağaza numarasını artır
                storeNumber++;
            }

            // Şehir toplam ve ortalama yazdır
            double cityAverage = cityTotal / cityData.length; // Mağaza sayısına böl
            System.out.println("  ───────────────────────────────────");
            System.out.printf("  %s Toplam Satış: %.2f TL\n",
                    cityNames[cityIndex], cityTotal);
            System.out.printf("  %s Mağaza Ortalaması: %.2f TL\n\n",
                    cityNames[cityIndex], cityAverage);

            // Genel toplama ekle
            allCitiesTotal += cityTotal;

            // Şehir index'ini artır
            cityIndex++;
        }

        // Tüm şehirler için genel rapor
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║  TÜM ŞEHİRLER GENEL RAPOR           ║");
        System.out.println("╚═════════════════════════════════════╝");
        System.out.printf("Toplam Satış: %.2f TL\n", allCitiesTotal);

        // Ortalama hesapla (şehir sayısı * mağaza sayısı)
        int totalStores = salesData.length * salesData[0].length;
        double averagePerStore = allCitiesTotal / totalStores;
        System.out.printf("Mağaza Başına Ortalama: %.2f TL\n", averagePerStore);

        // Ürün bazında analiz
        System.out.println("\n--- ÜRÜN BAZLI TOPLAM SATIŞ ---");

        // Her ürün için döngü
        for(int prodIndex = 0; prodIndex < productNames.length; prodIndex++) {
            // Bu ürünün tüm şehir ve mağazalardaki toplam satışı
            double productTotal = 0.0;

            // Foreach ile her şehri dolaş
            for(double[][] cityData : salesData) {
                // cityData bir şehrin mağazaları

                // Foreach ile şehirdeki her mağazayı dolaş
                for(double[] storeData : cityData) {
                    // storeData bir mağazanın ürün satışları
                    // prodIndex ile istediğimiz ürünün satışını al
                    productTotal += storeData[prodIndex];
                }
            }

            // Ürün toplam satışını yazdır
            System.out.printf("%s Toplam Satış: %.2f TL\n",
                    productNames[prodIndex], productTotal);
        }

        // En çok satan şehri bul
        System.out.println("\n--- EN BAŞARILI ŞEHİR ---");

        // Şehir index'ini sıfırla
        cityIndex = 0;

        // En yüksek satışı takip et
        double highestCityTotal = 0.0;
        String topCity = "";

        // Foreach ile her şehri dolaş
        for(double[][] cityData : salesData) {
            // cityData bir şehrin tüm mağazaları

            // Bu şehrin toplam satışını hesapla
            double currentCityTotal = 0.0;

            // Foreach ile mağazaları dolaş
            for(double[] storeData : cityData) {
                // storeData bir mağazanın ürün satışları

                // Foreach ile ürünleri dolaş
                for(double productSale : storeData) {
                    // Toplama ekle
                    currentCityTotal += productSale;
                }
            }

            // En yüksek satış kontrolü
            if(currentCityTotal > highestCityTotal) {
                // Eğer bu şehrin satışı daha yüksekse
                highestCityTotal = currentCityTotal;
                topCity = cityNames[cityIndex];
            }

            // Şehir index'ini artır
            cityIndex++;
        }

        // En başarılı şehri yazdır
        System.out.printf("En Başarılı Şehir: %s\n", topCity);
        System.out.printf("Toplam Satış: %.2f TL\n", highestCityTotal);

        System.out.println(); // Boş satır
    }


    // ============================================
    // MAIN METOT - ÖRNEKLERI ÇALIŞTIRMAK İÇİN
    // ============================================

    public static void main(String[] args) {
        // İstediğin örneği çalıştırmak için yorum satırını kaldır

        // === 1D ARRAY ÖRNEKLERİ ===
        // example1D_Basic();              // Basit integer array
        // example1D_Strings();            // String array - isimler
        // example1D_Calculations();       // Hesaplama - fiyatlar
        // example1D_Boolean();            // Boolean array - durum kontrolü

        // === 2D ARRAY ÖRNEKLERİ ===
        // example2D_Basic();              // Basit 2D array
        // example2D_StudentGrades();      // Öğrenci notları
        // example2D_WeeklySales();        // Haftalık satış
        // example2D_ExamStatistics();     // Sınav istatistikleri

        // === 3D ARRAY ÖRNEKLERİ ===
        // example3D_Basic();              // Basit 3D array
        // example3D_SchoolSystem();       // Okul sistemi
        // example3D_SalesSystem();        // Aylık satış sistemi
        //example3D_CityStoreProduct();   // Şehir/Mağaza/Ürün analizi

        System.out.println("Program tamamlandı!");
    }
}