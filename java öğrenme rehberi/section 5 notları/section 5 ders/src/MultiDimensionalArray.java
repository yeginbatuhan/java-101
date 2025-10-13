// Dosya: src/main/java/MultiDimensionalArray.java
public class MultiDimensionalArray {
    public static void main(String[] args) {

        // 2D Array Oluşturma - YÖNTEM 1
        int[][] matrix1 = new int[3][3]; // 3 satır, 3 sütun

        // Değer atama
        matrix1[0][0] = 1;
        matrix1[0][1] = 2;
        matrix1[0][2] = 3;
        matrix1[1][0] = 4;
        matrix1[1][1] = 5;
        matrix1[1][2] = 6;
        matrix1[2][0] = 7;
        matrix1[2][1] = 8;
        matrix1[2][2] = 9;

        // 2D Array Oluşturma - YÖNTEM 2 (Daha pratik)
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Matris yazdırma
        System.out.println("Matris:");
        for(int i = 0; i < matrix2.length; i++) { // Satırlar
            for(int j = 0; j < matrix2[i].length; j++) { // Sütunlar
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println(); // Satır sonu
        }

        // Gerçek hayat örneği: Sınıf notları tablosu
        // 3 öğrenci, 4 ders notu
        int[][] studentGrades = {
                {85, 90, 78, 92}, // Ali'nin notları
                {88, 85, 95, 89}, // Veli'nin notları
                {92, 87, 91, 94}  // Ayşe'nin notları
        };

        String[] studentNames = {"Ali", "Veli", "Ayşe"};
        String[] subjects = {"Mat", "Fizik", "Kimya", "Bio"};

        // Tablo formatında yazdırma
        System.out.println("\n=== SINIF NOT TABLOSU ===");
        System.out.print("Öğrenci\t");
        for(String subject : subjects) {
            System.out.print(subject + "\t");
        }
        System.out.println("Ort");

        for(int i = 0; i < studentGrades.length; i++) {
            System.out.print(studentNames[i] + "\t");
            int sum = 0;
            for(int j = 0; j < studentGrades[i].length; j++) {
                System.out.print(studentGrades[i][j] + "\t");
                sum += studentGrades[i][j];
            }
            double average = sum / (double) studentGrades[i].length;
            System.out.printf("%.1f\n", average);
        }
    }

}
