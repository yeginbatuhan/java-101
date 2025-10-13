// Dosya: src/main/java/ArrayCreation.java
public class ArrayCreation {
    public static void main(String[] args) {

        // YÖNTEM 1: Boyut belirterek oluşturma
        int[] numbers1 = new int[5]; // 5 elemanlı array, başlangıç değerleri 0
        System.out.println("Yöntem 1 - İlk eleman: " + numbers1[0]); // 0

        numbers1[0] = 10;
        numbers1[1] = 20;
        numbers1[2] = 30;
        numbers1[3] = 40;
        numbers1[4] = 50;

        // YÖNTEM 2: Değerlerle birlikte oluşturma (kısa yol)
        int[] numbers2 = {10, 20, 30, 40, 50};
        System.out.println("Yöntem 2 - İlk eleman: " + numbers2[0]); // 10

        // YÖNTEM 3: new keyword ile değerlerle birlikte
        int[] numbers3 = new int[]{10, 20, 30, 40, 50};
        System.out.println("Yöntem 3 - İlk eleman: " + numbers3[0]); // 10

        // Farklı veri tipleriyle array oluşturma
        String[] names = {"Ali", "Veli", "Ayşe"};
        double[] prices = {19.99, 29.99, 39.99};
        boolean[] flags = {true, false, true, false};

        // Array uzunluğunu öğrenme
        System.out.println("Names array uzunluğu: " + names.length); // 3

        // Array elemanlarını yazdırma
        System.out.println("\nÖğrenci isimleri:");
        for(int i = 0; i < names.length; i++) {
            System.out.println((i+1) + ". " + names[i]);
        }
    }
}
