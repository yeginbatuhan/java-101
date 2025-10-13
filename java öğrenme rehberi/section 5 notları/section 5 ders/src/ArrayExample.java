// Dosya: src/main/java/ArrayExample.java
public class ArrayExample {
    public static void main(String[] args) {
        // Problem: 5 öğrencinin notunu saklamak istiyoruz

        // KÖTÜ YÖNTEM - Array kullanmadan
        int student1 = 85;
        int student2 = 90;
        int student3 = 78;
        int student4 = 92;
        int student5 = 88;

        // Ortalama hesaplamak için her birini ayrı yazmalıyız
        double average = (student1 + student2 + student3 + student4 + student5) / 5.0;
        System.out.println("Ortalama (kötü yöntem): " + average);

        // İYİ YÖNTEM - Array kullanarak
        int[] students = new int[5]; // 5 elemanlı integer array
        students[0] = 85;
        students[1] = 90;
        students[2] = 78;
        students[3] = 92;
        students[4] = 88;

        // Loop ile kolayca işlem yapabiliriz
        int sum = 0;
        for(int i = 0; i < students.length; i++) {
            sum += students[i];
        }
        double avgWithArray = sum / 5.0;
        System.out.println("Ortalama (array ile): " + avgWithArray);
    }
}
