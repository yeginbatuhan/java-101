// Dosya: src/main/java/ThreeDArrayDetailed.java
public class ThreeDArrayDetailed {
    public static void main(String[] args) {

        // ============================================
        // YÖNTEM 1: Boyut belirterek oluşturma
        // ============================================
        int[][][] cube1 = new int[2][3][4];
        // 2 katman, her katmanda 3 satır, her satırda 4 sütun

        // Manuel değer atama
        cube1[0][0][0] = 1;
        cube1[0][0][1] = 2;
        cube1[0][1][0] = 5;
        cube1[1][2][3] = 24;

        System.out.println("=== YÖNTEM 1: Manuel Atama ===");
        System.out.println("cube1[0][0][0] = " + cube1[0][0][0]); // 1
        System.out.println("cube1[0][0][1] = " + cube1[0][0][1]); // 2
        System.out.println("cube1[1][2][3] = " + cube1[1][2][3]); // 24


        // ============================================
        // YÖNTEM 2: Değerlerle birlikte oluşturma
        // ============================================
        int[][][] cube2 = {
                { // Katman 0 (İlk sınıf)
                        {1, 2, 3},      // Satır 0
                        {4, 5, 6}       // Satır 1
                },
                { // Katman 1 (İkinci sınıf)
                        {7, 8, 9},      // Satır 0
                        {10, 11, 12}    // Satır 1
                },
                { // Katman 2 (Üçüncü sınıf)
                        {13, 14, 15},   // Satır 0
                        {16, 17, 18}    // Satır 1
                }
        };

        System.out.println("\n=== YÖNTEM 2: Değerlerle Oluşturma ===");
        System.out.println("cube2[0][0][0] = " + cube2[0][0][0]); // 1
        System.out.println("cube2[1][1][2] = " + cube2[1][1][2]); // 12
        System.out.println("cube2[2][1][1] = " + cube2[2][1][1]); // 17


        // ============================================
        // YAZDIRMA - FOR LOOP (Üç Seviye)
        // ============================================
        System.out.println("\n=== FOR LOOP İLE YAZDIRMA ===");

        // En dış loop: katmanları dolaş
        for(int i = 0; i < cube2.length; i++) {
            System.out.println("Katman " + i + ":");

            // Orta loop: satırları dolaş
            for(int j = 0; j < cube2[i].length; j++) {

                // En iç loop: sütunları dolaş
                for(int k = 0; k < cube2[i][j].length; k++) {
                    System.out.print(cube2[i][j][k] + "\t");
                }
                System.out.println(); // Satır bitince alt satıra
            }
            System.out.println(); // Katman bitince boş satır
        }


        // ============================================
        // YAZDIRMA - FOREACH (Daha Temiz)
        // ============================================
        System.out.println("=== FOREACH İLE YAZDIRMA ===");

        int layerNumber = 0;
        // Dış foreach: her katmanı al
        for(int[][] layer : cube2) {
            System.out.println("Katman " + layerNumber + ":");

            // Orta foreach: katmandaki her satırı al
            for(int[] row : layer) {

                // İç foreach: satırdaki her elemanı al
                for(int element : row) {
                    System.out.print(element + "\t");
                }
                System.out.println();
            }
            System.out.println();
            layerNumber++;
        }


        // ============================================
        // BOYUT BİLGİLERİ
        // ============================================
        System.out.println("=== BOYUT BİLGİLERİ ===");
        System.out.println("Katman sayısı: " + cube2.length); // 3
        System.out.println("Satır sayısı (Katman 0): " + cube2[0].length); // 2
        System.out.println("Sütun sayısı (Katman 0, Satır 0): " + cube2[0][0].length); // 3


        // ============================================
        // INDEX NUMARALARI İLE YAZDIRMA
        // ============================================
        System.out.println("\n=== INDEX NUMARALARI İLE ===");
        for(int i = 0; i < cube2.length; i++) {
            System.out.println("Katman " + i + ":");
            for(int j = 0; j < cube2[i].length; j++) {
                for(int k = 0; k < cube2[i][j].length; k++) {
                    System.out.print("cube2[" + i + "][" + j + "][" + k + "]="
                            + cube2[i][j][k] + "  ");
                }
                System.out.println();
            }
            System.out.println();
        }


        // ============================================
        // GERÇEK HAYAT ÖRNEĞİ: 3 SINIFIN ÖĞRENCİ NOTLARI
        // ============================================
        System.out.println("=== 3 SINIFIN ÖĞRENCİ NOTLARI ===");

        // [Sınıf][Öğrenci][Dersler]
        int[][][] schoolGrades = {
                { // Sınıf 9A
                        {85, 90, 78}, // Ali
                        {88, 85, 92}, // Veli
                        {90, 88, 86}  // Ayşe
                },
                { // Sınıf 9B
                        {82, 87, 90},
                        {85, 89, 84},
                        {91, 86, 88}
                },
                { // Sınıf 9C
                        {88, 92, 85},
                        {86, 84, 89},
                        {93, 90, 91}
                }
        };

        String[] classNames = {"9A", "9B", "9C"};
        String[][] studentNames = {
                {"Ali", "Veli", "Ayşe"},
                {"Mehmet", "Zeynep", "Can"},
                {"Elif", "Ahmet", "Fatma"}
        };
        String[] subjects = {"Matematik", "Fizik", "Kimya"};

        // FOR LOOP ile yazdırma
        for(int classIndex = 0; classIndex < schoolGrades.length; classIndex++) {
            System.out.println("\n" + classNames[classIndex] + " Sınıfı:");
            System.out.println("-".repeat(50));

            for(int studentIndex = 0; studentIndex < schoolGrades[classIndex].length; studentIndex++) {
                System.out.print(studentNames[classIndex][studentIndex] + ": ");

                int total = 0;
                for(int subjectIndex = 0; subjectIndex < schoolGrades[classIndex][studentIndex].length; subjectIndex++) {
                    int grade = schoolGrades[classIndex][studentIndex][subjectIndex];
                    System.out.print(subjects[subjectIndex] + "=" + grade + " ");
                    total += grade;
                }

                double average = total / (double) schoolGrades[classIndex][studentIndex].length;
                System.out.printf("| Ortalama: %.1f\n", average);
            }
        }


        // FOREACH ile sınıf ortalamaları
        System.out.println("\n\n=== SINIF ORTALAMALARI (FOREACH) ===");
        int classIndex = 0;

        for(int[][] classGrades : schoolGrades) {
            int classTotal = 0;
            int studentCount = 0;

            for(int[] studentGrades : classGrades) {
                for(int grade : studentGrades) {
                    classTotal += grade;
                }
                studentCount++;
            }

            double classAverage = classTotal / (double) (studentCount * subjects.length);
            System.out.printf("%s Sınıfı Ortalaması: %.2f\n",
                    classNames[classIndex], classAverage);
            classIndex++;
        }
    }
}
