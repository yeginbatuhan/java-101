public class JaggedArrayExamples {

    /**
     * Örnek 1: Jagged Array'in temel mantığı
     */
    public static void example1_BasicJagged() {
        System.out.println("=== JAGGED ARRAY - TEMEL MANTIK ===\n");

        // YÖNTEM 1: İki aşamalı oluşturma
        // Önce sadece satır sayısını belirt
        int[][] jagged1 = new int[4][]; // 4 satır var, ama sütun sayıları farklı olacak

        // Her satıra ayrı ayrı uzunluk ver
        jagged1[0] = new int[2];    // 1. satır 2 elemanlı
        jagged1[1] = new int[5];    // 2. satır 5 elemanlı
        jagged1[2] = new int[1];    // 3. satır 1 elemanlı
        jagged1[3] = new int[3];    // 4. satır 3 elemanlı

        // Değer atama
        jagged1[0][0] = 1;
        jagged1[0][1] = 2;

        jagged1[1][0] = 3;
        jagged1[1][1] = 4;
        jagged1[1][2] = 5;
        jagged1[1][3] = 6;
        jagged1[1][4] = 7;

        jagged1[2][0] = 8;

        jagged1[3][0] = 9;
        jagged1[3][1] = 10;
        jagged1[3][2] = 11;

        // Yazdırma
        System.out.println("Jagged Array 1:");
        for(int i = 0; i < jagged1.length; i++) {
            System.out.print("Satır " + i + " (" + jagged1[i].length + " eleman): ");
            for(int j = 0; j < jagged1[i].length; j++) {
                System.out.print(jagged1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        // YÖNTEM 2: Değerlerle birlikte oluşturma (daha pratik)
        int[][] jagged2 = {
                {1, 2},              // 1. satır - 2 eleman
                {3, 4, 5, 6, 7},     // 2. satır - 5 eleman
                {8},                 // 3. satır - 1 eleman
                {9, 10, 11}          // 4. satır - 3 eleman
        };

        System.out.println("Jagged Array 2:");
        for(int[] row : jagged2) {
            for(int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    /**
     * Örnek 2: Sınıflardaki öğrenci sayıları (gerçek hayat)
     */
    public static void example2_ClassroomStudents() {
        System.out.println("=== JAGGED ARRAY - SINIF ÖĞRENCİLERİ ===\n");

        // Her sınıfta farklı sayıda öğrenci var
        String[][] classrooms = {
                {"Ali", "Veli", "Ayşe", "Mehmet"},           // 9A - 4 öğrenci
                {"Zeynep", "Can", "Elif"},                   // 9B - 3 öğrenci
                {"Ahmet", "Fatma", "Hasan", "Deniz", "Ece"}, // 9C - 5 öğrenci
                {"Murat", "Selin"}                           // 9D - 2 öğrenci
        };

        String[] classNames = {"9A", "9B", "9C", "9D"};

        // Toplam öğrenci sayısını hesapla
        int totalStudents = 0;

        for(int i = 0; i < classrooms.length; i++) {
            System.out.println(classNames[i] + " Sınıfı (" + classrooms[i].length + " öğrenci):");

            for(int j = 0; j < classrooms[i].length; j++) {
                System.out.println("  " + (j+1) + ". " + classrooms[i][j]);
            }

            totalStudents += classrooms[i].length;
            System.out.println();
        }

        System.out.println("Toplam öğrenci sayısı: " + totalStudents);
        double averagePerClass = totalStudents / (double) classrooms.length;
        System.out.printf("Sınıf başına ortalama: %.2f öğrenci\n\n", averagePerClass);
    }

    /**
     * Örnek 3: Aylardaki gün sayıları
     */
    public static void example3_MonthlyDays() {
        System.out.println("=== JAGGED ARRAY - AYLIK GÜN SAYILARI ===\n");

        // Her ayda farklı sayıda gün var
        // Her gün için basit bir değer atayalım (örnek: o günün sıcaklığı)
        int[][] yearTemperatures = new int[12][]; // 12 ay

        // Ay uzunlukları (2024 artık yıl değil)
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] monthNames = {"Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
                "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};

        // Her ay için gün sayısı kadar array oluştur
        for(int i = 0; i < yearTemperatures.length; i++) {
            yearTemperatures[i] = new int[daysInMonth[i]];

            // Her güne rastgele sıcaklık değeri ata (10-30 derece arası)
            for(int j = 0; j < yearTemperatures[i].length; j++) {
                yearTemperatures[i][j] = 10 + (int)(Math.random() * 21);
            }
        }

        // Her ayın ortalama sıcaklığını hesapla
        System.out.println("Aylık Ortalama Sıcaklıklar:");
        for(int i = 0; i < yearTemperatures.length; i++) {
            int sum = 0;
            for(int temp : yearTemperatures[i]) {
                sum += temp;
            }
            double average = sum / (double) yearTemperatures[i].length;
            System.out.printf("%s (%d gün): %.1f°C\n",
                    monthNames[i], yearTemperatures[i].length, average);
        }

        System.out.println();
    }

    /**
     * Örnek 4: Anket sistemi - Sorular ve cevap seçenekleri
     */
    public static void example4_SurveySystem() {
        System.out.println("=== JAGGED ARRAY - ANKET SİSTEMİ ===\n");

        // Her sorunun farklı sayıda cevap seçeneği var
        String[] questions = {
                "Yaşınız?",
                "Mesleğiniz?",
                "Hangi dili tercih edersiniz?",
                "Günde kaç saat çalışıyorsunuz?"
        };

        String[][] answers = {
                {"18-25", "26-35", "36-45", "46+"},                    // Soru 1 - 4 seçenek
                {"Öğrenci", "Çalışan", "Serbest Meslek", "Emekli"},   // Soru 2 - 4 seçenek
                {"Java", "PHP", "Python", "JavaScript", "C#", "Go"},  // Soru 3 - 6 seçenek
                {"0-4", "5-8", "9+"}                                  // Soru 4 - 3 seçenek
        };

        // Anketi göster
        for(int i = 0; i < questions.length; i++) {
            System.out.println("Soru " + (i+1) + ": " + questions[i]);

            for(int j = 0; j < answers[i].length; j++) {
                System.out.println("  " + (char)('A' + j) + ") " + answers[i][j]);
            }

            System.out.println("  (" + answers[i].length + " seçenek)\n");
        }
    }

    /**
     * Örnek 5: Şehir ve mahalleler
     */
    public static void example5_CityDistricts() {
        System.out.println("=== JAGGED ARRAY - ŞEHİR VE MAHALLELER ===\n");

        // Her şehirde farklı sayıda mahalle var
        String[][] cities = {
                {"İstanbul", "Beyoğlu", "Kadıköy", "Beşiktaş", "Şişli", "Üsküdar"},
                {"Ankara", "Çankaya", "Keçiören", "Mamak"},
                {"İzmir", "Konak", "Karşıyaka", "Bornova", "Buca", "Balçova", "Urla"}
        };

        for(int i = 0; i < cities.length; i++) {
            // İlk eleman şehir ismi
            String cityName = cities[i][0];
            int districtCount = cities[i].length - 1;

            System.out.println(cityName + " (" + districtCount + " mahalle):");

            // Mahalle isimlerini yazdır (1. index'ten başla)
            for(int j = 1; j < cities[i].length; j++) {
                System.out.println("  - " + cities[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Örnek 6: Foreach ile Jagged Array yazdırma
     */
    public static void example6_JaggedWithForeach() {
        System.out.println("=== JAGGED ARRAY - FOREACH İLE ===\n");

        int[][] jagged = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9, 10},
                {11}
        };

        int rowNumber = 0;

        for(int[] row : jagged) {
            System.out.print("Satır " + rowNumber + " (" + row.length + " eleman): ");

            for(int element : row) {
                System.out.print(element + " ");
            }

            System.out.println();
            rowNumber++;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        // İstediğin örneği çalıştır

        example1_BasicJagged();
        // example2_ClassroomStudents();
        // example3_MonthlyDays();
        // example4_SurveySystem();
        // example5_CityDistricts();
        // example6_JaggedWithForeach();
    }
}